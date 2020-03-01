/*
 * Name: Luigi Quattrociocchi
 * Date: Feb 2020
 * Description: Waterloo CCC 2019 Problem J3: Are we there yet?
 * 
 */

import java.util.Scanner;
public class AreWeThereYet {
	public static void main(String[] args) {
		
		// put user input into string array of numbers
		Scanner input = new Scanner(System.in);
		String[] d = input.nextLine().split(" ");
		input.close();
		
		// convert from string array to integer array
		// insert a distance of 0 as first element (the distance to the first city)
		int[] n = new int[d.length+1];
		n[0] = 0;
		for (int i = 0; i < d.length; i++)
			n[i+1] = Integer.valueOf(d[i]);
		d = null;
		
		// loop through x and y, create a grid of integers
		// x and y represent the "i"th and "j"th city respectively
		// therefore the final grid will be symmetrical across the center line of zeroes
		// in other words, each row (y) will be symmetrical to that same column (x)
		
		// y axis of grid represents city "i" to check distance to
		for (int y = 0; y < n.length; y++) {
			// x axis of grid represents other city "j" to check against
			for (int x = 0; x < n.length; x++) {
				
				// initial sum of distances is 0
				// if i == j, distance will be 0
				int dist = 0;
				
				// if current city j is further right than city i
				if (x > y)
					// sum distance before city
					for (int s = y+1; s <= x; s++)
						dist += n[s];
				// if current city i is further right than city j
				if (y > x)
					// sum distance after city
					for (int s = x+1; s <= y; s++)
						dist += n[s];
				
				// print the current sum of distances from city
				System.out.print(dist + " ");
			}
			// new line for each row (y)
			System.out.println("");
		}
	}
}