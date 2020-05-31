package hw7_18001154;

public class LinkedListSearchingTest {
	public static void main(String[] args) {
		LinkedlistSearching<Integer> test = new LinkedlistSearching<>();
		test.add(1);
		test.add(2);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		
		System.out.println("size = "+test.size());
		for(int i = 0; i < test.size(); i++) {
			System.out.println(test.get(i) + " ");
		}
		System.out.println();
		test.isContain(5);
		test.isContain(1);
	}

}
