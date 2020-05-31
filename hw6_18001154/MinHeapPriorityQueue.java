package hw6_18001154;

import java.util.Arrays;

public class MinHeapPriorityQueue<K extends Comparable, E> extends SortedArrayPriorityQueue<K,E>{
	ArrEntry<K, E> heapPQ [];
	private static final int default_size = 1000;
	private int n = 0;
	public int parent(int i) {
		return (i-1)/2;
	}
	public int left(int i) {
		return 2*i + 1;
	}
	public int right(int i) {
		return 2*i + 2;
	}
	public boolean hasLeft(int i) {
		return left(i) < n;
	}
	public boolean hasRight(int i) {
		return right(i) < n;
	}
	public MinHeapPriorityQueue() {
		// TODO Auto-generated constructor stub
		heapPQ = new ArrEntry[default_size];
	}	
	public int size() {
		return n;
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	@Override
	public void insert(Entry<K, E> entry) {
		if(n==default_size) {
			return;
		} else {
			heapPQ[n] = (SortedArrayPriorityQueue<K, E>.ArrEntry<K, E>) entry;
			upHeap();
			n++;
		}
	}
	
	public void insert(K k, E e) {
		if(n == default_size) {
			return;
		}
		heapPQ[n] = new ArrEntry(k, e);
		upHeap();
		n++;
		
	}
	
	public Entry<K, E> removerMin(){
		if(isEmpty()) return null;
		Entry<K, E> entry = heapPQ[0];
		heapPQ[0] = heapPQ[--n];
		downHeap();
		return entry;
	}
	
	
//	public Entry<K, E> min(){
//		return heapPQ[0];
//	}
	
	//vun len
	protected void upHeap() {
		int index = n;
		while(index > 0) {
			int parent = parent(index);
			if(heapPQ[index].getKey().compareTo(heapPQ[parent].getKey()) > 0) {
				break;
			}
			else {
				ArrEntry temp = heapPQ[index];
				heapPQ[index] = heapPQ[parent];
				heapPQ[parent] = temp;
				index = parent;
			}
		}
		
	}
	
	//vun xuong
	protected void downHeap() {
		int index = 0;
		
		while(hasLeft(index)) {
			int leftIndex = left(index);
			int small = leftIndex;
			if(hasRight(index)) {
				int rightIndex = right(index);
				if(heapPQ[leftIndex].getKey().compareTo(heapPQ[rightIndex].getKey()) > 0) {
					small = rightIndex;
				}
			}
			if(heapPQ[small].getKey().compareTo(heapPQ[index].getKey()) > 0) {
				break;
			}
			else {
				ArrEntry temp = heapPQ[index];
				heapPQ[index] = heapPQ[small];
				heapPQ[small] = temp;
				index = small;
			}
		}
	}
	static final int COUNT = 10;
	private void print(int root, int tab) {
		if (root < 0 || root > this.n || heapPQ[root] == null)
            return;
		
		print(root*2 + 2, tab);
		System.out.print("\n");
		for(int i = COUNT; i < tab; i++) {
			System.out.print("\t");
		}
		System.out.print(heapPQ[root] + "\n");
		print(root*2 + 1, tab);
	}
	
	public void printTree(int root) {
        print(root, 0);
    }
	
}
