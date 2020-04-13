public class isPalindrome {
	public static void main(String[] args) {
		System.out.print(pal("racecar"));
	}

	private static boolean pal(String s) {
		return pal(s, 0, s.length() - 1);
	}
	
	private static boolean pal(String s, int i, int j) {
		if (i >= j) return true;
		if (s.charAt(i) != s.charAt(j)) return false;
		return pal(s, i + 1, i - 1);
	}
}