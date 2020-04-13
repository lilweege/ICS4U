import java.util.HashMap;
public class Fibonacci {
	public static void main(String[] args) {
		for (int n = 0; n < 10; n++) {
			System.out.println(n + " -> " + fib(n));
		}
	}
	
	static HashMap<Integer, Integer> dp = new HashMap<>() { { put(0, 0); put(1, 0); put(2, 1); } };
	
	private static int fib(int n) {
		if (!dp.containsKey(n)) {
			dp.put(n, fib(n - 2) + fib(n - 1));
		}
		return dp.get(n);
	}
}