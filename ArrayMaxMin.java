public class ArrayMaxMin {
	public static void main(String[] args) {
		int[][] data = {{3, 2, 5},
						{1, 4, 4, 8, 13},
						{9, 1, 0, 2},
						{0, 2, 6, 3, -1, -8}};
		int max = data[0][0];
		int min = data[0][0];

		for (int r = 0; r < data.length; r++) {
			for (int c = 0; c < data[r].length; c++) {
				int num = data[r][c];
				max = Math.max(max, num);
				min = Math.min(min, num);
			}
		}
		System.out.println("Max is " + max);
		System.out.println("Min is " + min);
	}
}
