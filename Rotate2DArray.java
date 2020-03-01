import java.util.Scanner;
public class Rotate2DArray {
	public static Scanner input = new Scanner(System.in);
	public static void main (String[] args) {
		System.out.println("This program will output a rotated version of a given 2D int array (matrix).");
		System.out.println("STEP 1: Enter an integer n.");
		System.out.println("STEP 2: Enter n rows of integers. Each row should contain n integers.");
		System.out.println("An integer matrix of size n*n will be generated.");
		System.out.println("Here is an example input: \n3\n1 2 3\n4 5 6\n7 8 9");

		int[][] grid = generateMatrix(input.nextInt());

		System.out.println("Enter the number of times you want to rotate the matrix (90 degrees clockwise).");

		int[][] rotated = rotateMatrixN(grid, input.nextInt());

		System.out.println("New rotated grid:");

		printMatrix(rotated);
	}

	private static void printMatrix(int[][] mat) {
		for (int r = 0; r < mat.length; r++) {
			for (int c = 0; c < mat[r].length; c++) {
				System.out.print(mat[r][c] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] generateMatrix(int n) {
		int[][] mat = new int[n][n];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				mat[r][c] = input.nextInt();
			}
		}
		return mat;
	}

	private static int[][] rotateMatrixN(int[][] mat, int n) {
		for (int i = 0; i < n%4; i++) {
			mat = rotateMatrix90CW(mat);
		}
		return mat;
	}

	private static int[][] rotateMatrix90CW(int[][] mat) {
		// using square symmetries we can rotate our matrix by 90 degrees clockwise in two simple steps
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
