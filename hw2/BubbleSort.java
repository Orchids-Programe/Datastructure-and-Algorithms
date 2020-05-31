package hw2;

import java.util.Random;
import java.util.Scanner;

public class BubbleSort {
	private double[] a;
	private static Scanner sc = new Scanner(System.in);
	private static Random rd = new Random();
	public void Sort() {
		
	}
	public BubbleSort() {
		super();
		
	}
	public double[] getA() {
		return a;
	}
	public void setA(double[] a) {
		this.a = a;
	}
	
	public double[] input() {
		int n = sc.nextInt();
		a = new double[n];
		for(int i = 0; i < n; i++) {
			a[i] = rd.nextDouble()*100;
		}
		return a;
	}
	public void sort(double[] a) {
		int swap = 0;
		int count = 0;
		for(int i = 0; i < a.length-1; i++) {
			count +=a.length - i - 1;
			for(int j = 1; j < a.length-i; j++) {
				if(a[j - 1] > a[j]) {
					swap +=1;
					double temp = a[j-1];
					a[j-1] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println("So lan doi cho : "+swap);
		System.out.println("So la so sanh : "+count);
	}
}
