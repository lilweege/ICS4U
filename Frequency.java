import java.util.Arrays;
public class Frequency {
	public static void main(String[] args) {
		int n = 100;
		int min = 1;
		int max = 10;
		
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = generateRandomInt(min, max);
		}

		int[] freq = new int[max];
		for (int num : numbers) {
			freq[num-1]++;
		}
		
		for (int i = 1; i <= max; i++) {
			for (int j = 0; j < freq[i-1]; j++) {
				System.out.print(i + " ");
			}
		}
		System.out.println("\nValue | Frequency");
		
		for (int i = 1; i <= max; i++) {
			System.out.println(i + "\t" + freq[i-1]);
		}
	}
	
	public static int generateRandomInt(int min, int max) {
		return (int)(Math.random()*(max-min+1)+min);
	}
}