import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
public class RemoveZeros {
	public static void main(String[] args) {
		System.out.println(removeAllZeros(nextLineToArrl()));
	}

	public static ArrayList<Integer> nextLineToArrl() {
		ArrayList<Integer> arrl = new ArrayList<Integer>();
		for (Integer n : Arrays.stream(new Scanner(System.in).nextLine().split(" ")).mapToInt(Integer::parseInt).toArray())
			arrl.add(n);
		return arrl;
	}

	public static ArrayList<Integer> removeAllZeros(ArrayList<Integer> arrl) {
		int prevSize;
		do {
			prevSize = arrl.size();
			arrl = removeZeros(arrl);
		}
		while (arrl.size() != prevSize);
		return arrl;
	}

	public static ArrayList<Integer> removeZeros(ArrayList<Integer> arrl) {
		HashMap<Integer, Integer> seen = new HashMap<Integer, Integer>();
		int sum = 0;
		int start;
		for (int i = 0; i < arrl.size(); i++) {
			int num = arrl.get(i);
			sum += num;
			if (num == 0 || sum == 0 || seen.get(sum) != null) {
				if (num == 0) {
					start = i;
				}
				else if (sum == 0) {
					start = 0;
				}
				else {
					start = seen.get(sum)+1;
				}

				for (int j = i; j >= start; j--) {
					int t = j;
					arrl.remove(arrl.get(t));
				}
				break;
			}
			seen.put(sum, i);
		}

		return arrl;
	}
}
