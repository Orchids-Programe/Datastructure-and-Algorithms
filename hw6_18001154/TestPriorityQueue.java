package hw6_18001154;

public class TestPriorityQueue {
	public static void main(String[] args) {
		
		//Test voi danh sach cac so nguyen
		
//		SortedArrayPriorityQueue<Comparable, Integer> queue = new SortedArrayPriorityQueue<Comparable, Integer>();
//		queue.insert(2,null);
//		queue.insert(8,null);
//		queue.insert(4,null);
//		queue.insert(10,null);
//		queue.insert(7,null);
//		queue.printQueue();
//		System.out.println(queue.size());
//		System.out.println(queue.min().getKey());
//		System.out.println(queue.removeMin().getKey());
//		queue.printQueue();

		
//		SortedLinkedPriorityQueue<Comparable, Integer> queue1 = new SortedLinkedPriorityQueue<>();
//		queue1.insert(0,null);
//		queue1.insert(1,null);
//		queue1.insert(2,null);
//		queue1.printQueue();
//		System.out.println(queue1.size());
//		System.out.println(queue1.min().getKey());
//		System.out.println(queue1.removeMin().getKey());
//		queue1.printQueue();
		
		
//		UnsortedLinkedPriorityQueue<Comparable, Integer> queue2 = new UnsortedLinkedPriorityQueue<>();
//		queue2.insert(1, null);
//		queue2.insert(0,null);
//		queue2.insert(2, null);
//		queue2.insert(-1, null);
//		queue2.insert(3,null);
//		queue2.printQueue();
//		System.out.println(queue2.min().getKey());
//		System.out.println(queue2.size());
//		System.out.println(queue2.removeMin().getKey());
//		queue2.printQueue();

//		UnSortedArrayPriorityQueue<Comparable, Integer> queue3 = new UnSortedArrayPriorityQueue<>();
//		queue3.insert(2, null);
//		queue3.insert(1, null);
//		queue3.insert(0, null);
//		queue3.insert(-1, null);
//		queue3.insert(3, null);
//		queue3.printQueue();
//		System.out.println(queue3.size());
//		System.out.println(queue3.min().getKey());
//		System.out.println(queue3.removeMin().getKey());
//		queue3.printQueue();

		
		//Test voi danh sach cac doi tuong co khoa va gia tri khac nhau
//		UnSortedArrayPriorityQueue<Integer, String> Queue = new UnSortedArrayPriorityQueue<>();
//		Queue.insert(20, "Dell");
//		Queue.insert(50, "MacBookAir");
//		Queue.insert(30, "Lenovo");
//		Queue.insert(10, "Asus");
//		Queue.insert(40, "ThinkPad");
//		Queue.printQueue();
//		System.out.println(Queue.size());
//		System.out.println(Queue.min().getKey());
//		System.out.println(Queue.removeMin().getKey());
//		Queue.printQueue();
		
//		UnsortedLinkedPriorityQueue<Integer, String> Queue1 = new UnsortedLinkedPriorityQueue<>();
//		Queue1.insert(20, "Dell");
//		Queue1.insert(50, "MacBookAir");
//		Queue1.insert(30, "Lenovo");
//		Queue1.insert(10, "Asus");
//		Queue1.insert(40, "ThinkPad");
//		Queue1.printQueue();
//		System.out.println(Queue1.size());
//		System.out.println(Queue1.min().getKey());
//		System.out.println(Queue1.removeMin().getKey());
//		Queue1.printQueue();		
		
//		SortedArrayPriorityQueue<Integer, String> Queue2 = new SortedArrayPriorityQueue<>();
//		Queue2.insert(20, "Dell");
//		Queue2.insert(50, "MacBookAir");
//		Queue2.insert(30, "Lenovo");
//		Queue2.insert(10, "Asus");
//		Queue2.insert(40, "ThinkPad");
//		Queue2.printQueue();
//		System.out.println(Queue2.size());
//		System.out.println(Queue2.min().getKey());
//		System.out.println(Queue2.removeMin().getKey());
//		Queue2.printQueue();		
	
		SortedLinkedPriorityQueue<Integer, String> Queue3 = new SortedLinkedPriorityQueue<>();
		Queue3.insert(10, "Asus");
		Queue3.insert(20, "Dell");
		Queue3.insert(30, "Lenovo");
		Queue3.insert(40, "ThinkPad");
		Queue3.insert(50, "MacBookAir");
		Queue3.printQueue();
		System.out.println(Queue3.size());
		System.out.println(Queue3.min().getKey());
		System.out.println(Queue3.removeMin().getKey());
		Queue3.printQueue();	
	}

}
