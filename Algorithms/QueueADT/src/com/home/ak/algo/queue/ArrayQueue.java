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
public class ArrayQueue<E> implements IQueue<E> {
	
	private static final Integer INITIAL_CAPACITY = 100;
	
	private E[] queue = null;
	
	private Integer N;
	
	private Integer front = 0, rear =0, size=0;
	
	/**
	 * 
	 */
	public ArrayQueue() {
		this(INITIAL_CAPACITY);
	}
	
	/**
	 * @param capacity
	 */
	@SuppressWarnings("unchecked")
	public ArrayQueue(Integer capacity) {
		this.N = capacity;
		queue = (E[])new Object[N];
	}

	@Override
	public boolean isEmpty() {
		return (size==0);
	}

	@Override
	public Integer size() {
		return size;
	}

	@Override
	public void enqueue(E e) throws QueueOverflowException {
		if(size==N){
			throw new QueueOverflowException("Queue is full");
		}
		queue[rear] = e;
		rear = (rear+1)%N; 
		size++;
	}

	@Override
	public E dequeue() throws QueueEmptyException {
		if(isEmpty()){
			throw new QueueEmptyException("Queue is empty");
		}
		E temp = queue[front];
		queue[front]= null;
		front = (front+1)%N; 
		size--;
		return temp;
	}

	@Override
	public E front() throws QueueEmptyException {
		if(isEmpty()){
			throw new QueueEmptyException("Queue is empty");
		}
		return queue[front];
	}

}
