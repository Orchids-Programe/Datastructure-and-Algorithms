package hw7_18001154;

public class BinarySearchTree<E extends Comparable, T> implements BinaryTreeInterface<T>{
	
	protected static class Node<E>{
		private E element;
		private Node<E> parent;
		private Node<E> left;
		private Node<E> right;
		public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
			
			element = e;
			parent = above;
			left = leftChild;
			right = rightChild;
		}
		
		public E getElement() {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}

		public Node<E> getParent() {
			return parent;
		}
		public void setParent(Node<E> parent) {
			this.parent = parent;
		}
		public Node<E> getLeft() {
			return left;
		}
		public void setLeft(Node<E> left) {
			this.left = left;
		}
		public Node<E> getRight() {
			return right;
		}
		public void setRight(Node<E> right) {
			this.right = right;
		}
		
		
	}
	
	Node<E> root = null;
	private int n = 0;
	public Node<E> addRoot(E element){
		if(size() == 0) {
			Node node = new Node<E>(element, null, null, null);
			root = node;
			n++;
		}
		else {
			set(root, element);
		}
		return root;
	}
	
	public Node<E> addLeft(Node p, E element){
		if(size() == 0 || p == null) {
			return null;
		}
		if(p.getLeft() == null) {
			Node temp = new Node<E>(element, p, null, null);
			p.setLeft(temp);
			n++;
		}
		else {
			set(p.getLeft(), element);
		}
		return p.getLeft();
		
	}
	
	public Node<E> addRight(Node p, E element){
		if(size() == 0 || p == null) {
			return null;
		}
		if(p.getRight() == null) {
			Node temp = new Node<E>(element, p, null, null);
			p.setRight(temp);
			n++;
		}
		else {
			set(p.getRight(), element);
		}
		return p.getLeft();
	}
	
	public void set(Node p, E element) {
		if(size() == 0 || p == null) {
			return;
		}
		p.setElement(element);
	}
	
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

	@Override
	public int numChildren(T p) {
		// TODO Auto-generated method stub
		if(!(p instanceof Node)) return -1;
		Node k = (Node) p;
		if(isEmpty()) return -1;
		if(k == null) return -1;
		int count = 0;
		if(k.getLeft() != null) {
			count++;
		}
		if(k.getRight() != null) {
			count++;
		}
		return count;
	}

	@Override
	public T parent(T p) {
		// TODO Auto-generated method stub
		if(!(p instanceof Node)) return null;
		Node k = (Node) p;
		if(isEmpty()) return null;
		if(k == null) return null;
		return (T) k.getParent();
	}

	@Override
	public T left(T p) {
		// TODO Auto-generated method stub
		if(!(p instanceof Node)) return null;
		Node k = (Node) p;
		if(isEmpty()) return null;
		if(k == null) return null;
		return (T) k.getLeft();
	}

	@Override
	public T right(T p) {
		// TODO Auto-generated method stub
		if(!(p instanceof Node)) return null;
		Node k = (Node) p;
		if(isEmpty()) return null;
		if(k == null) return null;
		return (T) k.getRight();
	}

	@Override
	public T sibling(T p) {
		// TODO Auto-generated method stub
		if(!(p instanceof Node)) return null;
		Node k = (Node) p;
		if(isEmpty()) return null;
		if(k == null) return null;
		if(k == k.getParent().getLeft()) {
			return (T) k.getParent().getRight();
		}
		else {
			return (T) k.getParent().getLeft();
		}
		
	}
	
	public void print(Node p, int level) {
		if(p == null) return;
		print(p.getRight(), level+1);
		for(int i = 0; i < level; i++) {
			System.out.print("\t");
		}
		System.out.println(p.getElement());
		print(p.getLeft(), level+1);
	}
	
	public int findMin(Node n) {
		while(n.getLeft() != null) {
			n = n.getLeft();
		}
		return (int) n.getElement();
	}

	public void search(Node p, E e) {
		if(p == null) {
			System.out.println(e + "not found");
		}
		else if (p.getElement() == e) {
			System.out.println(e + "founded");
		}
		else if (e.compareTo(p.getElement()) < 0) {
			search(p.getLeft(), e);
		}
		else {
			search(p.getRight(), e);
		}
	}
	
	public void insert(E e, Node p) {
		if(e.compareTo(p.getElement()) < 0) {
			if(p.getLeft() != null) {
				insert(e, p.getLeft());
			}
			else {
				p.left = new Node<E>(e, p, null, null);
			}
		}
		
		if(e.compareTo(p.getElement()) > 0) {
			if(p.getRight() != null) {
				insert(e, p.getRight());
			}
			else {
				p.right = new Node<E>(e, p, null, null);
			}
		}
	}
	
	public void delete(E e, Node p) {
		if(p.getLeft() == null && p.getRight() == null) {
			if(p.getElement() == e) {
				p = null;
				n--;
			}
			else {
				System.out.println("not found");
			}
		}
		else if (p.getLeft() == null) {
			if(p.getElement() == e) {
				p = p.getRight();
			}
			else {
				delete(e, p.getRight());
			}
		}
		else if (p.getRight() == null) {
			if(p.getElement() == e) {
				p = p.getLeft();
			}
			else {
				delete(e, p.getLeft());
			}
		}
		else if (p.getLeft() != null && p.getRight() != null) {
			if(p.getElement() == e) {
				findMin(p.getRight());
				delete((E) p.getElement(), p.getRight());
			}
			else if (e.compareTo(p.getElement()) < 0) {
				delete(e, p.getLeft());
			}
			else {
				delete(e, p.getRight());
			}
		}
	}
	
}
