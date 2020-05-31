package hw7_18001154;

public class LinkedlistSearching<T> {
	class Node{
		T data;
		Node next;
		public Node(T data) {
			super();
			this.data = data;
			this.next = next;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		
	}
	private Node top = null;
	private Node bot = null;
	private int n = 0;
	
	public void add(T data) {
		if(top == null) {
			Node node = new Node(data);
			top = bot = node;
			n++;
		}
		else {
			Node node = new Node(data);
			node.next = top;
			top = node;
			n++;
		}
	}
	
	public void addBot(T data) {
		if(top == null) {
			Node node = new Node(data);
			top = bot = node;
			n++;
		}
		else {
			Node node = new Node(data);
			bot.next = node;
			bot = node;
			n++;
		}
	}
	
	public T get(int i) {
		if(i > n || i < 0) return null;
		else {
			Node temp = top;
			for(int j = 0; j < i; j++) {
				temp = temp.next;
			}
			return temp.data;
		}
	}
	
	public void set(int i, T data) {
		int count = 0;
		Node temp = top;
		while(temp.next != null && count != i) {
			count++;
			temp = temp.next;
		}
		temp.setData(data);
	}
	
	public void isContain(T data) {
		int i = 0;
		if(top == null) {
			System.out.println("list is empty");
		}
		Node temp = top;
		while(i < size() && temp.data != data) {
			i++;
			temp = temp.next;
		}
		if(i > size() && bot == null) {
			System.out.println("not found");
		}
		else {
			System.out.println("found element at index "+(i+1));
		}
	}
	
	public int size() {
		return n;
	}
	
	public boolean isEmpty() {
		return n==0;
	}
	
	public T removeTop() {
		if(top == null) return null;
		else {
			T oldTop = top.data;
			top = top.next;
			n--;
			return oldTop;
		}
	}
	
	public T removeBot() {
		if(top == null) return null;
		else {
			T oldBot = bot.data;
			n--;
			return oldBot;
		}
	}
	
	public void remove(T data) {
		if(top == null) {
			System.out.println("List is empty");
		}
		else {
			Node temp = top;
			while(temp.data.equals(data)) {
				removeTop();
				temp = top;
			}
			if(temp != null) {
				while(temp.next != null) {
					if(temp.next.data.equals(data)) {
						if(temp.next == bot) {
							bot = temp;
						}
						temp.next = temp.next.next;
						n--;
					}
					else {
						temp = temp.next;
					}
				}
			}
		}
	}
}

