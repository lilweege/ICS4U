public class SumOfEachRow {
	public static void main(String[] args) {
		int[][] data = {{3, 2, 5},
						{1, 4, 4, 8, 13},
						{9, 1, 0, 2},
						{0, 2, 6, 3, -1, -8}};

		for (int sum : allRowSums(data))
			System.out.print(sum + " ");
	}

	public static int[] allRowSums(int[][] jag) {
		int[] sums = new int[jag.length];
		for (int r = 0; r < jag.length; r++) {
			for (int c = 0; c < jag[r].length; c++) {
				sums[r] += jag[r][c];
			}
		}
		return sums;
	}
}
