package hw4_18001154;

import java.util.Iterator;

public class LinkedlistStack<E> implements StackInterface<E> {
	private int n = 0;

	class Node {  	
		E element; 
 		Node next; 
 		} 
 
 	Node stack = null; 
 	public LinkedlistStack() {
		// TODO Auto-generated constructor stub
 		this.stack = null;
	}
 	@SuppressWarnings("unused")
	@Override 
 	//Add an element to stack
 	public void push(E element) {  	 
 		Node node = new Node();
 		if(node == null) {
 			System.out.println("\nHeap Overflow");
 			return;
 		}
 		node.element = element; //set data
 		node.next = stack; //set link
 		stack = node; //update top
 	} 
 
 	@Override  	
 	//Remove an element from stack
	public E pop() { 
 		Node node = stack;
 		if(stack ==null) {
 			System.out.println("\nStack Overflow");
 			return null;
 		}
 		stack = stack.next;
 		return node.element;
 	}
 
 	@Override 
 	//Check empty
 	public boolean isEmpty() { 
 	 		return stack == null; 
 		} 

 	@Override 
 	//Return top element in a stack
 	public E top() { 
 		if(!isEmpty()) {
 			return stack.element;
 		}else {
 			System.out.println("Stack is empty!");
 	 		return null;
 		}
 	}
 
 	@Override 
 	public Iterator<E> iterator() {  	 		
 	 		return new StackIterator(); 
 	} 
 	
 	class StackIterator implements Iterator<E> {  	

 		private Node currentNode = stack; 

 		@Override 
 		public boolean hasNext() { 
 			// TODO Auto-generated method stub 
 			return currentNode != null; 
 		} 
 		@Override  	 	
 		public E next() { 
 			// TODO Auto-generated method stub  	 	 	
 			E data = currentNode.element;  	 	 					
 			currentNode = currentNode.next;  	 	 	
 			return data; 
 		} 
 	}
 	
 	public int size() {
		return n;
	}
 	
 	public void printStack() {
 		Iterator<E> iterator = iterator();
 		while (iterator.hasNext()) {
 			E value = iterator.next();
 			System.out.println(value);
 		}
 	} 
}
