import java.util.Scanner;

public class GridSums {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int z = in.nextInt();
		int[][] grid = new int[z][z];
		for (int r = 0; r < z; r++)
			for (int c = 0; c < z; c++)
				grid[r][c] = in.nextInt();

		int t = in.nextInt();
		int[][] pairs = new int[t][2];
		for (int i = 0; i < t; i++)
			pairs[i] = new int[] {in.nextInt(), in.nextInt()};
		in.close();

		for (int[] pair : pairs) {
			int row = pair[0]-1;
			int col = pair[1]-1;
			int sum = 0;

			for (int r = 0; r < z; r++)
				sum += grid[r][col];
			for (int c = 0; c < z; c++)
				sum += grid[row][c];

			System.out.println(sum);
		}
	}
}
