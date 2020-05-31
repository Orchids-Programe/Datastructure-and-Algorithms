package hw6_18001154;

public class MinHeapPriorityQueueTest {
	public static void main(String[] args) {
		MinHeapPriorityQueue<Integer, String> test = new MinHeapPriorityQueue<>();
		test.insert(0, "Dell");
		test.insert(1, "Lenovo");
        test.insert(2, "Asus");
        test.insert(4, "Mac");
        test.insert(6, "ThinkPad");
        test.insert(5, "Logitech");
        test.printTree(0);
        System.out.println(test.min());
        test.removerMin();
        test.printTree(0);
	}
}
