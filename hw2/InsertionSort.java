package hw2;

import java.util.Random;
import java.util.Scanner;

public class InsertionSort {
	private double[] a;
	private static Scanner sc = new Scanner(System.in);
	private static Random rd = new Random();
	
	public void Sort() {
		
	}

	public InsertionSort() {
		super();
		// TODO Auto-generated constructor stub
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
		for(int i = 1; i < a.length; i++) {
			int j;
			count += a.length - i - 1;
			double next = a[i];
			for(j = i-1; j >= 0 && a[j] > next; --j) {
				a[j+1] = a[j];
			}
			swap += 1;
			a[j+1] = next;
		}
		System.out.println("So lan doi cho : "+swap);
		System.out.println("So la so sanh : "+count);
	}
}
