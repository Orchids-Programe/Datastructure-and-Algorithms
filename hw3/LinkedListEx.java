package hw3;

public class LinkedListEx {
	public static void main(String[] args) {
	LinkedList<Integer> linkedlist = new LinkedList<Integer>();
	System.out.println("Demo");
	linkedlist.addBot(10);
	linkedlist.addBot(20);
	linkedlist.addBot(15);
	//linkedlist.display();
		
	
	linkedlist.removeBot();
	linkedlist.display();
	linkedlist.removeTop();
	linkedlist.display();
	linkedlist.removeBot();
	linkedlist.display();
	
	linkedlist.remove(10);
	linkedlist.display();
	}
}
