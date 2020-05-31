package hw4_18001154;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedlistQueue<E> implements QueueInterface<E> {
	private Node first;
	private Node last;
	private int n;
	
	class Node{
		E element;
		Node next;
	}
	
	public LinkedlistQueue() {
		// TODO Auto-generated constructor stub
		first = null;
		last = null;
		n = 0;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new StackIterator();
	}

	@Override
	public void enqueue(E element) {
		// TODO Auto-generated method stub
		Node oldlast = last;
		last = new Node();
		last.element = element;
		last.next = null;
		if(isEmpty()) first = last;
		else {
			oldlast.next = last;
		}
		n++;
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		if(isEmpty()) throw new NoSuchElementException("Queue underflow");
		E element = first.element;
		first = first.next;
		n--;
		if(isEmpty()) last = null;
		return element;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return first == null;
	}
	
	public int size() {
		return n;
	}
	
	class StackIterator implements Iterator<E>{
		private Node current = first;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			if(!hasNext()) throw new NoSuchElementException();
			E element = current.element;
			current = current.next;
			return element;
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
