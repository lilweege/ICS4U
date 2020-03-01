import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;


public class MergeLists {
	public static void main(String[] args) {
		System.out.println(mergeLists(nextLineToArrl(), nextLineToArrl()));
	}

	public static ArrayList<Integer> nextLineToArrl() {
		ArrayList<Integer> arrl = new ArrayList<Integer>();
		for (Integer n : Arrays.stream(new Scanner(System.in).nextLine().split(" ")).mapToInt(Integer::parseInt).toArray())
			arrl.add(n);
		return arrl;
	}

	public static ArrayList<Integer> mergeLists(ArrayList<Integer> a, ArrayList<Integer> b) {
		ArrayList<Integer> merged = new ArrayList<Integer>();
		merged.addAll(a);
		merged.addAll(b);
		Collections.sort(merged);
		return merged;
	}
}
