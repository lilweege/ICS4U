import java.util.Scanner;
public class Sunflowers {
	public static void main(String[] args) {
		Scanner f = new Scanner(System.in);
		int n = f.nextInt();
		int[][] grid = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int e = 0; e < n; e++) {
				grid[i][e] = f.nextInt();
			}
		}

		while (!isOriginal(grid)) {
			grid = rotateMatrix90CW(grid);
		}
		printMatrix(grid);
	}

	private static void printMatrix(int[][] mat) {
		for (int[] row : mat) {
			for (int n : row)
				System.out.print(n + " ");
			System.out.println();
		}
	}

	private static boolean isOriginal(int[][] mat) {
		int n = mat.length;
		int[] firstRow = mat[0];
		int[] firstCol = new int[n];
		for (int r = 0; r < n; r++)
			firstCol[r] = mat[r][0];

		int prevR = 0;
		int prevC = 0;
		for (int i = 0; i < n; i++) {
			if (firstCol[i] < prevC || firstRow[i] < prevR)
				return false;
			prevC = firstCol[i];
			prevR = firstRow[i];
		}
		return true;
	}

	private static int[][] rotateMatrix90CW(int[][] mat)
 	{
		int n = mat.length;
		// flip diagonal
		for (int r = 0; r < n; r++) {
			for (int c = r+1; c < n; c++) {
				int t = mat[r][c];
				mat[r][c] = mat[c][r];
				mat[c][r] = t;
			}
		}
		// flip horizonal
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n/2; c++) {
				int t = mat[r][c];
				mat[r][c] = mat[r][n-1-c];
				mat[r][n-1-c] = t;
			}
		}

		return mat;
	}
}
