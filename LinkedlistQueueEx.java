package hw4_18001154;

public class LinkedlistQueueEx {
	public static void main(String[] args) {
		LinkedlistQueue<Integer> queue = new LinkedlistQueue<>();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		
		System.out.println("Print Queue : ");
		queue.printQueue();
		
		System.out.println("Print Queue after : ");
		queue.dequeue();
		queue.dequeue();
		queue.printQueue();
	}

}
