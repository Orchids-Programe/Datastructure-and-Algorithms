package hw5_18001154;

import java.io.IOException;

public class LinkedBinaryTreeTest<E,T> extends LinkedBinaryTree<E, T> {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws IOException {
		LinkedBinaryTree<Integer, Node> tree = new LinkedBinaryTree<Integer, Node>();
		Node a = tree.addRoot(1);
		Node b = tree.addLeft(a, 5);
		Node c = tree.addRight(a, 3);
		
		tree.addLeft(b, 8);
		tree.addRight(b, 6);
		tree.addLeft(c, 2);
		tree.addRight(c, 7);
		System.out.println(tree.numChildren(a));
		
		tree.print(a, 2);
		tree.printFile();
	
	}

}
