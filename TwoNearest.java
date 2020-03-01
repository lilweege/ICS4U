/* Luigi Quattrociocchi
 * February 2020
 * Two Nearest
 *
 * Recursive divide and conquer solution
 * Time complexity: O(n*log(n))
 *
 * there are many online resources and solutions similar to this one
 * A couple helpful links regarding this problem:
 * https://en.wikipedia.org/wiki/Closest_pair_of_points_problem#Planar_case
 * https://www.geeksforgeeks.org/closest-pair-of-points-using-divide-and-conquer-algorithm/
 * https://www.tutorialspoint.com/Closest-Pair-of-Points-Problem
 * https://classes.engineering.wustl.edu/cse241/handouts/closestpair.pdf
 * https://www.cs.cmu.edu/~ckingsf/bioinfo-lectures/closepoints.pdf
 */

import java.util.Scanner; // take user input for non hard-coded points
import java.util.ArrayList; // dynamic sizing is used when size unknown
import java.util.Arrays; // sorting using comparator and copying arrays
import java.util.Comparator; // sorting of objects by multiple parameter

public class TwoNearest {

	// global variables keep track of closest two points
	// all time best must be stored since recursive method won't know it
	// since the question asks us for which two points are closest, we store it
	static Point[] best = new Point[2];
	static double allTimeBest = Double.MAX_VALUE;

	// this method is necessary if you want to know WHICH points are closest,
	// rather than just knowing the distance between the closest two points
	private static void storeBestPoints(Point a, Point b, double d) {
		if (d < allTimeBest) {
			best = new Point[] {a, b};
			allTimeBest = d;
		}
	}


	public static void main(String[] args) {
		// create a "point" array of points
		// point constructor takes and x (double) and y (double)
		// see point class at bottom for more details

//		/*test case given in question*/
//		Point[] points = new Point[] {	new Point(-1, 3),
//										new Point(-1, -1),
//										new Point(1, 1),
//										new Point(2, 0.5),
//										new Point(2, -1),
//										new Point(3, 3),
//										new Point(4, 2),
//										new Point(4, -0.5)};


		/* 	also user input, here is an example case:
			first integer n declares number of points
			the next n lines contain x y coordinates of point p
			3
			-0.25 0.5
			-4 1.66
			7.77 -2
		*/
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		Point[] points = new Point[n];
//		for (int i = 0; i < n; i++)
//			points[i] = new Point(in.nextDouble(), in.nextDouble());
//		in.close();


		/*randomly generate points*/
		// the more points generated, the longer the program will take to run
		// in this case 1 million points will take approx 10 seconds,
		// since the time complexity of this solution is O(nlogn)

		int n = 1000000; // number of points to generate
		int precision = 20; // number of decimal place digits (limit is approx 15 digits for doubles)
		int min = -1000000; // lower bound for x and y
		int max =  1000000; // upper bound for x and y

		// generate points
		Point[] points = new Point[n];
		for (int i = 0; i < n; i++)
			points[i] = generateRandomPoint(min, max, precision);

//		/*print points (will take a long time with many points)*/
//		for (Point p : points)
//			System.out.print("(" + p.x + ", " + p.y + "), ");
//		System.out.println();

		// call method to find distance
		double d = closestPairDistance(points);
		// print distance and global variable best points
		System.out.println("The distance between the two closest points, (" + best[0].x + ", " + best[0].y + ") and (" + best[1].x + ", " + best[1].y + "), is " + d + " units.");
	}

	private static Point generateRandomPoint(int min, int max, int precision) {
		return new Point(	Math.floor((Math.random()*(max-min+1)+min)*Math.pow(10, precision))/Math.pow(10, precision),
							Math.floor((Math.random()*(max-min+1)+min)*Math.pow(10, precision))/Math.pow(10, precision));
	}

	// calculate distance between two points method
	private static double getDistance(Point a, Point b) {
		return Math.abs(Math.sqrt((a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y)));
	}


	private static double closestPairDistance(Point[] arr) {
		// best distance in the current subdivided array
		double d;
		// make copies of array and sort them by x and by y
		int n = arr.length;
		Point[] byX = Arrays.copyOf(arr, n);
		Point[] byY = Arrays.copyOf(arr, n);
		Arrays.sort(byX, Point.xComparator);
		Arrays.sort(byY, Point.yComparator);

		// if we reach the point at which our subdivided array only contains less than three elements
		// stop recursing, return closest two of remaining points
		if (n <= 3) {
			d = Double.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					d = Math.min(d, getDistance(byX[i], byX[j]));
					storeBestPoints(byX[i], byX[j], d);
				}
			}
			return d;
		}

		// if we haven't stopped recursing yet
		// split array into two halves
		Point[] leftHalf = Arrays.copyOfRange(byX, 0, n/2); // from zero to midpoint
		Point[] rightHalf = Arrays.copyOfRange(byX, n/2, n); // from midpoint to end

		// recurse
		// best distance is the lower of the best distances between the two halves
		d = Math.min(closestPairDistance(leftHalf), closestPairDistance(rightHalf));

		// get midpoint
		Point midPoint = byX[n/2];

		// create middle strip in which the x distance from the center to the point is less than best
		// this strip contains "possible" better distances than current best distance
		// using arraylist initially because it is unknown how many will be in strip
		ArrayList<Point> arrl = new ArrayList<Point>();
		for (Point p : byY)
			if (Math.abs(p.x - midPoint.x) < d)
				arrl.add(p);

		// convert arraylist to array
		Point[] strip = new Point[arrl.size()];
		strip = arrl.toArray(strip);

		// iterate over strip, check if a better distance is found
		double best = d;
		for (int j = 0; j < strip.length-2; j++) {
			for (int i = j+1; i < strip.length-2; i++) {
				Point a = strip[i], b = strip[j];
				if (a.y-b.y < d) {
					double t = getDistance(a, b);
					if (t < best) {
						best = t;
						storeBestPoints(a, b, best);
					}
				} else break;
			}
		}

		return best;
	}
}


// custom point class with comparators
class Point {
	public final double x;
	public final double y;
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	// "Arrays.sort(array)" using compareTo is limiting if you want to sort by different parameters
	// instead, use the second parameter of "Arrays.sort(array, comparator)" to specify own sorting
	// below are the Point comparators (one for x and one for y), since this solution requires both
    public static Comparator<Point> xComparator = new Comparator<Point>() {
		public int compare(Point a, Point b) {
//			/*double has a built in compare*/
//			return Double.compare(a.x, b.x);

			/*but we can do essentially the same thing here*/
			if (a.x > b.x) return 1;
			if (a.x < b.x) return -1;
			return 0;
		}
	};

	// same explanation as previous applies
    public static Comparator<Point> yComparator = new Comparator<Point>() {
		public int compare(Point a, Point b) {
			return Double.compare(a.y, b.y);
		}
	};
}
