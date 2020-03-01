import java.util.Scanner;
public class Nim {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean cwin = false;
		int stones = (int)(Math.random() * 15) + 15;

		while (true) {
			prompt(stones);
			String move = playerMove(input);
			if (isValidEntry(move, stones)) {
				stones -= Integer.parseInt(move);
				if (stones == 0) {
					break;
				}
				stones -= computerMove(stones);
				if (stones == 0) {
					cwin = true;
					break;
				}
			}
		}
		input.close();

		System.out.println("THE " + (cwin ? "PLAYER" : "COMPUTER") + " BEATS THE " + (cwin ? "COMPUTER" : "PLAYER") + "!");
	}

	private static String playerMove(Scanner in) {
		return in.nextLine();
	}

	private static void prompt(int n) {
		System.out.print("There are " + n + " stones. How many would you like to take? ");
	}

	private static boolean isValidEntry(String s, int n) {
	    try {
	      int i = Integer.parseInt(s.trim());
	      if (i > 3 || i > n) return false;
	    }
	    catch (NumberFormatException nfe) {
	    	return false;
	    }
		return true;
	}
	
	private static int computerMove(int n) {
		int c = drawStones(n >= 3 ? 3 : n);
		System.out.print("There are " + n + " stones. The computer takes " + c + " stone" + (c == 1 ? "" : "s") + ".\n");
		return c;
	}

	private static int drawStones(int max) {
		return (int)(Math.random() * max) + 1;
	}	
}