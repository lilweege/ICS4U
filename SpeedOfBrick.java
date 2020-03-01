import java.util.Scanner;
public class SpeedOfBrick {
	public static void main(String[] args) {
		Scanner input = new Scanner( System.in );
		String prompt = "Enter the number of seconds: ";
		
		double gravity = 32.174;
		double seconds;
		System.out.print(prompt);
		while (!input.hasNextDouble()) {
			input.nextLine();
			System.out.print(prompt);
		}
		seconds = input.nextDouble();
		input.close();

		double velocity = 0.5 * gravity * seconds * seconds; // 3.01948665886 -> 146.67
		System.out.println("Speed of the brick: " + velocity + " feet per second");
	}
}
