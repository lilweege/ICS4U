public class BunnyEars {
	public static void main(String[] args) {
		System.out.println(bunnyEars(0)); // 0
		System.out.println(bunnyEars(1)); // 2
		System.out.println(bunnyEars(2)); // 4
		System.out.println(bunnyEars(3)); // 6
		System.out.println(bunnyEars(4)); // 8
		
//		alternative solution
//		System.out.println(n > 0 ? n * 2 : 0);
	}
	
	public static int bunnyEars(int n) {
		if (n <= 0) return 0;
		if (n == 1) return 2;
		return 2 + bunnyEars(n-1);
	}
}