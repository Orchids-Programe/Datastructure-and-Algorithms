package hw2;

import java.util.ArrayList;
import java.util.Collections;



public class sortComparabale {
	public static void main(String[] args) {
		ArrayList<Elements> list = new ArrayList<Elements>();
		for(int i = 0; i < 10; i++) {
			list.add( new Elements(i));
		}
		
		Collections.shuffle(list);
		BubbleSort(list);
		//SelectionSort(list);
		//InsertionSort(list);
		
	}
	
	

	public static void print(ArrayList<Elements> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString()+" ");
		}
	}
	
	public static<R extends Comparable<Elements>> void BubbleSort(ArrayList<Elements> list) {
		int swap = 0;
		int count = 0;
		print(list);
		for(int i = 0; i < list.size();i++) {
			for(int j = 1; j < list.size() - i; j++) {
				if(( (Comparable<Elements>) list.get(j)).compareTo(list.get(j - 1)) < 0) {
					swap++;
					count++;
					Elements temp = list.get(j);
					list.set(j, list.get(j-1));
					list.set(j - 1, temp);
				}
				
				else {
					count++;
				}
			}
		}
		System.out.println();
	
		print(list);
		System.out.println();
		System.out.println("So lan doi cho la:" + swap);
		System.out.println("So lan so sanh la: " + count);
	}
	public static <R extends Comparable<Elements>> void SelectionSort(ArrayList<Elements> list) {
		int swap = 0;
		int compares = 0;
		
		print(list);
		for (int i = list.size() - 1; i >= 1; i--) {
			int maxIdx = i;
			for (int j = 1; j < i; j++) {
				if (((Comparable<Elements>) list.get(j)).compareTo(list.get(maxIdx)) > 0) {
					maxIdx = j;
					swap++;
					compares++;
				} else {
					compares++;
				}
			}
			Elements temp = (Elements) list.get(maxIdx);
			list.set(maxIdx, list.get(i));
			list.set(i, temp);
		}
		System.out.println();
		
		print(list);
		System.out.println();
		System.out.println("So lan doi cho la: " + swap);
		System.out.println("So lan so sanh la: " + compares);
	}
	
	public static <R extends Comparable<Elements>> void InsertionSort(ArrayList<Elements> list) {
		int swap = 0;
		int compares = 0;
		
		print(list);
		for (int i = 0; i < list.size(); i++) {
			Elements temp = list.get(i);
			int j;
			compares += i;
			for (j = i - 1; j >= 0 && ((Comparable<Elements>) list.get(j)).compareTo(temp) > 0; j--) {
				swap++;
				list.set(j + 1, list.get(j));
			}
			list.set(j + 1, temp);
		}
		System.out.println();
	
		print(list);
		System.out.println();
		System.out.println("So lan doi cho la: " + swap);
		System.out.println("So lan so sanh la: " + compares);
	}
	
	
}
