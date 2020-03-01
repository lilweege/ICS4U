import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class NoDuplicatesInList {
	public static void main(String[] args) {
		System.out.println(removeDuplicates(nextLineToArrl()));
	}

	public static ArrayList<Integer> nextLineToArrl() {
		ArrayList<Integer> arrl = new ArrayList<Integer>();
		for (Integer n : Arrays.stream(new Scanner(System.in).nextLine().split(" ")).mapToInt(Integer::parseInt).toArray())
			arrl.add(n);
		return arrl;
	}

	public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> arrl) {
		return new ArrayList<Integer>(new HashSet<Integer>(arrl));
	}
}
