import java.util.Scanner;
public class TwoWords {
	public static void main(String[] args) {
		Scanner input = new Scanner( System.in );
		System.out.print("Enter first word: ");
		String firstWord = input.nextLine();
		System.out.print("Enter second word: ");
		String secondWord = input.nextLine();
		input.close();
		
		int numberDots = 30 - (firstWord.length() + secondWord.length());
		
		
		System.out.print(firstWord);
		for (int i = 0; i < numberDots; i++) {
			System.out.print(".");	
		}
		System.out.print(secondWord);
	}
}