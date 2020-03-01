import java.util.Scanner;
public class Front2Encryption {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println(front2Encryption(input.nextLine()));
		input.close();
	}

	private static String front2Encryption(String s) {
		String out = "";
		int len = (s.length() >= 2) ? 2 : s.length();
		out += s.substring(0, len);
		out += s;
		out += s.substring(0, len);
		return out;
	}
}