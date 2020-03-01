import java.util.Arrays;
//import java.util.Scanner;
public class CopyArray {
	public static void main(String[] args) {

//		/*using scanner*/
//		Scanner input = new Scanner(System.in);
//		System.out.print("enter number of rows: ");
//		int n = Integer.valueOf(input.nextLine());
//		int[][] data = new int[n][];
//
//		for (int r = 0; r < n; r++) {
//			data[r] = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//		}
//		input.close();
		
		
//		/*also hard-coding the data:*/
//		int[][] data = {{ 3, 2, 5, 10, 9 },
//						{ 1, 4, -4, 8, 13},
//						{ 9, 1, 0, 2, -8 },
//						{ 0, 2, 6, 3, -1 }};

		/*same thing, except jagged:*/
		int[][] data = {{ 3, 2 },
						{ 1, 4, -4, 8, 13, 5, 10, 9, 1, 0, 2, -8 },
						{ 9 },
						{ 0, 2, 6, 3, -1 }};
		
		
		print2DArr(data);
		
		System.out.println();
		int[][] copyData = copyArray(data);
		print2DArr(copyData);
	}
	
//	/*simple*/
//	public static void print2DArr(int[][] arr) {
//		for (int[] row : arr) {
//			for (int elm : row) {
//				System.out.print(elm + " ");
//			}
//			System.out.print("\n");			
//		}
//	}

	
//	/*print visually (manual)*/
//	public static void print2DArr(int[][] arr) {
//		System.out.print("[");
//		for (int r = 0; r < arr.length; r++) {
//			if (r != 0) {
//				System.out.print(" ");
//			}
//			System.out.print("[");
//			for (int c = 0; c < arr[r].length; c++) {
//				System.out.print(arr[r][c]);
//				if (c != arr[r].length-1) {
//					System.out.print(", ");
//				}
//			}
//			System.out.print("]");
//			if (r == arr.length-1) {
//				System.out.print("]");				
//			}
//			else {
//				System.out.print(",");				
//			}
//			System.out.println();
//		}
//	}

	/*better*/
	public static void print2DArr(int[][] arr) {
		for (int[] row : arr)
			System.out.print((row == arr[0] ? "[" : " ") + Arrays.toString(row) + (row == arr[arr.length-1] ? "]" : ",") + "\n");
	}
	
	

//	/*straightforward method, copy one value at a time:*/
//	public static int[][] copyArray (int[][] arr) {
//		int[][] copy = new int[arr.length][];
//		for(int r = 0; r < arr.length; r++) {
//			copy[r] = new int[arr[r].length];
//			for(int c = 0; c < arr[r].length; c++) {
//				copy[r][c] = arr[r][c];
//			}
//		}
//		return copy;
//	}
	
	
//	/*alternatively copy whole array at a time:*/
//	public static int[][] copyArray (int[][] arr) {
//		int[][] copy = new int[arr.length][];
//		for (int r = 0; r < arr.length; r++) {
//			copy[r] = new int[arr[r].length];
//			System.arraycopy(arr[r], 0, copy[r], 0, arr[r].length);
//		}
//		return copy;
//	}
	
	
//	/*also using Arrays import:*/
//	public static int[][] copyArray(int[][] arr) {
//	    int[][] copy = new int[arr.length][];
//	    for (int r = 0; r < arr.length; r++) {
//	    	copy[r] = Arrays.copyOf(arr[r], arr[r].length);
//	    }
//	    return copy;
//	}
	
	
	/*or even:*/
	public static int[][] copyArray (int[][] arr) {
		return Arrays.stream(arr).map(int[]::clone).toArray(int[][]::new);
	}
	
}