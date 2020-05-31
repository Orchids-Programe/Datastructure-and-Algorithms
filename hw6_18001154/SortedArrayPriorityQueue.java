package hw6_18001154;

public class SortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
	protected class ArrEntry<K, E> implements Entry<K, E>{
		K key;
		E element;
		public ArrEntry(K k, E e) {
			this.key = k;
			this.element = e;
		}
		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return this.key;
		}
		@Override
		public E getValue() {
			// TODO Auto-generated method stub
			return this.element;
		}
		@Override
		public String toString() {
			return "ArrEntry [key=" + key + ", element=" + element + "]";
		}
		
	}
	
	ArrEntry<K, E> [] array;
	int n = 0;
	int defaultsize = 1000;
	
	
	
	public SortedArrayPriorityQueue() {
		// TODO Auto-generated constructor stub
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
		if(n == defaultsize) return;
		array[n] = new ArrEntry<K, E>(entry.getKey(), entry.getValue());
		n++;
		for(int i = 0; i < n-1; i++) {
			for(int j = i; j < n-1; j++) {
				if(array[j].getKey().compareTo(array[j+1].getKey()) > 0) {
					ArrEntry<K, E> temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
	@Override
	public void insert(K k, E e) {
		// TODO Auto-generated method stub
		if(n == defaultsize) {
			return;
		} else {
			array[n] = new ArrEntry(k,e);
			n++;
			for(int i= 0; i < n-1; i++) {
				for(int j = 1; j < n-i; j++) {
					if(array[j-1].getKey().compareTo(array[j].getKey()) > 0) {
						ArrEntry temp = array[j-1];
						array[j-1] = array[j];
						array[j] =temp;
					}
				}
			}
		}
	}

	@Override
	public Entry<K, E> removeMin() {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;
		Entry<K, E> min = array[0];
		for(int i = 0; i < n; i++) {
			array[i] = array[i+1];
		}
		array[n] = null;
		n--;
		return min;
	}

	@Override
	public Entry<K, E> min() {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;
		Entry<K, E> min = array[0];
		return min;
	}
	
	public void printQueue() {
		for(int i = 0; i < n; i++) {
			System.out.println(array[i].getKey() + " ");
		}
	}
	

}
