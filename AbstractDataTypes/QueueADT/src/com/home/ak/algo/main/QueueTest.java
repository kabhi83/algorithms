/**
 * 
 */
package com.home.ak.algo.main;

import com.home.ak.algo.exception.QueueEmptyException;
import com.home.ak.algo.exception.QueueOverflowException;
import com.home.ak.algo.queue.IQueue;
import com.home.ak.algo.queue.LinklistQueue;

/**
 * @author abhi
 *
 */
public class QueueTest {

	/**
	 * @param args
	 * @throws QueueOverflowException 
	 * @throws QueueEmptyException 
	 * @throws StackOverflowException 
	 * @throws StackEmptyException 
	 */
	public static void main(String[] args) throws QueueOverflowException, QueueEmptyException {
		//IQueue<Integer> queue = new ArrayQueue<>(5);
		IQueue<Integer> queue = new LinklistQueue<>(5);
		
		queue.enqueue(32);
		queue.enqueue(33);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		
		queue.enqueue(32);
		queue.enqueue(33);
		queue.enqueue(34);
		queue.enqueue(35);
		queue.enqueue(36);
		System.out.println(queue.front());
	}

}
