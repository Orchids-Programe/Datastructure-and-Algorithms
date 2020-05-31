package hw6_18001154;

public class UnSortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
	@SuppressWarnings("hiding")
	protected class ArrEntry<K, E> implements Entry<K, E>{
		private K key;		//key
		private E element;	//value
		public ArrEntry(K k, E e) {
			key = k;
			element = e;
		}
		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return key;
		}
		@Override
		public E getValue() {
			// TODO Auto-generated method stub
			return element;
		}
		
		protected void setKey(K k) {
			key = k;
		}
		protected void setValue(E e) {
			element = e;
		}
		@Override
		public String toString() {
			return "ArrEntry [key=" + key + ", element=" + element + "]";
		}
		
	}
	ArrEntry<K, E> [] array;
	int n = 0;
	int defaultsize = 1000;
	
	@SuppressWarnings("unchecked")
	public UnSortedArrayPriorityQueue(){
		array = new ArrEntry[defaultsize];
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
	public void insert(Entry<K, E> entry) {
		// TODO Auto-generated method stub
		if( n== array.length) {
			return;
		}
		ArrEntry<K, E> node = new ArrEntry<K, E>(entry.getKey(),entry.getValue());
		array[n] = node;
		n++;
		
	}
	@Override
	public void insert(K k, E e) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if( n == defaultsize) {
			System.out.println("Queue is full");
		}
		ArrEntry<K, E> newest = new ArrEntry<K, E>(k, e);
		array[n] = newest;
		n++;
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public Entry<K, E> removeMin() {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;
		Entry<K, E> min = array[0];
		int index = 0;
		for(int i = 0; i < n; i++) {
			if(min.getKey().compareTo(array[i].getKey()) > 0) {
				min = array[i];
				index = i;
			}
		}
		for(int i = index; i < n; i++) {
			array[i] = array[i+1];
		}
		array[n-1] = null;
		n--;
		return min;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Entry<K, E> min() {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;
		Entry<K, E> min = array[0];
		for(int i = 0; i < n; i++) {
			if(min.getKey().compareTo(array[i].getKey()) > 0) {
				min = array[i];
			}
		}
		return min;
	}
	
	public void printQueue() {
		for(int i = 0; i < n; i++) {
			System.out.println(array[i] + " ");
		}
	}

}
