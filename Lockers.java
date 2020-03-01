// import java.util.ArrayList;
public class Lockers {
	public static void main(String[] args) {
		int numLockers = 1000, numStudents = 1000;
		boolean[] lockers = new boolean[numLockers]; // all lockers closed to start, default value of boolean is false

		for (int s = 1; s <= numStudents; s++)
			for (int l = 0; l < numLockers; l+=s)
				lockers[l] = !lockers[l];


		int numOpen = 0;
		for (boolean locker : lockers)
			if (locker)
				numOpen++;
		System.out.println("# open: " + numOpen);


		// ArrayList<Integer> open = new ArrayList<Integer>();
		// for (int l = 0; l < numLockers; l++)
		// 	if (lockers[l])
		// 		open.add(l);
		// System.out.println("# open: " + open.size());



		// when printing all the open lockers there will be a pattern
		// every number locker that is open will be a perfect square
		// System.out.println("open lockers: " + open);

		// knowing this, we can come up with this math trick
		// the number of open lockers is equal to the square root of numLockers
		// however this is only guarenteed to work when numStudents == numLockers
		// System.out.println("# open: " + (int)Math.sqrt(numLockers));
	}
}
