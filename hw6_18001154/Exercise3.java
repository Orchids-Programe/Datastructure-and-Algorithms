package hw6_18001154;

public class Exercise3 {
	//Selection Sort
	public static void SelectionSort(int[] array) {
		for(int i = 0; i < array.length - 1; i++) {
			int min = i;
			for(int j = 1; j < array.length-i; j++) {
				if(array[j] < array[min]) {
					min = j;
				}
			}
			int temp = array[min];
			array[min] = array[i];
			array[i] = (int) temp;
		}
	}
	
	//Heap Sort
	public static void HeapSort(int [] array) {
		MinHeapPriorityQueue<Integer, String> test = new MinHeapPriorityQueue<>();
		for(int i = 0; i < array.length; i++) {
			test.insert(array[i], null);
		}
		for(int i = 0; i < array.length; i++) {
			array[i] =(int) test.removeMin().getKey();
		}
	}
	
	//Merge Sort
	public static void merge(int[] array, int start, int end) {
		if(end < start) return;
		int avg = (start + end)/2;
		merge(array, start, end);
		merge(array, avg + 1, end);
		MergeSort(array, start, avg, end);
	}
	
	public static void MergeSort(int[] array, int start, int avg, int end) {
		int leftArr[] = new int[avg - start+1];
		int rightArr[] = new int[end - avg];
		for(int i = 0; i < leftArr.length; i++) {
			leftArr[i] = array[start + i];
		}
		for(int i = 0; i < rightArr.length; i++) {
			rightArr[i] = array[avg + i + 1];
		}
		int leftInd = 0;
		int rightInd = 0;
		
		for(int i = start; i < end+1; i++) {
			if(leftInd < leftArr.length && rightInd < rightArr.length) {
				if(leftArr[leftInd] < rightArr[rightInd]) {
					array[i] = leftArr[leftInd];
					leftInd++;
				}
				else {
					array[i] = rightArr[rightInd];
					rightInd++;
				}
			}
			else if(leftInd < leftArr.length) {
				array[i] = leftArr[leftInd];
				leftInd++;
			}
			else if(rightInd < rightArr.length) {
				array[i] = rightArr[rightInd];
				rightInd++;
			}
		}
	}
	//Quick Sort
	public static int partition(int[] array, int start, int end) {
		int pivot = array[end];
		for(int i = start; i < end; i++) {
			if(array[i] < pivot) {
				int temp = array[start];
				array[start] = array[i];
				array[i] = temp;
				start++;
			}
		}
		int temp = array[start];
		array[start] = pivot;
		array[end] = temp;
		return start;	
	}
	public static void QuickSort(int[] array, int start, int end) {
		int partition = partition(array, start, end);
		if(partition - 1 > start) {
			QuickSort(array, start, partition - 1);
		}
		if(partition + 1 < end) {
			QuickSort(array, partition + 1, end);
		}
	}
	
	public static void main(String[] args) {
		int array[] = {10,4,2,3,7,6,8,9,1};
		
//		long start = System.nanoTime();
//		HeapSort(array);
//		long end = System.nanoTime();
//		System.out.println("HeapSort runtime = "+(end - start));
		
		long startS = System.nanoTime();
		SelectionSort(array);
		long endS = System.nanoTime();
		System.out.println("SelectionSort runtime = "+(endS - startS));
		
//		long startM = System.nanoTime();
//		merge(array, 0, array.length-1);
//		long endM = System.nanoTime();
//		System.out.println("MergeSort runtime = "+(endM - startM));
		
		long startQ = System.nanoTime();
		QuickSort(array, 0, array.length-1);
		long endQ = System.nanoTime();
		System.out.println("QuickSort runtime = "+(endQ - startQ));
		
	}

}
