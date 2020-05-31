package hw7_18001154;

import java.util.Iterator;

public class ArraySearching<T extends Comparable<T>> implements InterfaceSearching<T> {

	private T[] array;
	private int n;
	private int default_size = 1000;
	
	
	
	public ArraySearching(int capacity) {
		array = (T[]) new Comparable[capacity];
	}
	

	public ArraySearching() {
		// TODO Auto-generated constructor stub
		array = (T[]) new Comparable[default_size];
	}


	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		Iterator<T> iterator = new Iterator<T>() {
			private int currentIndex = 0;

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return (currentIndex < n) && array[currentIndex] != null;
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				if(hasNext()) {
					return array[currentIndex];
				}
				return null;
			}
			
		};
		return iterator;
	}

	@Override
	public void add(T data) {
		// TODO Auto-generated method stub
		n++;
		this.array[n-1] = data;
		
	}

	@Override
	public T get(int i) {
		// TODO Auto-generated method stub
		if(i < n) {
			return array[i];
		}
		return null;
	}

	@Override
	public void set(int i, T data) {
		// TODO Auto-generated method stub
		if(i < 0 || i >= n) {
			System.out.println("Out of range");
		}
		else {
			array[i] = data;
		}
		
	}

	@Override
	public void remove(T data) {
		// TODO Auto-generated method stub
		for(int i = 0; i < array.length; i++) {
			if(data.equals(array[i])) {
				for(int j = i; j < array.length-1; j++) {
					array[j] = array[j+1];
				}
				array[n] = null;
				n--;
			}
		}
		
	}

	@Override
	public void isContain(T data) {
		// TODO Auto-generated method stub
		int i = 0;
		while(i < array.length && array[i] != data) {
			i++;
		}
		if(i > array.length-1) {
			System.out.println("not found");
		}
		else {
			System.out.println("Element found at index "+i);
		}
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return n;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return n == 0;
	}
	
	public int index(T data) {
		for(int i = 0; i < n; i++) {
			if(array[i].equals(data)) {
				return i;
			}
		}
		return -1;
	}
	

}
