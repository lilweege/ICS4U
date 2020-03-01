import java.util.Scanner;
import java.util.Arrays;
public class TriplesNotAllowed {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// any int array input will work besides taking user input
		int[] numbers = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// triples are NOT allowed, print inverse of result of method
		System.out.println(!hasTriples(numbers));
		input.close();
	}

	private static boolean hasTriples(int[] arr) {
		int consecutive = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i-1]) {
				consecutive++;
				if (consecutive == 3) {
					return true;
				}
			}
			else {
				consecutive = 1;
			}
		}
		return false;
	}
}