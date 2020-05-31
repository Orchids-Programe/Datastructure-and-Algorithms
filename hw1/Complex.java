package hw1;

import java.util.Scanner;

public class Complex {
	private int thuc;
	private int ao;
	public Complex()
	{
		thuc = 0;
		ao = 0;
	}
	public Complex(int thuc, int ao)
	{
		super();
		this.thuc = thuc;
		this.ao = ao;
	}
	

	public int getThuc() {
		return thuc;
	}
	public void setThuc(int thuc) {
		this.thuc = thuc;
	}
	public int getAo() {
		return ao;
	}
	public void setAo(int ao) {
		this.ao = ao;
	}
	
	public String toString()
	{
		return thuc+"+"+ao+"i";
	}
	public Complex cong(Complex b)
	{
		Complex c = new Complex();
		c.thuc = thuc + b.thuc;
		c.ao = ao + b.ao;
		return c;
		
	}
	
	public Complex nhan(Complex b)
	{
		Complex d = new Complex();
		d.thuc = thuc*b.thuc + ao*b.ao;
		d.ao = thuc*b.ao + ao*b.thuc;
		return d;
	}
	@SuppressWarnings({ "resource" })
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so phuc thu 1:");
		System.out.print("Nhap phan thuc: ");
		int x = sc.nextInt();
		System.out.print("Nhap phan ao : ");
		int y = sc.nextInt();
		Complex a = new Complex(x,y);
		System.out.println("Nhap so phuc thu 2 : ");
		x = sc.nextInt();
		y = sc.nextInt();
		Complex b = new Complex(x,y);
		System.out.println("Tong 2 so la : "+a.cong(b));
		System.out.println("Tich 2 so la : "+a.nhan(b));

	}

}
