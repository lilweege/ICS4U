public class LargestElement1  {      
	public static void main (String[] args) {
		int[][] data =  {{3, 2, 5, 10, 9},                     
		                 {1, 4, -4, 8, 13},                    
		                 {9, 1, 0, 2, -8},                    
		                 {0, 2, 6, 3, -1}}; 
		for (int r = 0; r < data.length; r++) {
			System.out.println("The largest number in row " + String.valueOf(r+1) + " is "+ findMax(data[r]));
		}
	}
	
	public static int findMax(int[] arr) {
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
    	return max;
	}
}