import java.util.Arrays;
public class SortingRoutines {

	
	/*
	 * A good website for visualizing some sorting algorithms: https://visualgo.net/bn/sorting
	 * */
	
	public static void main(String[] args) {
		int[] data;
		
		
		
		
		// first three passes of insertion sort
		data = new int[] { 5, 1, 4, 8, 9, 6, 3 };
		System.out.println("Initial data: " + Arrays.toString(data));
		for (int i = 0; i < 3; i++) {
			int j;
			int hold = data[i];
			for (j = i; j > 0 && data[j-1] > hold; j--) {
				data[j] = data[j-1];
			}
			data[j] = hold;
		}
		System.out.println("After first three passes of insertion sort: " + Arrays.toString(data) + "\n");
		

		
		
		
		// first three passes of selection sort
		data = new int[] { 5, 1, 4, 8, 9, 6, 3 };
		System.out.println("Initial data: " + Arrays.toString(data));
		for (int i = 0; i < 3; i++) {
			int min = i;
			for (int j = i; j < data.length; j++) {
				if (data[j] < data[min]) {
					min = j;
				}
			}
			
			int t = data[min];
			data[min] = data[i];
			data[i] = t;
		}
		System.out.println("After first three passes of selection sort: " + Arrays.toString(data) + "\n");

		
		
		
		
		// first three passes of bubble sort
		data = new int[] { 5, 1, 4, 8, 9, 6, 3 };
		System.out.println("Initial data: " + Arrays.toString(data));

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < data.length-1-i; j++) {
				if (data[j] > data[j+1]) {
					int t = data[j];
					data[j] = data[j+1];
					data[j+1] = t;
				}
			}
		}
		System.out.println("After first three passes of bubble sort: " + Arrays.toString(data) + "\n");
		
		System.out.println();
		
		
		
		
		
		
		
		
		
		Integer[] data1 = new Integer[] { 9, 5, 11, 6, 4, 10, 7 };
		System.out.println("Full number insertion sort:");
		System.out.println(Arrays.toString(data1));
		insertionSort(data1);

		String[] planets = new String[] { "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto" };
		System.out.println("Full planet insertion sort:");
		insertionSort(planets);
		
		String[] data2 = new String[] { "Rottweiler", "Beagle", "Vizsla", "Dachshund", "Schnauzer" };
		System.out.println("Full dog selection sort:");
		System.out.println(Arrays.toString(data2));
		selectionSort(data2);
		
		
		Integer[] data3 = new Integer[] { 5, 10, 5, 4, 9, 7 };
		System.out.println("Full number bubble sort:");
		System.out.println(Arrays.toString(data3));
		bubbleSort(data3);
		
	}
	
	
	public static <T extends Comparable<T>> T[] insertionSort(T[] arr) {
		int j;
		for (int i = 0; i < arr.length; i++) {
			T hold = arr[i];
			for (j = i; j > 0 && arr[j-1].compareTo(hold) > 0; j--) {
				arr[j] = arr[j-1];
			}
			arr[j] = hold;

			System.out.println(Arrays.toString(arr));
		}
		System.out.println();
		return arr;
	}
	
	public static <T extends Comparable<T>> T[] selectionSort(T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j].compareTo(arr[min]) < 0) {
					min = j;
				}
			}
			
			T t = arr[min];
			arr[min] = arr[i];
			arr[i] = t;
			
			System.out.println(Arrays.toString(arr));
		}
		System.out.println();
		return arr;
	}
	
	
	public static <T extends Comparable<T>> T[] bubbleSort(T[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				if (arr[j].compareTo(arr[j+1]) > 0) {
					T t = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = t;
				}
			}
			
			System.out.println(Arrays.toString(arr));
		}
		System.out.println();
		return arr;
	}
	
	
	
	
	
	
	
	
	public static int[] quickSort(int[] arr) {
		return quickSort(arr, 0, arr.length-1);
	}
	
	public static int[] quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int pivotInd = partition(arr, left, right);
			quickSort(arr, left, pivotInd-1);
			quickSort(arr, pivotInd+1, right);
		}
		return arr;
	}
	
	public static int partition(int[] arr, int left, int right) {
		int pivot = arr[right];
		int i = left - 1;
		for (int j = left; j < right; j++) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		arr[right] = arr[i+1];
		arr[i+1] = pivot;
		return i+1;
	}
}
