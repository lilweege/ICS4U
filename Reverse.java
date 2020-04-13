public class Reverse {
	public static void main(String[] args) {
		String str = "pneumonoultramicroscopicsilicovolcanoconiosis";
		System.out.println(str);
		String rev = reverse(str);
		System.out.println(rev);
		
		boolean ans = new StringBuilder().append(str).reverse().toString().equals(rev); // check
		System.out.println(ans);
	}
	
	private static String reverse(String s) {
		return reverse(new StringBuilder().append(s), 0, s.length() - 1).toString();
	}
	
	private static StringBuilder reverse(StringBuilder sb, int i, int j) {
		if (i >= j) return sb;
		char t = sb.charAt(i);
		sb.setCharAt(i, sb.charAt(j));
		sb.setCharAt(j, t);
		return reverse(sb, i + 1, j - 1);
	}
}