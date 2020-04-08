package hw4_18001154;

public class ArrayQueueEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayQueue<Integer> queue = new ArrayQueue<>();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		
		System.out.println("Print Queue");
		queue.printQueue();
		
		
		System.out.println("Print Queue After: ");
		queue.dequeue();
		queue.dequeue();
		queue.printQueue();
		
		
		
	}

}
