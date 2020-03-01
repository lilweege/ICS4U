public class ColumnSumRaggedArray {
	public static void main(String[] args) {
		int[][] data = {{3, 2, 5},
						{1, 4, 4, 8, 13},
						{9, 1, 0, 2},
						{0, 2, 6, 3, -1, -8}};

		System.out.println(columnSum(data, 0));
	}

	public static int columnSum(int[][] jag, int c) {
		int sum = 0;
		for (int r = 0; r < jag.length; r++) {
			if (c < jag[r].length) {
				sum += jag[r][c];
			}
		}
		return sum;
	}
}
