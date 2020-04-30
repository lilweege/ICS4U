import java.util.Scanner;
public class ccc07j4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.nextLine().replaceAll("\\s", "");
		String b = in.nextLine().replaceAll("\\s", "");

		int la = a.length();
		int lb = b.length();
		boolean anagram = (la == lb);
		if (anagram) {
			int[] diff = new int[26];
			for (int i = 0; i < la; i++) {
				diff[a.charAt(i) - 'A']++;
				diff[b.charAt(i) - 'A']--;
			}
			for (int d : diff) {
				if (d != 0) {
					anagram = false;
					break;
				}
			}
		}

		System.out.println(anagram ? "Is an anagram." : "Is not an anagram.");
	}
}
