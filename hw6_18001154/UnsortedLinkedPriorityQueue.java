package hw6_18001154;

public class UnsortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
	protected class NodeEntry<K, E> implements Entry<K, E>{
		private K key;
		private E element;
		private NodeEntry<K, E> next;
		

		public NodeEntry(K k, E e) {
			this.key = k;
			this.element = e;
			this.next = null;
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
		@Override
		public String toString() {
			return "NodeEntry [key=" + key + ", element=" + element + "]";
		}
		
	}
	
	private NodeEntry<K, E> head;
	private NodeEntry<K, E> tail;
	int n = 0;
	
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
		NodeEntry<K,E> temp = new NodeEntry<K, E>(entry.getKey(), entry.getValue());
		if(head == null) {
			head = tail = temp;
			n++;
		}
		else {
			tail.next = temp;
			tail = temp;
			n++;
		}
	}

	@Override
	public void insert(K k, E e) {
		// TODO Auto-generated method stub
		NodeEntry<K,E> temp = new NodeEntry(k,e);
		if(head == null) {
			head = tail = temp;
			n++;
		}
		else {
			tail.next = temp;
			tail = temp;
			n++;
		}
	}

	@Override
	public Entry<K, E> removeMin() {
		// TODO Auto-generated method stub
		NodeEntry<K, E> min = head;
		NodeEntry<K, E> premin = null;
		NodeEntry<K, E> current = head;
		while(current != null) {
			if(current.getKey().compareTo(min.getKey()) < 0) {
				min = current;
			}
			current = current.next;
		}
		if(head == min) {
			premin = null;
		}
		else {
			current = head;
			while(current != null) {
				if(current.next == min) {
					premin = current;
				}
				current = current.next;
			}
		}
		if(min == head) {
			head = min.next;
		}else if(tail == min) {
			tail = premin;
			premin.next = null;
		}else {
			premin.next = min.next;
		}
		n--;
		return min;
	}

	@Override
	public Entry<K, E> min() {
		// TODO Auto-generated method stub
		NodeEntry<K, E> min = head;
		NodeEntry<K, E> current = head;
		while(current != null) {
			if(current.getKey().compareTo(min.getKey()) < 0) {
				min = current;
			}
			current = current.next;
		}
		return min;
	}
	
	public void printQueue() {
		NodeEntry<K, E> temp = head;
		while(temp != null) {
			System.out.println(temp.toString());
			temp = temp.next;
		}
	}
	

}
