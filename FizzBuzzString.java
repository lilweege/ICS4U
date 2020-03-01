import java.util.Scanner;
public class FizzBuzzString {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = input.nextInt();
		input.close();
		
		System.out.println(fizzBuzzString(number));
	}

	private static String fizzBuzzString(int n) {
		String out = "";
		boolean fizz = n%3==0;
		boolean buzz = n%5==0;

		if (fizz) out += "Fizz";
		if (buzz) out += "Buzz";
		
		if (out == "") out = String.valueOf(n);
		
		out += "!";
		return out;
	}
}
