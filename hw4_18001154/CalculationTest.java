package hw4_18001154;

import java.util.Scanner;

public class CalculationTest {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Nhap bieu thuc can tinh:");
		String str = sc.nextLine();

		CalculationOfValue cal = new CalculationOfValue();
		if (cal.check(str)) {
			System.out.println(cal.calculation(str));
		} else
			System.out.println("Bieu thuc khong dung dang");
	}
}
