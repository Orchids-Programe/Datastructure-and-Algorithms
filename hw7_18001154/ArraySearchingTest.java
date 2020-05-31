package hw7_18001154;

import java.util.Iterator;

public class ArraySearchingTest {
	public static void main(String[] args) {
		ArraySearching<Integer> test = new ArraySearching<Integer>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		
		System.out.println("size = "+test.size());
//		Iterator<Integer> iterator = test.iterator();
//		while(iterator.hasNext()) {
//			System.out.print(iterator.next()+ " ");
//		}
		System.out.println();
		test.isContain(3);
		
		
	}

}
