package hw5_18001154;

import java.io.FileWriter;
import java.io.IOException;

public class ArrayBinaryTree<E, T> implements BinaryTreeInterface<T>{
	private String outfile = "";
	private E[] array;
	private int n = 0;
	private int defaultsize = 1000;
	
	@SuppressWarnings("unchecked")
	public ArrayBinaryTree() {
		array = (E[]) new Object[defaultsize];
	}
	
	public void setRoot(E element) {
		if(isEmpty()) {
			array[1] = element;
			n++;
		}
		else {
			array[1] = element;
		}
	}
	
	public void setLeft(int p, E element) {
		if(isEmpty()) return;
		if(p >= (array.length)/2 || array[p] == null) return;
		if(array[2*p] == null) {
			array[2*p] = element;
			n++;
		}
		else {
			array[2*p] = element;
		}
	}
	
	public void setRight(int p, E element) {
		if(isEmpty()) return;
		if(p >= (array.length-1)/2 || array[p] == null) return;
		if(array[2*p + 1] == null) {
			array[2*p+1] = element;
			n++;
		}
		else {
			array[2*p+1] = element;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T root() {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;
		else {
			return (T) Integer.valueOf(1);
		}
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

	@Override
	public int numChildren(T p) {
		// TODO Auto-generated method stub
		if(!(p instanceof Integer)) return -1;
		int count = 0;
		int k = (int) p;
		if(k >= array.length || array[k] == null) return -1;
		if(left(p) != null) 
			count++;
		if(right(p) != null)
			count++;
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T parent(T p) {
		// TODO Auto-generated method stub
		if(!(p instanceof Integer)) return null;
		if(isEmpty()) return null;
		int k = (int) p;
		if(k >= array.length || array[k] == null) return null;
		k = Math.floorDiv(k, 2); //k/2 lay phan nguyen lam tron xuong
		if(array[k] == null) return null;
		else return (T) Integer.valueOf(k);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T left(T p) {
		// TODO Auto-generated method stub
		if(!(p instanceof Integer)) return null;
		if(isEmpty()) return null;
		int k = (int) p;
		k = 2*k;
		if(k >= array.length || array[k] == null) return null;
		else return (T) Integer.valueOf(k);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T right(T p) {
		// TODO Auto-generated method stub
		if(!(p instanceof Integer)) return null;
		if(isEmpty()) return null;
		int k = (int) p;
		k = 2*k + 1;
		if(k >= array.length || array[k] == null) return null;
		else return (T) Integer.valueOf(k);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T sibling(T p) {
		// TODO Auto-generated method stub
		if(!(p instanceof Integer)) return null; //neu p k phai kieu integer thi null luon
		if(isEmpty()) return null;
		int k = (int) p;
		if(k >= array.length || array[k] == null) return null;
		if(k % 2 == 0) 
			k = k + 1;
		else 
			k = k - 1;
		if(k >= array.length || array[k] == null) return null;
		return (T) Integer.valueOf(k);
	}
	//tra ve gia tri tai vi tri p
	public E getElement(T p) {
		if(!(p instanceof Integer)) return null;
		int k = (int) p;
		if(k >= array.length || array[k] == null) return null;
		return array[k];
	}
//	public void printTree() {
//		int current = 1;
//		System.out.println("Tree :");
//		while (current != n+1) {
//			System.out.print(array[current] + " ");
//			current++;
//		}
//		System.out.println(" ");
//	}
	public void print(T p, int level) {
		if(p == null) return;
		print(right(p), level+1);
		for(int i = 0; i < level; i++) {
			System.out.print("\t");
		}
		System.out.println(getElement(p));
		print(left(p), level + 1);
	}
	
	//print to file
	public void printText(T p, int level) {
		if(p == null) return;
		int k = (int) (p);
		printText(right(p), level + 1);
		for(int i = 0; i < level; i++) {
			outfile += "\t";
		}
		outfile += array[k] + "\n";
		printText(left(p), level + 1);
	}

	public void printFile() throws IOException{
		outfile = "";
		printText(root(), 0);
		FileWriter myWriter = new FileWriter("/E:/Java Code/Code/src/hw5_18001154/Arraybinarytree.txt/");
		myWriter.write("This is a binary tree printed using ArrayBinaryTree " + "\n");
		
	    myWriter.write(outfile);
	    myWriter.close();
	}
	
}









