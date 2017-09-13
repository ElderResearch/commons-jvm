/*******************************************************************************
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.datamininglab.commons.lang;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Supplier;

import org.apache.commons.lang3.StringUtils;

import lombok.val;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

/**
 * Static container for utilities associated with accessing class components via reflection.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since April 29, 2011
 */
@Log4j2
@UtilityClass
public class ReflectionUtils {
	/**
	 * Gets the declared field with name <tt>name</tt> and sets it to be accessible.
	 * @param c the class
	 * @param name the field name
	 * @return the field, or <tt>null</tt> if there was a problem getting the field or accessing it
	 */
	public Field getField(Class<?> c, String name) {
		if (c == null || name == null) { return null; }
		
		try {
			Field f = c.getDeclaredField(name);
			f.setAccessible(true);
			return f;
		} catch (NoSuchFieldException e) {
			return null;
		}
	}

	/**
	 * Gets the declared fields with name <tt>name</tt> and attempts to set each one of them as being accessible.
	 * 
	 * @param c class to query
	 * @return the set of fields as an array. If none are found, the an empty array is returned. If changing the 
	 * accessibility flag encounters a problem, only debug logging is performed.
	 */
	public Field[] getFields(Class<?> c) {
        if (c == null) { return null; }
        Field[] retval = null;
        retval = c.getDeclaredFields();
		for (Field f : retval) {
		    try {
		        f.setAccessible(true);
		    } catch (SecurityException ex) {
		    	log.debug("Couldn't modify accessibility of field {}", f);                    
		    }
		}
		return retval;
	}
	
	/**
	 * Gets the value of the field for the specified object.  This method silently returns
	 * <tt>null</tt> in the event of a problem getting the field value.
	 * @param f the field
	 * @param o the object instance
	 * @return the value of the field, or <tt>null</tt> if there was a problem accessing the value
	 */
	public Object get(Field f, Object o) {
		if (f == null) { return null; }
		
		try {
			return f.get(o);
		} catch (IllegalArgumentException | IllegalAccessException e) {
            log.warn("Couldn't access field {}", f, e);
		}
		return null;
	}
	
	/**
	 * Sets the value of the field for the specified object. This method returns <tt>false</tt> in
	 * the event of a problem setting the field.
	 * @param f the field
	 * @param o the object instance
	 * @param val the new value of the field
	 * @return if the field was successfully set to the new value (no exceptions were thrown)
	 */
	public boolean set(Field f, Object o, Object val) {
		if (f == null) { return false; }
		
		try {
			f.set(o, val);
			return true;
		} catch (IllegalArgumentException | IllegalAccessException e) {
			log.warn("Couldn't access field {}", f, e);
		}
		return false;
	}
	
	/**
	 * Instantiates a new instance of the class using the appropriate constructor.
	 * @param <T> the type of object to instantiate
	 * @param c the object's class
	 * @param args the arguments to pass to the constructor, or nothing to use the default constructor
	 * @return the new instance, or <tt>null</tt> if there was a problem instantiating the object
	 * @see #arg(Object)
	 */
	public <T> T newInstance(Class<T> c, ConstructorArg... args) {
		Class<?>[] types  = new Class<?>[args.length];
		Object[]   values = new Object[args.length];
		for (int i = 0; i < args.length; i++) {
			types[i]  = args[i].c;
			values[i] = args[i].o;
		}
		
		Constructor<T> ctr;
		try {
			ctr = c.getConstructor(types);
		} catch (NoSuchMethodException | SecurityException e) {
			log.warn("Could not find constructor with the provided types for {}", c, e);
			return null;
		}
		
		try {
			return ctr.newInstance(values);
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			log.warn("Could not instantiate {}", c, e);
			return null;
		}
	}
	
	/**
	 * Wraps a constructor argument, using the type provided by {@link Object#getClass()}. 
	 * @param o any parameter (<b>cannot</b> be <tt>null</tt>)
	 * @return a constructor argument
	 * @see #newInstance(Class, ConstructorArg...)
	 */
	public ConstructorArg arg(Object o) {
		return new ConstructorArg(o, o.getClass());
	}
	/**
	 * Wraps a constructor argument with an explicitly specified type.
	 * @param o any parameter (<b>can</b> be <tt>null</tt>)
	 * @param c the type of the parameter (useful for primitives that might be
	 * boxed as an <tt>Object</tt>
	 * @return a constructor argument
	 * @see #newInstance(Class, ConstructorArg...)
	 */
	public ConstructorArg arg(Object o, Class<?> c) {
		return new ConstructorArg(o, c);
	}
	
	/**
	 * Wraps a constructor argument in a class so that primitives don't get boxed
	 * automatically.
	 */
	public static final class ConstructorArg {
		private Class<?> c;
		private Object o;
		
		private ConstructorArg(Object o, Class<?> c) {
			this.o = o; this.c = c;
		}
	}
	
	/**
	 * Find the method, regardless of what arguments/parameters it takes. If the method is overloaded, the returned
	 * method will be arbitrary. The method is also set to be {@linkplain Method#setAccessible(boolean) accessible}.
	 * @param c the class
	 * @param methodName the name of the method
	 * @return the method, or <tt>null</tt> if no method with that name was found
	 */
	public Method getMethodAnyParams(Class<?> c, String methodName) {
		val match = Arrays.stream(c.getMethods()).filter($ -> StringUtils.equals($.getName(), methodName)).findAny();
		match.ifPresent($ -> $.setAccessible(true));
		return match.orElse(null);
	}
	
	/**
	 * Invokes the method with name <tt>methodName</tt> on object <tt>o</tt>.
	 * @param o the object instance
	 * @param methodName the name of the method
	 * @param args the parameters to pass to the method
	 * @return the result of the method, or <tt>null</tt> if there was a problem invoking the method
	 */
	public Object invoke(Object o, String methodName, Object... args) {
		return invoke(o, methodName, false, args);
	}
	
	/**
	 * Invokes the method with name <tt>methodName</tt> on object <tt>o</tt>. If
	 * no method named <tt>methodName</tt> is found, this will silently
	 * return <tt>null</tt> without logging a warning message
	 * @param o the object instance
	 * @param methodName the name of the method
	 * @param args the parameters to pass to the method
	 * @return the result of the method, or <tt>null</tt> if there was a problem invoking the method
	 */
	public Object invokeIfExists(Object o, String methodName, Object... args) {
		return invoke(o, methodName, true, args);
	}
	
	private Object invoke(Object o, String methodName, boolean optional, Object[] args) {
		try {
			val method = o.getClass().getMethod(methodName, getTypes(args));
			method.setAccessible(true);
			return method.invoke(o, args);
		} catch (NoSuchMethodException e) {
			if (!optional) { log.warn("Required method {} not found on type {}", methodName, o.getClass(), e); }
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | SecurityException e) {
            log.warn("Couldn't invoke method {} on type {}", methodName, o.getClass(), e);			
		}
		return null;
	}
	
	/**
	 * Gets the types of each of the objects.
	 * @param args the objects
	 * @return the object's types (classes) in the same order
	 */
	public Class<?>[] getTypes(Object... args) {
		return Arrays.stream(args).map(Object::getClass).toArray(i -> new Class<?>[i]);
	}

	/**
	 * Factory implementation that uses reflection to create new instances of
	 * type <tt>T</tt>.
	 * @param <T> the type of objects to create
	 */
	public static class ReflectionFactory<T> implements Supplier<T> {
		private Class<T> c;
		
		public ReflectionFactory(Class<T> c) { this.c = c; }
		
		@Override
		public T get() { return ReflectionUtils.newInstance(c); }
	}
}
