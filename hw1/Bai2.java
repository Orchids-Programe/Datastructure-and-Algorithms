package hw1;

import java.util.Scanner;

public class Bai2 {
	@SuppressWarnings("resource")
	public static void input_arr(int[] a, int n )
	{
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < n; i++)
		{
			System.out.print("a["+i+"] =");
			a[i] = sc.nextInt();
		}
	}
	
	public static void output_arr(int []a, int n)
	{
		for(int i =0; i < n; i++)
		{
			System.out.print(a[i] + "\t");
		}
	}
	
	@SuppressWarnings("resource")
	public static void search(int []a, int n, int i)
	{
		int k;
		int dem = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("\nNhap gia tri can tim : ");
		k = sc.nextInt();
		for(i = 0; i < n; i++)
		{
			if(k == a[i])
			{
				dem++;
			}
		}
		if(dem == 0)
		{
			System.out.println("Gia tri "+k+" khong xuat hien trong mang!");
		}
		else
		{
			System.out.println("Gia tri "+k+" co xuat hien "+dem+" trong mang tai vi tri "+i);
		}
	}
	
	public static void sort(int []a, int n)
	{
		int temp;
		for(int i = 0; i < n; i++)
		{
			for(int j = i+1; j < n; j++)
			{
				if(a[i] < a[j])
				{
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println("Day sau khi da sap xep la : ");
		output_arr(a, n);

	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int a[];
		int n,i = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so phan tu cua mang : ");
		n = sc.nextInt();
		a = new int[n];
		input_arr(a, n);
		System.out.println("Mang do la : ");
		output_arr(a, n);
		
		search(a, n, i);
		
		sort(a, n);
		

	}

}
