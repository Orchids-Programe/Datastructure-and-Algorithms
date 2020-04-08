package hw4_18001154;

import java.util.Scanner;

public class Excercise3 {
	public static double Formula(String formula) {
		String[] array = formula.split(" ");
		LinkedlistStack<String> toantu = new LinkedlistStack<String>();
		LinkedlistStack<Double> toanhang = new LinkedlistStack<Double>();
		for(int i = 0; i < array.length; i++) {
			if(array[i].compareTo("+") == 0 
					|| array[i].compareTo("-") == 0
					|| array[i].compareTo("*") == 0
					|| array[i].compareTo("/") == 0) {
				toantu.push(array[i]);
			}
			else if(array[i].compareTo(")") == 0) {
				double so2 = toanhang.pop();
				double so1 = toanhang.pop();
				
				String toan = toantu.pop();
				double kq = 0;
				
				if(toan.compareTo("+") == 0) {
					kq = so1 + so2;
				}
				if(toan.compareTo("-") == 0) {
					kq = so1 - so2;
				}
				if(toan.compareTo("*") == 0) {
					kq = so1 * so2;
				}
				if(toan.compareTo("/") == 0) {
					kq = so1 / so2;
				}
				toanhang.push(kq);
			} else if (array[i].compareTo("(") == 0) {
			}else {
				toanhang.push(Double.parseDouble(array[i]));
			}
		}
		return toanhang.pop();
	}
	
	public static boolean Check(String expr) {
		LinkedlistStack<String> stack = new LinkedlistStack<String>();
		for(int i = 0; i < expr.length(); i++) {
			if(expr.charAt(i) == '('){
				stack.push("(");
			}
			else if(expr.charAt(i) == ')') {
				if(stack.isEmpty() == false) {
					stack.pop();
				}
				else {
					return false;
				}
			}
		}
		if(stack.isEmpty()) {
			return true;
		}
		return false;
		
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String avail = sc.nextLine();
		if(Check(avail)){
			System.out.println(Formula(avail));
		}
		else {
			System.out.println("Not Invalid");
		}
	}

}
