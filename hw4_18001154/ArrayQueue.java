package hw4_18001154;

import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {
	private E[] queue;
	private int n = 0;
	private int top = 0;
	private int count = 0;
	private int default_size = 100;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity) {
		// TODO Auto-generated constructor stub
		n = capacity;
		queue = (E[]) new Object[capacity];
	}
	
	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		n = default_size;
		queue = (E[]) new Object[default_size];
	}
	
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new ArrayQueueIterator();
	}

	@Override
	public void enqueue(E element) throws IllegalStateException{
		// TODO Auto-generated method stub
		if(count == queue.length) throw new IllegalStateException("Queue is full");
		int avail = (top + count) % queue.length;
		queue[avail] = element;
		count++;
		
	}

	@Override
	public E dequeue() {
		// xoá phần tử đầu ko phải lấy
		if(isEmpty()) return null;
		E temp = queue[top];
		top = (top+1)%n;
		count--;
		return temp;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return count == 0;
	}
	
	class ArrayQueueIterator implements Iterator<E>{
		private int current = top;
		private int num = 0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return num < count;
		}
		@Override
		public E next() {
			// TODO Auto-generated method stub
			E data = queue[(current + num) % n];
			num++;
			return data;
		}	
	}
	public void printQueue() {
 		Iterator<E> iterator = iterator();
 		while (iterator.hasNext()) {
 			E value = iterator.next();
 			System.out.println(value);
 		}
	}
}
