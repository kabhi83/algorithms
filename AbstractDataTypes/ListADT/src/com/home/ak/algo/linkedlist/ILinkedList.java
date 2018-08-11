/**
 * 
 */
package com.home.ak.algo.linkedlist;

/**
 * @author Abhi
 * 
 */
public interface ILinkedList<E> {

	public void addFirst(E e);
	
	public void addLast(E e);

	public void add(int index, E e);

	public boolean contains(E e);

	public E get(int index);

	public int indexOf(E e);

	public boolean isEmpty();

	public int lastIndexOf(E e);

	public E removeFirst(E e);
	
	public E removeLast(E e);

	public E remove(int index);

	public int size();

	public void clear();

}
