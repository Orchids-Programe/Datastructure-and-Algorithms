package hw6_18001154;

public class SortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
	protected class NodeEntry<K,E> implements Entry<K, E>{
		private K key;
		private E element;
		private NodeEntry<K, E> next;
		public NodeEntry(K k, E e) {
			// TODO Auto-generated constructor stub
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
			return "NodeEntry [key=" + key + ", element=" + element + "]";
		}
		
		
	}
	
	private NodeEntry<K,E> head;
	private NodeEntry<K,E> tail;
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

	@SuppressWarnings("unchecked")
	@Override
	public void insert(Entry<K, E> entry) {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			head = tail = new NodeEntry<K, E>(entry.getKey(), entry.getValue());
			n++;
		}
		else {
			NodeEntry<K, E> current = head;
			NodeEntry<K, E> temp = new NodeEntry<K, E>(entry.getKey(), entry.getValue());
			K curKey = (K) current.getKey();
			if( curKey.compareTo(temp.getKey()) > 0) {
				temp.next = head;
				head = temp;
				n++;
			}
			else {
				K key = (K) current.getKey();
				NodeEntry<K, E> pre = null;
				while(current.next != null && key.compareTo(temp.getKey()) < 0) {
					pre = current;
					current = current.next;
					key = (K) current.getKey();
				}
				key = (K) current.getKey();
				if(key.compareTo(temp.getKey()) > 0) {
					pre.next = temp;
					current= current.next;
					n++;
				}
				else {
					NodeEntry<K, E> curNext = current.next;
					if(curNext == null) {
						tail = temp;
						current.next = tail;
						tail.next = null;
						n++;
					}
					else {
						current.next = temp;
						temp.next = curNext;
						n++;
					}
				}
			}
		}
		
	}
	@Override
	public void insert(K k, E e) {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			head = tail = new NodeEntry<K, E>(k,e);
			n++;
		}
		else {
			NodeEntry<K, E> current = head;
			NodeEntry<K, E> temp = new NodeEntry<K, E>(k,e);
			K curKey = (K) current.getKey();
			if(curKey.compareTo(temp.getKey()) > 0) {
				temp.next = head;
				head = temp;
				n++;
			}
			else {
				K key = (K) current.getKey();
				NodeEntry<K, E> pre = null;
				while(current.next != null && key.compareTo(temp.getKey()) < 0) {
					pre = temp;
					current = current.next;
					key = (K) current.getKey();
				}
				key = (K) current.getKey();
				if(key.compareTo(temp.getKey()) > 0) {
					pre.next = temp;
					temp.next = current;
					n++;
				}
				else {
					NodeEntry<K, E> curNext = current.next;
					if(curNext == null) {
						tail = temp;
						current.next = tail;
						tail.next = null;
						n++;
					}
					else {
						current.next = temp;
						temp.next = curNext;
						n++;
					}
				}
			}
		}
	}

	@Override
	public Entry<K, E> removeMin() {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;
		else {
			NodeEntry<K, E> res = head;
			if(head.next != null) {
				head = head.next;
			}
			else {
				head = tail = null;
			}
			n--;
			return res;
		}
	}

	@Override
	public Entry<K, E> min() {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;
		else {
			return head;
		}
	}
	
	public void printQueue() {
		NodeEntry<K, E> temp = head;
		while(temp != null) {
			System.out.println(temp.toString() + " ");
			temp = temp.next;
		}
	}

}
