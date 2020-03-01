public class RowSum {
	public static void main(String[] args) {
		int[][] data = {{3, 2, 5},
						{1, 4, 4, 8, 13},
						{9, 1, 0, 2},
						{0, 2, 6, 3, -1, -8}};

		System.out.println(rowSum(data, 0));
	}

	public static int rowSum(int[][] jag, int r) {
		int sum = 0;
		for (int c = 0; c < jag[r].length; c++) {
			sum += jag[r][c];
		}
		return sum;
	}
}
