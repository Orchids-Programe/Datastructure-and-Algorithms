package hw4_18001154;

import java.util.Iterator;

public class ArrayStackEx {
	public static void main(String[] args) {
		ArrayStack<Integer> stack = new ArrayStack<Integer>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println(stack.size());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
		//System.out.println(stack.pop());
		
		Iterator<Integer> it = stack.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}			
	}
}
