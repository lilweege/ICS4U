import java.util.Scanner;
public class OneAfter {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println(oneAfter(input.nextLine(), input.nextLine()));
		input.close();
	}

	private static boolean oneAfter(String a, String b) {
		return  (a.equalsIgnoreCase(b)) ||
				(a.length()-b.length() > 0 && a.substring(a.length()-b.length()).equalsIgnoreCase(b)) ||
				(b.length()-a.length() > 0 && b.substring(b.length()-a.length()).equalsIgnoreCase(a));
	}
}
