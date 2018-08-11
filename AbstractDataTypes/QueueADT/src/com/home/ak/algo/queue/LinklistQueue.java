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
public class LinklistQueue<E> implements IQueue<E> {
	
	private static class Node<E>{
		E element;
		Node<E> next;
		
		public Node(E element) {
			this.element = element;
		}
	}
	private Node<E> head, tail;
	private Integer size=0;
	private int capacity;
	

	/**
	 * @param capacity
	 */
	public LinklistQueue(int capacity) {
		this.capacity = capacity;
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
		if(capacity==size){
			throw new QueueOverflowException("Queue is full");
		}
		Node<E> newNode = createNode(e);
		if(null==tail){
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	@Override
	public E dequeue() throws QueueEmptyException {
		if(isEmpty()){
			throw new QueueEmptyException("Queue is empty");
		}
		Node<E> temp = head;
		head = head.next;
		size--;
		if(null==head){
			tail=null;
		}
		return temp.element;
	}

	@Override
	public E front() throws QueueEmptyException {
		if(isEmpty()){
			throw new QueueEmptyException("Queue is empty");
		}
		return head.element;
	}
	
	private Node<E> createNode(E e){
		return new Node<E>(e);
	}

}
