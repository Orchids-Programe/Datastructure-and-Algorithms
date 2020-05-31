package hw5_18001154;

import java.io.FileWriter;
import java.io.IOException;

public class LinkedBinaryTree<E,T> implements BinaryTreeInterface<T> {
	private String outfile = " ";
	protected static class Node<E>{
		private E element;
		private Node<E> parent;
		private Node<E> left;
		private Node<E> right;
		public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
			this.element = e;
			this.parent = above;
			this.left = leftChild;
			this.right = rightChild;
		}
		
		public void setElement(E element) {
			this.element = element;
		}

		public void setParent(Node<E> parent) {
			this.parent = parent;
		}

		public void setLeft(Node<E> left) {
			this.left = left;
		}

		public void setRight(Node<E> right) {
			this.right = right;
		}

		public E getElement() {
			return element;
		}
		public Node<E> getParent() {
			return parent;
		}
		public Node<E> getLeft() {
			return left;
		}
		public Node<E> getRight() {
			return right;
		}
	}
	
	Node<E> root = null;
	private int n= 0;
	
	@SuppressWarnings("unchecked")
	@Override
	public T root() {
		// TODO Auto-generated method stub
		return (T) root;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return n;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return n == 0;
	}
	@SuppressWarnings({ "rawtypes", "unused" })
	@Override
	public int numChildren(T p) {
		// TODO Auto-generated method stub
		if(!(p instanceof Node)) return -1;
		Node k = (Node) p;
		if(isEmpty()) return -1;
		if(k == null) return -1;
		int count = 0;
		if(k.getLeft() != null)
			count++;
		if(k.getRight() != null)
			count++;
		return count;
	}
	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	@Override
	public T parent(T p) {
		// TODO Auto-generated method stub
		if(!(p instanceof Node)) return null;
		Node k = (Node) p;
		if(isEmpty()) return null;
		if(k == null) return null;
		return (T) k.getParent();
	}
	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public T left(T p) {
		// TODO Auto-generated method stub
		if(!(p instanceof Node)) return null;
		Node<E> k = (Node<E>) p;
		if(isEmpty()) return null;
		if(k == null) return null;
		return (T) k.getLeft();
	}
	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public T right(T p) {
		// TODO Auto-generated method stub
		if(!(p instanceof Node)) return null;
		Node<E> k = (Node<E>) p;
		if(isEmpty()) return null;
		if(k == null) return null;
		return (T) k.getRight();
	}
	@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
	@Override
	public T sibling(T p) {
		// TODO Auto-generated method stub
		if(!(p instanceof Node)) return null;
		Node k = (Node<E>) p;
		if(isEmpty()) return null;
		if(k == null) return null;
		if(k == k.getParent().getLeft()) return (T) k.getParent().getRight();
		else 
			return (T) k.getParent().getLeft();
	}
	
	public Node<E> addRoot(E element){
		if(size() == 0) {
			Node<E> node = new Node<E>(element, null, null, null);
			root = node;
			n++;
		} else
			set(root, element);
		return root;
	}
	public Node<E> addLeft(Node<E> p, E element){
		if(size() == 0 || p == null) return null;
		if(p.getLeft() == null) {
			Node<E> node = new Node<E>(element, p, null, null);
			p.setLeft(node);
			n++;
		} else set(p.getLeft(), element);
		return p.getLeft();
	}
	public Node<E> addRight(Node<E> p, E element){
		if(size() == 0 || p == null) return null;
		if(p.getRight() == null) {
			Node<E> node = new Node<E>(element, p, null, null);
			p.setRight(node);
			n++;
		} else set(p.getRight(), element);
		return p.getRight();
	}
	public void set(Node<E> p, E element) {
		if(size() == 0 || p == null) return;
		p.setElement(element);
	}
	
	public void print(Node<E> p, int level) {
		if(p == null) return;
		print(p.getRight(), level+1);
		for(int i = 0; i < level; i++) {
			System.out.print("\t");
		}
		System.out.println(p.getElement());
		print(p.getLeft(), level+1);
	}
	
	public void prinText(Node<E> p, int level) {
		if(p == null) return;
		prinText(p.getRight(), level + 1);
		for(int i = 0; i < level; i++) {
			outfile += "\t";
		}
		outfile += p.getElement() + "\n";
		prinText(p.getLeft(), level + 1);
	}
	
	public void printFile() throws IOException{
		outfile = "";
		prinText(root, 0);
		FileWriter myWriter = new FileWriter("/E:/Java Code/Code/src/hw5_18001154/Linkedbinarytree.txt/");
		myWriter.write("This is a binary tree printed using LinkedBinaryTree " + "\n");
		
	    myWriter.write(outfile);
	    myWriter.close();
	}
	
}

