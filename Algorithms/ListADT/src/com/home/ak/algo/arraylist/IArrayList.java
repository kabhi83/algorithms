/**
 * 
 */
package com.home.ak.algo.arraylist;

/**
 * @author Abhi
 * 
 */
public interface IArrayList<E> {

	public void add(E e);

	public void add(int index, E e);

	public boolean contains(E e);

	public E get(int index);

	public int indexOf(E e);

	public boolean isEmpty();

	public int lastIndexOf(E e);

	public boolean remove(E e);

	public E remove(int index);

	public int size();

	public void clear();

}
