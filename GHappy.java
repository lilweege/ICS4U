import java.util.Scanner;
public class GHappy {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println(gHappy(input.nextLine()));
		input.close();
	}

	private static boolean gHappy(String s) {
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 'g') {
				if ((i > 0 && c[i-1] != 'g') && (i < c.length-1 && c[i+1] != 'g')) {
					return false;
				}
			}
		}
		return true;
	}
}