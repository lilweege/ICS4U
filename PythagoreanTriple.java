public class PythagoreanTriple {
	public static void main(String[] args) {
		for (int b = 1; b <= 100; b++) {
			for (int a = 1; a <= 100; a++) {
				double c = Math.sqrt(a * a + b * b);
				if (perfectSquare(a, b, c) && a <= b) { // a<=b skip duplicates
					System.out.println(a + "² + " + b + "² = " + (int)c + "²");
				}
			}
		}
	}
	
	private static boolean perfectSquare(int a, int b, double c) {
		return a * a + b * b == (int)c * (int)c;
	}
}