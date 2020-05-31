package hw5_18001154;

import hw5_18001154.LinkedBinaryTree;

public class ExpressionTree<E, T> extends LinkedBinaryTree<E, T> {
	public void preorderPrint(Node<E> p) {
	//pre-order traversal of tree with root p
	//tiền tố
		if(p != null) {
			System.out.print(p.getElement() + " ");
			preorderPrint(p.getLeft());
			preorderPrint(p.getRight());
		}
	}
	
	public void postorderPrint(Node<E> p) {
	//post-order traversal of tree with root p
	//hậu tố
		if(p != null) {
			postorderPrint(p.getLeft());
			postorderPrint(p.getRight());
			System.out.print(p.getElement()+ " ");
		}
	}
	public void inorderPrint(Node<E> p) {
	//in-order traversal of tree with root p
	//trung tố
		if(p != null) {
			if(p.getLeft() != null) {
				System.out.print("(");
				inorderPrint(p.getLeft());
			}
			System.out.print(p.getElement()+" ");
			if(p.getRight() != null) {
				inorderPrint(p.getRight());
				System.out.print(")");
			}
		}
	}
	
	private int giatri(Node<E> p) {
		if(p.getLeft() == null || p.getRight() == null) {
			return (Character)p.getElement() - '0';
		}
		else {
			int left = giatri(p.getLeft());
			int right = giatri(p.getRight());
			switch(((Character)p.getElement()).charValue()) {
			case '*':
				return left * right;
			case '/':
				return left / right;
			case '+':
				return left + right;
			case '-':
				return left - right;
			}
		}
		return 0;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		ExpressionTree<Character, Node> ext = new ExpressionTree<Character, Node>();
		Node a = ext.addRoot('+');
		Node b = ext.addLeft(a, '/');
		Node c = ext.addRight(a, '*');
		ext.addLeft(b, '-');
		ext.addRight(b, '3');
		ext.addLeft(b, '2');
		ext.addRight(b, '1');
		ext.addLeft(c, '5');
		ext.addRight(c, '4');
		System.out.println("Pre-Order Traversal :");
		ext.preorderPrint(a);
		System.out.println();
		System.out.println("Post-Order Traversal : ");
		ext.postorderPrint(a);
		System.out.println();
		System.out.println("In-Order Traversal :");
		ext.inorderPrint(a);
		System.out.println();
		System.out.println("Value of expression tree : ");
		System.out.println(ext.giatri(a));
	}

}
