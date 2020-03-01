import java.util.Scanner;
public class ArrayABC {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println(arrayABC(input.nextLine().split(" ")));
		input.close();
	}

	private static boolean arrayABC(String[] arr) {
		return String.join("", arr).contains("ABC");
	}
}
