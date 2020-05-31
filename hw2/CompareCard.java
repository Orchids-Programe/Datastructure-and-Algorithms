package hw2;

import java.util.Arrays;



public class CompareCard {
	public static void main(String[] args) {
		Card[]  a = new Card[5];
		a[1] = new Card(1, 2);
		a[2] = new Card(1, 3);
		a[3] = new Card(2,3);
		a[4] = new Card(2,4);
		a[0] = new Card(1,4);
		/*int count =0 ;
		for(int i = 1;i<5;i++) {
			for(int j =1;j<14;j++) {
				Card card = new Card(i, j);
				a[count] = card;
				count++;
			}
		}*/
		System.out.println("trước khi sắp xếp:");
		print(a);
		Arrays.sort(a);
		System.out.println();
		System.out.println("Sau khi sắp xếp:");
		print(a);
	}
	public static void print(Card[] a) {
		for(int i = 0;i<a.length;i++) {
			System.out.print(a[i].toString() + " ");
		}
	}
}

