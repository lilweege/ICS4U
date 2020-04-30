import java.util.Scanner;
public class ccc18j2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.valueOf(in.nextLine());
		String before = in.nextLine();
		String after = in.nextLine();

		int cnt = 0;
		for (int i = 0; i < n; i++)
			if (before.charAt(i) == after.charAt(i) && before.charAt(i) == 'C')
				cnt++;
		System.out.println(cnt);
	}
}
