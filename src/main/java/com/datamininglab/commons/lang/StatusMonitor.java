/*******************************************************************************
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.datamininglab.commons.lang;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


/**
 * Provides a mechanism for tracking status and progress on long-running tasks
 * and notifying listeners.
 * 
 * @author <a href="dimeo@datamininglab.com">John Dimeo</a>
 * @since Jun 29, 2012
 */
public class StatusMonitor {
	/**
	 * Constant indicating a task has an indeterminate size.
	 * @see #isIndeterminate()
	 */
	public static final long INDETERMINATE = Long.MIN_VALUE;
	
	/** Enumerates the states of a task of work. */
	public enum TaskState {
		/** The task has been created but not started. */
		PENDING,
		/** The task has been created and scheduled to start, but has not started. */
		SCHEDULED,
		/** The task has been started and is doing its work. */
		RUNNING,
		/** The task completed normally. */
		FINISHED,
		/** The user canceled the task. */
		CANCELED,
		/** An error was encountered while the task was doing its work. */
		ERROR
	}
	
	private List<SMListenerWrapper> listeners;
	private volatile boolean inAtomicUpdate;
	
	private Object    name;
	private TaskState state;
	private String    status;
	private long      progress;
	private long      size;
	
	/**
	 * Creates a new status monitor that monitors the progress of some task.
	 */
	public StatusMonitor() { this(null); }
	
	/**
	 * Creates a new status monitor that monitors the progress of some task and
	 * notifies each listener in <tt>listeners</tt> of any change in state,
	 * status, or progress.
	 * @param name the name of the task to monitor (can be <tt>null</tt>)
	 */
	public StatusMonitor(Object name) {
		this.name  = name;
		this.state = TaskState.PENDING;
		this.size  = INDETERMINATE;
		listeners  = new LinkedList<>();
	}
	
	/**
	 * Adds a listener to the list of listeners that will be
	 * notified when the state, status, or progress of this
	 * monitor is changed.
	 * @param listener the listener
	 * @return this for method chaining 
	 */
	public StatusMonitor addListener(StatusListener listener) {
		listeners.add(new SMListenerWrapper(listener));
		return this;
	}
	
	private StatusMonitor notifyListeners(boolean forceNotify) {
		if (inAtomicUpdate) { return this; }
		for (SMListenerWrapper sml : listeners) {
			if (forceNotify || sml.shouldNotify()) { sml.notify(this); }
		}
		return this;
	}
	
	/**
	 * Begins an atomic/"transactional" status update. Any changes to the status
	 * of this task will not be sent to the listeners until a call to {@link #end()},
	 * at which point listeners will be notified regardless of their update
	 * interval.
	 * @return this for method chaining
	 */
	public StatusMonitor begin() {
		inAtomicUpdate = true;
		return this;
	}
	
	/**
	 * Ends an atomic/"transactional" status update and notifies listeners with
	 * the current state.
	 * @return this for method chaining
	 * @see #begin()
	 */
	public StatusMonitor end() {
		inAtomicUpdate = false;
		return notifyListeners(true);
	}

	/**
	 * Gets the name of the task that this status monitor is monitoring.
	 * @return this monitor's task name
	 */
	public String getName() { return Objects.toString(name, "-"); }
	
	/**
	 * Returns the current task state.
	 * @return the current state
	 */
	public TaskState getState() { return state; }
	
	/**
	 * Gets a string describing the current operation or
	 * status of the task, for example <tt>"Reading file..."</tt>.
	 * @return the current status of this task
	 */
	public String getStatus() { return status; }
	
	/**
	 * Gets the current progress of the task. A <tt>-1</tt>
	 * is used to indicate this task has made indeterminate
	 * progress.
	 * @return this task's progress
	 */
	public long getProgress() { return progress; }
	
	/**
	 * Gets the number of operations that must be performed
	 * before the task will be finished.
	 * @return this task's size, or {@link #INDETERMINATE} if this task can run
	 * indefinitely or its size is not known
	 */
	public long getSize() { return size; }
	
	/**
	 * Changes the state of the task.
	 * @param state the current state of the task
	 * @return this for method chaining
	 * @see #getState() Description of the states
	 */
	public StatusMonitor setState(TaskState state) {
		setStateSilent(state);
		return notifyListeners(false);
	}
	
	/**
	 * Chan ges the state without notifying listeners. Use with caution.
	 * @param state the current state of the task
	 * @see #getState() Description of the states
	 */
	public void setStateSilent(TaskState state) {
		this.state = state;
	}
	
	/**
	 * Sets a string describing the current operation or
	 * status of this task, for example <tt>"Reading file..."</tt>.
	 * Usually this string ends in an ellipsis (<tt>"..."</tt>). The
	 * task's controller is notified that this task's status
	 * has changed.
	 * @param status the current status of the task
	 * @return this for method chaining
	 */
	public StatusMonitor setStatus(String status) {
		this.status = status;
		return notifyListeners(false);
	}
	
	/**
	 * Sets a string describing the current operation or
	 * status of this task, for example <tt>"Reading file..."</tt>.
	 * Usually this string ends in an ellipsis (<tt>"..."</tt>). The
	 * task's controller is notified that this task's status
	 * has changed.
	 * @param status the current status of the task
	 * @param args the format arguments passed to
	 * {@link String#format(String, Object...)}
	 * @return this for method chaining
	 */
	public StatusMonitor setStatus(String status, Object... args) {
		return setStatus(String.format(status, args));
	}
	
	/**
	 * Sets or increments the current progress of the task.
	 * @param progress the amount of progress that has been made
	 * @param relative if <tt>relative</tt> is <tt>true</tt>,
	 * <tt>progress</tt> will be added to the current task's progress;
	 * otherwise, the task's progress will be set to <tt>progress</tt>
	 * @return this for method chaining
	 */
	public StatusMonitor setProgress(long progress, boolean relative) {
		this.progress = relative? (this.progress + progress) : progress;
		return notifyListeners(false);
	}
	
	/**
	 * Sets the number of operations that must be performed
	 * before the task will be finished. Use {@link #INDETERMINATE} to
	 * indicate that a task has an indeterminate size.
	 * @param size the size of this task
	 * @return this for method chaining
	 */
	public StatusMonitor setSize(long size) {
		this.size = size;
		return notifyListeners(false);
	}
	
	/**
	 * Convenience method that sets the size to an indeterminate size, sets the
	 * status to <tt>status</tt>, and changes the state to {@link TaskState#RUNNING}
	 * in an atomic operation.
	 * @param status the new task status
	 * @param args the format arguments passed to
	 * {@link String#format(String, Object...)}
	 * @return this for method chaining
	 */
	public StatusMonitor newTask(String status, Object... args) {
		return begin().newTask().setSize(INDETERMINATE).setStatus(status, args).end();
	}
	
	/**
	 * Convenience method that sets the size of the new task, resets the progress
	 * to <tt>0L</tt>, sets the status to <tt>status</tt>, and changes the state
	 * to {@link TaskState#RUNNING} in an atomic operation.
	 * @param status the new task status
	 * @param size the new task's size
	 * @return this for method chaining
	 */
	public StatusMonitor newTask(String status, long size) {
		return begin().newTask().setSize(size).setProgress(0L, false).setStatus(status).end();
	}
	
	private StatusMonitor newTask() {
		if (!isDead()) { setState(TaskState.RUNNING); }
		return this;
	}
	
	/**
	 * Updates the task state to {@link TaskState#FINISHED} and the status to
	 * <tt>"Done."</tt>. It is recommended you always invoke this method when a
	 * task completes normally for a consistent user experience.
	 * @return this for method chaining
	 */
	public StatusMonitor setFinished() {
		if (isRunning()) {
			begin().setState(TaskState.FINISHED).setStatus("Done.").end();
		}
		return this;
	}
	
	/**
	 * Convenience method that updates the task state to {@link TaskState#CANCELED}
	 * and the status to <tt>reason</tt> in an atomic operation.
	 * @param reason the reason the task was canceled
	 * @return this for method chaining
	 */
	public StatusMonitor setCanceled(String reason) {
		return begin().setState(TaskState.CANCELED).setStatus(reason).end();
	}
	
	/**
	 * Convenience method that updates the task state to {@link TaskState#ERROR}
	 * and the status to <tt>error</tt> in an atomic operation.
	 * @param error the error message
	 * @return this for method chaining
	 */
	public StatusMonitor setError(String error) {
		return begin().setState(TaskState.ERROR).setStatus(error).end();
	}
	
	/**
	 * Returns whether the task has an indeterminate size.
	 * @return if this task is indeterminate
	 */
	public boolean isIndeterminate() {
		return getSize() == INDETERMINATE;
	}
	
	/**
	 * Convenience method to see if the task is still running.
	 * This is equivalent to <tt>{@link #getState()} == {@link TaskState#RUNNING}</tt>.
	 * @return if the task is running
	 */
	public boolean isRunning() {
		return getState() == TaskState.RUNNING;
	}
	
	/**
	 * Convenience method to see if the task is dead, meaning it is in one
	 * of the {@link TaskState#CANCELED}, {@link TaskState#FINISHED}, or
	 * {@link TaskState#ERROR} states.
	 * @return if the task is dead
	 */
	public boolean isDead() {
		return getState() == TaskState.CANCELED
		    || getState() == TaskState.FINISHED
		    || getState() == TaskState.ERROR;
	}
	
	private static class SMListenerWrapper {
		private StatusListener listener;
		private long notifyInterval;
		private volatile long lastNotified;
		
		SMListenerWrapper(StatusListener l) {
			this.listener = l;
			this.notifyInterval = l.getNotifyIntervalNS();
		}
		
		boolean shouldNotify() {
			return System.nanoTime() - lastNotified > notifyInterval;
		}
		
		void notify(StatusMonitor sm) {
			lastNotified = System.nanoTime();
			listener.statusChanged(sm);
		}
	}
}
