package hw3;

import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {
	private T[] array;
	private int n = 0;
	private int defaultSize = 100;
	
	@SuppressWarnings("unchecked")
	public SimpleArrayList() {
		array = (T[]) new Object[defaultSize];
	}
	
	@SuppressWarnings("unchecked")
	public SimpleArrayList(int capacity) {
		array = (T[]) new Object[capacity];
	}
	
	public void add(T data) {
		n++;
		this.array[n-1] = data;
	}
	
	public T get(int i) {
		if(i < n) {
			return array[i];
		}
		return null;
	}
	
	public void set(int i, T data) {
		if(i < 0 || i >= n) {
			System.out.println("Out of range");
		}
		else {
			array[i] = data;
		}
	}
	public void remove(T data) {
		for(int i = 0; i < n; i++) {
			if(data.equals(array[i])) {
				for(int k = i; k < n-1; k++) {
					array[k] = array[k+1];
				}
				array[n] = null;
				n--;
			}
		}
	}
	
	public int size() {
		return n;
	}
	
	public Iterator<T> iterator(){
		Iterator<T> a = new Iterator<T>() {
			private int currentIndex = 0;

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return currentIndex < n && array[currentIndex] != null;
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				return array[currentIndex++];
			}
			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
			
		};
		return a;
		
	}

	@Override
	public boolean isContain(T data) {
		// TODO Auto-generated method stub
		for(int i = 0; i < n; i++) {
			if(data.equals(array[i])) {
				return true;
			}
		}
		return false;
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return n == 0;
	}

	public int indexOf(T data) {
		for(int i = 0; i < n; i++) {
			if(array[i].equals(data))
				return i;
		}
		return -1;
	}

}
