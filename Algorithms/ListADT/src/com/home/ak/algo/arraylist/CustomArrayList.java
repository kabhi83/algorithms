/**
 * 
 */
package com.home.ak.algo.arraylist;

/**
 * @author Abhi
 *
 */
public class CustomArrayList<E> implements IArrayList<E> {
	
	public static final int INITIAL_CAPACITY=16;
	
	@SuppressWarnings("unchecked")
	private E[] data = (E[])new Object[INITIAL_CAPACITY];
	
	private int size=0;
	

	/**
	 * 
	 */
	public CustomArrayList() {}

	/**
	 * @param data
	 */
	public CustomArrayList(E[] data) {
		this.data = data;
	}

	@Override
	public void add(E e) {
		add(size, e);
	}

	@Override
	public void add(int index, E e) {
		ensureCapacity();
		//Shift data to accommodate new stuff
		for(int i= size-1; i>=index; i--){
			data[i+1] = data[i];
		}
		data[index] = e;
		size++;
	}

	@Override
	public boolean contains(E e) {
		for(int i=0; i< size; i++){
			if(e.equals(data[i])){
				return true;
			}
		}
		return false;
	}

	@Override
	public E get(int index) {
		return data[index];
	}

	@Override
	public int indexOf(E e) {
		for(int i=0; i< size; i++){
			if(e.equals(data[i])){
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int lastIndexOf(E e) {
		for(int i=size-1; i>=0; i--){
			if(e.equals(data[i])){
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean remove(E e) {
		if(indexOf(e)>=0){
			remove(indexOf(e));
			return true;
		}
		return false;
	}

	@Override
	public E remove(int index) {
		E e = data[index];
		for(int j=index; j<size-1; j++){
			data[j]=data[j+1];
		}
		data[size-1]= null;
		size--;
		return e;
	}

	@Override
	public int size() {
		return size;
	}
	
	private boolean ensureCapacity(){
		if(size >= data.length){
			E[] newData = (E[])new Object[data.length*2];
			System.arraycopy(data, 0, newData, 0, data.length);
			data=newData;
		}
		return false;
	}

	@Override
	public void clear() {
		data=(E[])new Object[INITIAL_CAPACITY];
		size=0;
	}


}
