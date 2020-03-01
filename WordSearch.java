import java.util.Scanner;
public class WordSearch {
	public static int testCases = 5;
	public static void main(String[] args) {
		Scanner f = new Scanner(System.in);
		for (int t = 0; t < testCases; t++) {
			int r = f.nextInt(), c = f.nextInt(); f.nextLine();
			char[][] board = new char[r][];
			for (int i = 0; i < r; i++)
				board[i] = f.nextLine().toCharArray();

			int m = f.nextInt(); f.nextLine();
			String[] words = new String[m];
			for (int i = 0; i < m; i++)
				words[i] = f.nextLine().replaceAll("[^A-Z]", "");

			board = searchBoard(board, words);
			printSecretCode(board);
			System.out.println();
		}
	}

	private static char[][] searchBoard(char[][] mat, String[] targets) {
		for (int r = 0; r < mat.length; r++)
			for (int c = 0; c < mat[r].length; c++)
				for (String target : targets)
					mat = replaceWord(mat, r, c, target.toCharArray());
		return mat;
	}

	private static char[][] replaceWord(char[][] mat, int row, int col, char[] target) {
		int r = mat.length;
		int c = mat[0].length;
		int t = target.length;
		int off = 0;
		while (row + off < r && off < t && Character.toLowerCase(mat[row+off][col]) == Character.toLowerCase(target[off])) {
			off++;
		}
		if (off == t) {
			for (int o = 0; o < t; o++) {
				mat[row+o][col] = Character.toLowerCase(mat[row+o][col]);
			}
			return mat;
		}
		off = 0;

		while (row - off > -1 && off < t && Character.toLowerCase(mat[row-off][col]) == Character.toLowerCase(target[off])) {
			off++;
		}
		if (off == t) {
			for (int o = 0; o < t; o++) {
				mat[row-o][col] = Character.toLowerCase(mat[row-o][col]);
			}
			return mat;
		}
		off = 0;

		while (col + off < c && off < t && Character.toLowerCase(mat[row][col+off]) == Character.toLowerCase(target[off])) {
			off++;
		}
		if (off == t) {
			for (int o = 0; o < t; o++) {
				mat[row][col+o] = Character.toLowerCase(mat[row][col+o]);
			}
			return mat;
		}
		off = 0;

		while (col - off > -1 && off < t && Character.toLowerCase(mat[row][col-off]) == Character.toLowerCase(target[off])) {
			off++;
		}
		if (off == t) {
			for (int o = 0; o < t; o++) {
				mat[row][col-o] = Character.toLowerCase(mat[row][col-o]);
			}
			return mat;
		}
		off = 0;

		while (row + off < r && col + off < c && off < t && Character.toLowerCase(mat[row+off][col+off]) == Character.toLowerCase(target[off])) {
			off++;
		}
		if (off == t) {
			for (int o = 0; o < t; o++) {
				mat[row+o][col+o] = Character.toLowerCase(mat[row+o][col+o]);
			}
			return mat;
		}
		off = 0;

		while (row - off > -1 && col - off > -1 && off < t && Character.toLowerCase(mat[row-off][col-off]) == Character.toLowerCase(target[off])) {
			off++;
		}
		if (off == t) {
			for (int o = 0; o < t; o++) {
				mat[row-o][col-o] = Character.toLowerCase(mat[row-o][col-o]);
			}
			return mat;
		}
		off = 0;

		while (row + off < r && col - off > -1 && off < t && Character.toLowerCase(mat[row+off][col-off]) == Character.toLowerCase(target[off])) {
			off++;
		}
		if (off == t) {
			for (int o = 0; o < t; o++) {
				mat[row+o][col-o] = Character.toLowerCase(mat[row+o][col-o]);
			}
			return mat;
		}
		off = 0;

		while (row - off > -1 && col + off < c && off < t && Character.toLowerCase(mat[row-off][col+off]) == Character.toLowerCase(target[off])) {
			off++;
		}
		if (off == t) {
			for (int o = 0; o < t; o++) {
				mat[row-o][col+o] = Character.toLowerCase(mat[row-o][col+o]);
			}
			return mat;
		}
		off = 0;

		return mat;
	}

	private static void printSecretCode(char[][] board) {
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				if (Character.isUpperCase(board[r][c])) {
					System.out.print(board[r][c]);
				}
			}
		}
	}
}
