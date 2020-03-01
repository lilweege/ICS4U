import java.util.Scanner;
public class MiddleLetter {
	public static void main(String[] args) {
		Scanner input = new Scanner( System.in );
		System.out.print("Enter a word: ");
		String word = input.nextLine();
		input.close();
		
		String letters = "";
		int len = word.length();
		
		if (len%2==0) {
			letters += String.valueOf(word.charAt(len/2-1));
			letters += String.valueOf(word.charAt(len/2));
		}
		else {
			letters += String.valueOf(word.charAt(len/2));
		}
		
		System.out.println("The middle letter(s) of you word is: " + letters);
	}
}