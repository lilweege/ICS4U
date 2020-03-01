public class TopTriangle {
	public static void main(String[] args) {
		// alignment is off for sizes larger than 9
		int size = 9;
		for (int r = 1; r <= size; r++) {
			int c = 2*r-1;
			for (int s = 0; s < 2*size-c; s++) {
				System.out.print(" ");
			}
			for (int n = 0; n < c; n++) {
				System.out.print(r-Math.abs(c/2-n) + " ");
			}
			System.out.println("");
		}
	}
}