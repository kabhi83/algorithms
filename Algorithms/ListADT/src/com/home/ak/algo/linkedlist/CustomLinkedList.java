/**
 * 
 */
package com.home.ak.algo.linkedlist;

/**
 * @author Abhi
 *
 */
public class CustomLinkedList<E> implements ILinkedList<E> {

	private static class Node<E> {

		E element;

		Node<E> next;

		/**
		 * @param element
		 */
		public Node(E element) {
			this.element = element;
		}
	}

	private Node<E> head, tail;
	private int size;

	@Override
	public void addFirst(E e) {
		Node<E> newNode = createNewNode(e);
		newNode.next = head;
		head = newNode;
		size++;
		if (null == tail) {
			tail = head;
		}
	}

	@Override
	public void addLast(E e) {
		Node<E> newNode = createNewNode(e);
		if (null == tail) {
			head = tail = newNode;
		}
		tail.next = newNode;
		tail = tail.next;
	}

	@Override
	public void add(int index, E e) {
		if (index == 0) {
			addFirst(e);
		} else if (index >= size) {
			addLast(e);
		} else {
			Node<E> newNode = createNewNode(e);
			Node<E> current = head;
			for (int i = 1; i < index; i++) {
				current = current.next;
			}
			Node<E> temp = current.next;
			current.next = newNode;
			current.next.next = temp;
			size++;
		}

	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(E e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int lastIndexOf(E e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E removeFirst(E e) {
		if (size == 0) {
			return null;
		} else {
			Node<E> temp = head;
			head = head.next;
			size--;
			if (head == null) {
				tail = null;
			}
			return temp.element;
		}
	}

	@Override
	public E removeLast(E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		head = tail = null;
	}

	/**
	 * Function to reverse the linked list
	 * 
	 * @param head
	 */
	public Node<E> reverse(Node<E> head) {
		Node<E> prev = null;
		Node<E> current = head;
		Node<E> next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}

	private Node<E> createNewNode(E e) {
		Node<E> newNode = new Node<E>(e);
		return newNode;
	}

}
