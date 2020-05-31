package hw7_18001154;

import hw7_18001154.BinarySearchTree.Node;

public class BinarysearchTreeTest {
	
	public static void main(String[] args) {
		BinarySearchTree<String, Node> test = new BinarySearchTree<>();
		test.addRoot("A");
		test.insert("B", test.root());
		test.insert("C", test.root());
		test.insert("D", test.root());
		test.insert("E", test.root());
		test.insert("F", test.root());
		test.insert("G", test.root());
		test.insert("H", test.root());
		
		System.out.println();
		test.print(test.root(), 0);
	}

}
