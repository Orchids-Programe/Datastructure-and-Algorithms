package hw5_18001154;
import java.util.Stack;
public class ConvertExpTree<E, T> extends LinkedBinaryTree<E, T>{
	public void preorderPrint(Node<E> p) {
		if(p != null) {
			System.out.print(p.getElement()+ " ");
			preorderPrint(p.getLeft());
			preorderPrint(p.getRight());
		}
	}
	public void postorderPrint(Node<E> p) {
		if(p != null) {
			postorderPrint(p.getLeft());
			postorderPrint(p.getRight());
			System.out.print(p.getElement() + " ");
		}
	}
	public void inorderPrint(Node<E> p) {
		if(p != null) {
			if(p.getLeft() != null) {
				System.out.print("(");
				inorderPrint(p.getLeft());
			}
			System.out.print(p.getElement()+ " ");
			if(p.getRight() != null) {
				inorderPrint(p.getRight());
				System.out.print(")");
			}
		}
	}
	private int evaluate(Node<E> p) {
		if(p.getLeft() == null)
		    return (Character)p.getElement() - '0';
		else  
		    {
			int left = evaluate (p.getLeft());
			int right = evaluate (p.getRight());
			switch (((Character)p.getElement()).charValue())
			    {
			    case '-':
				return left - right; 
			    case '+':
				return left + right; 
			    case '/':
				return left / right; 
			    case '*':
				return left * right; 
			    }
		    }
		return 0;	
	}
	public static int Prec(char op){
		switch (op) {
		case '+':
		case '-':	
			return 1;
		case '*':
		case'/':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}
	public static String infix2postfix(String infix) {
		String equal = new String("");
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0;i<infix.length();i++) {
			char c = infix.charAt(i);
			if(Character.isDigit(c))
				equal += c;
			else if(c == '(')
				stack.push(c);
			else if(c == ')') {
				while(!stack.isEmpty() && stack.peek() != '(')
					equal += stack.pop();
				if(!stack.isEmpty() && stack.peek() != '(') 
					return "Invalid";
				else
					stack.pop();
			}
			else
			{
				while(!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
					if(stack.peek() == '(')
						return "Invalid";
					equal += stack.pop();
				}
				stack.push(c);
			}
		}
		while(!stack.isEmpty()) {
			if(stack.peek() == '(')
				return "Error";
			equal += stack.pop();
		}
		return equal;
	}
	public boolean isOperation(char c) {
		if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
			return true;
		}
		return false;
	}
	public Node<E> buildTree(String infix){
		String postfix = infix2postfix(infix);
		char[] a = postfix.toCharArray();
		Stack<Node<E>> st = new Stack<LinkedBinaryTree.Node<E>>();
		Node<E> t,t1,t2;
		for(int i = 0;i<a.length;i++) {
			if(!isOperation(a[i])) {
				t = (Node<E>) new Node<Character>(a[i], null, null, null);
				st.push(t);
			} else {
				t = (Node<E>) new Node<Character>(a[i], null, null, null);
				t1 = st.pop();
				t2 = st.pop();
				
				t.setRight(t1);
				t.setLeft(t2);
				
				st.push(t);
			}
		}
		t = st.peek();
		st.pop();
		return t;
	}
	public static void main(String[] args) {
		ConvertExpTree<Character,Integer> tree = new ConvertExpTree<Character,Integer>();
		//	Test 2	
			Node t1 = tree.addRoot('+');
			Node t2 = tree.addLeft(t1,'*');
			Node t3 = tree.addRight(t1,'5');
			tree.addLeft(t2, '3');
			tree.addRight(t2, '4');
			tree.preorderPrint(t1);
			System.out.println();
			tree.postorderPrint(t1);
			System.out.println();
			tree.inorderPrint(t1);
			System.out.println();
			System.out.println(tree.evaluate(t1));
		//Test 3
			String infix = "(6/2+3)";
			Node<Character> root = tree.buildTree(infix);
			tree.inorderPrint(root);
			System.out.println("\n" + tree.evaluate(root));
	}
}
