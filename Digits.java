import java.util.Scanner;
public class Digits {
	public static void main(String[] args) {
		Scanner input = new Scanner( System.in );
		String prompt = "Enter a three-digit number: ";
		int number;
		do {
			System.out.print(prompt);
			while (!input.hasNextInt()) {
				input.nextLine();
				System.out.print(prompt);
			}
			number = input.nextInt();
		}
		while (number < 100 || number > 999);
		input.close();
		
		System.out.println("");
		int mag = 1;
		while (number > 0) {
			switch(mag++) {
				case 1: System.out.print("The ones-place digit is:     "); break;
				case 2: System.out.print("The tens-place digit is:     "); break;
				case 3: System.out.print("The hundreds-place digit is: "); break;
				default: break;
			}
			System.out.println(number % 10);
		    number /= 10;
		}
	}
}
