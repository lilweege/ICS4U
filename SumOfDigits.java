public class SumOfDigits {
	public static void main(String[] args) {
		System.out.println(sumDigits(126)); // 9
	}
	
	public static int sumDigits(int n) {
//		n = Math.abs(n);
		if (n < 10) return n;
		return n % 10 + sumDigits(n / 10);
	}
}