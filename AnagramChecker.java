import java.util.Scanner;
public class AnagramChecker {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter first phrase: ");
		String firstPhrase = input.nextLine().replaceAll("\\s+","");
		System.out.print("Enter second phrase: ");
		String secondPhrase = input.nextLine().replaceAll("\\s+","");
		input.close();

		int len1 = firstPhrase.length();
		int len2 = secondPhrase.length();
		boolean anagram = len1 == len2;
		
		if (anagram) {
			char[] firstArray = firstPhrase.toCharArray();
			char[] secondArray = secondPhrase.toCharArray();
			int[] diffHash = new int[26];
			
			for (int i = 0; i < len1; i++) {
			    int fc = (int) firstArray[i] - 'A';
			    if (fc >= 0 && fc <= 26) diffHash[fc]++;
			    int sc = (int) secondArray[i] - 'A';
			    if (sc >= 0 && sc <= 26) diffHash[sc]--;
			}

			for (int i = 0; i < 26; i++) {
				if (diffHash[i] != 0) {
					anagram = false;
					break;
				}
			}
		}
		
		System.out.println("Is " + (anagram ? "" : "not ") + "an anagram.");
	}
}
