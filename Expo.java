public class Expo {
	public static void main(String[] args) {
		System.out.println(traceExpo(2, 3)); // 8
		System.out.println(traceExpo(3, 4)); // 81
		System.out.println(traceExpo(10, 5)); // 100000
	}
	
	// methods only work for positive integer values
	public static int traceExpo(int b, int e) {
		if (e == 1) return b;
		System.out.print(b + "^" + e + " -> ");
		return b * traceExpo(b, e - 1);
	}
	
	// divide and conquer method
	public static int divExpo(int b, int e) {
		if (e == 0) return 1;
		int half = divExpo(b, e / 2);
		int full = half * half;
		if (e % 2 == 1) full *= b;
		return full;
	}
}