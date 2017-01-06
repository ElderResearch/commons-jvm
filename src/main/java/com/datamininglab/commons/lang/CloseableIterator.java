/*******************************************************************************
 * Copyright (c) 2017 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.datamininglab.commons.lang;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Iterator;

import com.datamininglab.commons.lang.LambdaUtils.IORunnable;

/**
 * Wraps an iterator but calls a callback after no more data is available (auto closing). This iterator can also be
 * closed manually before all data has been iterated over. You should generally use this in a try-with-resource
 * block so you ensure you close the iterator even if not every element is iterated over.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @param <T> the type of data being iterated over
 * @since Jan 5, 2017
 */
public class CloseableIterator<T> implements Iterator<T>, AutoCloseable {
	private Iterator<T> iter;
	private IORunnable closer;
	
	/**
	 * Creates a new closeable iterator. 
	 * @param iter the wrapped iterator
	 * @param closer the close callback. If this is <tt>null</tt>, you must subclass this class and override {@link #close()}.
	 */
	public CloseableIterator(Iterator<T> iter, IORunnable closer) {
		this.iter = iter;
		this.closer = closer;
	}
	
	@Override
	public boolean hasNext() {
		if (iter.hasNext()) { return true; }
		
		// Auto close once the iterator doesn't have any more data to return
		try {
			close();
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
		return false;
	}
	
	@Override
	public T next() {
		return iter.next();
	}
	
	@Override
	public void remove() {
		iter.remove();
	}
	
	@Override
	public void close() throws IOException {
		closer.run();
	}
}
