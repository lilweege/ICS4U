import java.util.Arrays;
public class Frequency {
	public static void main(String[] args) {
		
		
		// in this program sorting is not necessary if a "frequency array" approach is used
		// this is common in counting problems, as well as a sorting algorithm called "counting sort"
		// there is debate about the time complexity of this. some say counting sort is O(N) while others say O(NlogN)
		
		int n = 100;
		int min = 1;
		int max = 10;
		
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = generateRandomInt(min, max);
		}
		System.out.println(Arrays.toString(numbers));

		
		int[] freq = new int[max];
		for (int num : numbers) {
			freq[num - min]++;
		}
		System.out.println("\nValue | Frequency");
		for (int i = min; i <= max; i++) {
			System.out.println(i + "\t" + freq[i - min]);
		}
	}
	
	public static int generateRandomInt(int min, int max) {
		return (int)(Math.random() * (max - min + 1) + min);
	}
}