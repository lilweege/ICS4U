import java.util.Scanner;
public class Hexudoku {
	public static int t = 10;
	public static int n = 16;
	public static char[] HEXLUT = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', '-'};
	public static void main(String[] args) {
		Scanner f = new Scanner(System.in);
		char[][][] boards = new char[t][n][n];
		for (int b = 0; b < t; b++)
			for (int r = 0; r < n; r++)
				boards[b][r] = f.nextLine().toCharArray();

		for (char[][] board : boards)
			System.out.println(fillBoard(board));
	}

	private static int fillBoard(char[][] board) {
		int filledIn = 0;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (board[r][c] == '-') {
					board[r][c] = getLowestHex(board, r, c, r/4*4 + c/4);
					if (board[r][c] != '-') {
						filledIn++;
					}
				}
			}
		}
		return filledIn;
	}

	private static char getLowestHex(char[][] board, int row, int col, int quad) {
		int i = 0;
		char lowest = HEXLUT[i];
		while (i <= 16 && isValid(board, row, col, quad, lowest))
			lowest = HEXLUT[i++];
		return lowest;
	}

	private static boolean isValid(char[][] board, int row, int col, int quad, char target) {
		return charInRow(board, row, target) || charInCol(board, col, target) || charInQuad(board, quad, target);
	}

	private static boolean charInRow(char[][] board, int row, char target) {
		for (int c = 0; c < n; c++)
			if (board[row][c] == target)
				return true;
		return false;
	}

	private static boolean charInCol(char[][] board, int col, char target) {
		for (int r = 0; r < n; r++)
			if (board[r][col] == target)
				return true;
		return false;
	}

	private static boolean charInQuad(char[][] board, int quad, char target) {
		int row = quad/4*4;
		int col = quad%4*4;
		for (int r = row; r < row+4; r++)
			for (int c = col; c < col+4; c++)
				if (board[r][c] == target)
					return true;
		return false;
	}
}
