/**
 * 
 */
package com.home.ak.algo.queue;

import com.home.ak.algo.exception.QueueEmptyException;
import com.home.ak.algo.exception.QueueOverflowException;

/**
 * @author abhi
 *
 */
public interface IQueue<E> {
	
	public boolean isEmpty();
	
	public Integer size();
	
	public void enqueue(E e) throws QueueOverflowException;
	
	public E dequeue() throws QueueEmptyException;
	
	public E front() throws QueueEmptyException;

}
