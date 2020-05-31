package hw3;

import java.util.Scanner;

public class ComplexEx {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhap so n : ");
		int n = sc.nextInt();
		Complex[] a = new Complex[n];
		for(int i = 0; i < n; i++) {
			a[i] = new Complex(i, i+3);
			System.out.println(a[i].toString());
		}
		
		
		System.out.println("Nhap vi tri can tim : ");
		int vt = sc.nextInt();
		for(int i = 0; i < a.length; i++) {
			if(i == vt) {
				System.out.println(a[i].toString());
			}
		}
		
		Complex sum = null;
		for(int j = 0; j < n-1; j++) {
			sum = sum.add(a[j].add(a[j+1]));
		}
		System.out.println(sum.toString());	
	}
}