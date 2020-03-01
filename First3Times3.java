import java.util.Scanner;;
public class First3Times3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println(first3Times3(input.nextLine()));
		input.close();
	}

	private static String first3Times3(String s) {
		String out = "";
		int len = (s.length() >= 3) ? 3 : s.length();
		for (int i = 0; i < 3; i++) out += s.substring(0, len);
		return out;
	}
}