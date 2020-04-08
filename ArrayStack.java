package hw4_18001154;

import java.util.Iterator;

public class ArrayStack<E> implements StackInterface<E>{
	public static final int CAPACITY = 1000;
	private E[] data;
	private int n = -1;
	
	public ArrayStack() {
		// TODO Auto-generated constructor stub
		this(CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		// TODO Auto-generated constructor stub
		data = (E[]) new Object[capacity];
	}
	
	public int size() {
		return n + 1;
	}

	@SuppressWarnings("unused")
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		Iterator<E> it = new Iterator<E>() {
			int currentInt = 0;
			@Override
			public boolean hasNext() {
				return currentInt < data.length && data[currentInt] != null;
			}

			@Override
			public E next() {
				// TODO Auto-generated method stub
				return data[currentInt++];
			}
		};
		return it;
	}

	@Override
	public void push(E i) throws IllegalStateException{
		// TODO Auto-generated method stub
		if(size() == data.length) throw new IllegalStateException("Stack is full");
		data[++n] = i;
		
		
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;
		E answer = data[n];
		data[n] = null;
		n--;
		return answer;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return n == -1;
	}

	@Override
	public E top() {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;
		return data[n];
	}
	
//	public void printStack() {
// 		Iterator<E> iterator = iterator();
// 		while (iterator.hasNext()) {
// 			E value = iterator.next();
// 			System.out.println(value);
// 		}
//	}
	
}




