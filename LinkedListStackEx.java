package hw4_18001154;

public class LinkedListStackEx {
	public static void main(String[] args) {
		LinkedlistStack<Integer> stack = new LinkedlistStack<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		
		System.out.println("Print Stack ");
		stack.printStack();
		
		System.out.println("Top is "+stack.top());
		
		stack.pop();
		stack.pop();
		stack.printStack();
	}
	
	

}
