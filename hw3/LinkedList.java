package hw3;

public class LinkedList<T> {
	public class Node{
		protected T data;
		protected Node next;
		Node(T data){
			this.data = data;
		}
		public Node(T d, Node n) {
			data = d;
			next = n;
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
	
	public LinkedList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void display() {
		// TODO Auto-generated method stub
		Node temp = top;
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	public void add(T data) {
		//Thêm phần tử vào đầu
		++n;
		Node temp = new Node(data);
		if(top == null) {
			top = temp;
			bot = temp;
		}
		else {
			
			temp.next = top;
			top = temp;
		}
	}
	public void addBot(T data) {
		//add phần tử cuối
		++n;
		Node temp = new Node(data);
		if(bot == null) { //trường hợp list rỗng
			bot = temp;
			top = temp;
		}
		else {// truong hop list khac rong
			temp.next = null;
			bot.next = temp;
			bot = temp;
		}
	}
	public T get(int i) {
		//Lấy phần tử ở vị trí i
		int k = 0;
		Node e = top;
		while(e.next != null && k != i) {
			k++;
			e = e.next;
		}
		return e.data;
	}
	public void set(int i, T data) {
		//Gán giá trị ở vị trí i bằng data
		int k = 0;
		Node value = new Node(data);
		Node last = top;
		while(last.next != null && k != i) {
			k++;
			last= last.next;
		}
		last = value;
	}
	public boolean isContain(T data) {
		//Kiểm tra trong danh sách chưa phần tử data không
		Node p = top;
		while(p != null && !p.data.equals(data)) {
			p = p.next;
		}
		if(p != null) {
			return true;
		}
		else
			return false;
	}
	public int size() {
		//Trả lại số phần tử
		return n;
	}
	public boolean isEmpty() {
		//Kiểm tra danh sách có rỗng không
		return (n == 0);
	}
	public T removeTop() {
		//vừa xóa top và đồng thời trả lại giá trị top
		if(top == null) {
			return null;
		}
		else {
			
			if(n == 1) {
				T res = top.data;
				top = null;
				--n;
				return res;
			}
			else {
				T res = top.data;
				Node temp = top.next;
				top = temp;
				--n;
				return res;
			}
		}
		
	}
	public T removeBot() {
		//Xóa phần tử cuối và trả lại giá trị pt đó
		if(bot == null) {
			return null;
		}
		else {
			if ( n == 1) {
				T res = bot.data;
				--n;
				bot = null;
				top = null;
				return res;
			}
			else {
				T res = bot.data;
				--n;
				Node temp = top;
				while(temp.next.next != null) {  //tro toi 2 gia tri
					temp = temp.next;
				}System.out.println(temp.data+" "+bot.data+" "+bot.data);
				bot = temp; //tro toi pt gan cuoi
				temp.next = null;
				return res;
			}
		}
		
	}
	public void remove(T data) {
		//Xóa phần tử trong danh sách có giá trị bằng data
		Node pointer = top;
		while(pointer.getData().equals(data)) {
			removeTop();
			pointer = top;
		}
		if(pointer != null) {
			while(pointer.next != null) {
				if(pointer.next.data.equals(data)) {
					if(pointer.next == bot) {
						bot = pointer;
					}
					pointer.next = pointer.next.next;
					n--;
				}
				else {
					pointer = pointer.next;
				}
			}
		}
	}
}
