import java.util.Arrays;
public class LargestElement2 {
	public static void main (String[] args) {
		int[][] data =  {{3, 2, 5, 10, 9},                     
		                 {1, 4, -4, 8, 13},                    
		                 {9, 1, 0, 2, -8},                    
		                 {0, 2, 6, 3, -1}}; 
		System.out.println(Arrays.toString(findMax(data)));
	}
	
	public static int[] findMax(int[][] mat){
		int[] maxValues = new int[mat.length];
		for (int r = 0; r < mat.length; r++) {
			for (int c = 0; c < mat[r].length; c++) {
				maxValues[r] = Math.max(maxValues[r], mat[r][c]);
			}
		}
		return maxValues;
	}
}