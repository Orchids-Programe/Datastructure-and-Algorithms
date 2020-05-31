package hw4_18001154;

import java.util.Scanner;

public class Palindrome {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String check = sc.next();
		LinkedlistStack<Character> test1 = new LinkedlistStack<Character>();
		LinkedlistQueue<Character> test2 = new LinkedlistQueue<Character>();
		for(int i = 0; i < check.length(); i++) {
			test1.push(check.charAt(i));
			test2.enqueue(check.charAt(i));
		}
		int count = 0;
		while(!test1.isEmpty()) {
			if(test1.pop() != test2.dequeue()) {
				count = count + 1;
			}
		}
		if(count != test1.size()) {
			System.out.println("Is not palindrome");
		}
		else {
			System.out.println("Is palindrome");
		}
	}

}