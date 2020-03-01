public class PerfectIntegers {
	public static void main(String[] args) {
		for (int n = 1; n <= 100; n++)
			if (isPerfect(n))
				System.out.println(n);
	}

	private static boolean isPerfect(int n) {
		// brute force sum of factors
		int sum = 0;
		for (int i = 1; i < n && sum <= n; i++)
			if (n%i==0)
				sum += i;
		return sum == n;		
	}
}