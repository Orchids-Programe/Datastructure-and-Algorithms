package hw5_18001154;

import java.io.IOException;

public class ArrayBinaryTreeTest {
	public static void main(String[] args) throws IOException{
		ArrayBinaryTree<String, Integer> tree = new ArrayBinaryTree<String, Integer>();
		tree.setRoot("A");
		tree.setLeft(1, "B");
		tree.setRight(1, "C");
		tree.setLeft(2, "D");
		tree.setRight(2, "E");
		tree.setLeft(3, "F");
		tree.setRight(3, "K");
		
		System.out.println("Tree : ");
		
		tree.print(1, 0);
		

		tree.printFile();
		
	}

}
