import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class PalindromeList {
	public static void main(String[] args) {
		System.out.println(palindromeList(nextLineToArrl()));
	}

	public static ArrayList<Integer> nextLineToArrl() {
		ArrayList<Integer> arrl = new ArrayList<Integer>();
		for (Integer n : Arrays.stream(new Scanner(System.in).nextLine().split(" ")).mapToInt(Integer::parseInt).toArray())
			arrl.add(n);
		return arrl;
	}

	public static boolean palindromeList(ArrayList<Integer> arrl) {
		for (int i = 0; i < arrl.size()/2; i++)
            if (arrl.get(i) != arrl.get(arrl.size()-1-i))
                return false;
        return true;
	}
}
