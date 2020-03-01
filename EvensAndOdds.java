public class EvensAndOdds {
	public static void main(String[] args) {
		int len = 25, min = 0, max = 99;
		
		
		int[] numbers = new int[len];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random()*(max+1))+min;
		}
		
		
		System.out.println("Odd:");
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i]%2!=0) {
				System.out.print(numbers[i] + " ");
			}
		}
		
		System.out.println("\nEven:");
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i]%2==0) {
				System.out.print(numbers[i] + " ");
			}
		}
	}
}