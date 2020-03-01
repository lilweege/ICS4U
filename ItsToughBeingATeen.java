import java.util.Scanner;
import java.util.ArrayList;
public class ItsToughBeingATeen {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numTasks = 7;
		// initialize base rules
		// each element is an integer array which will only contain two numbers of chores
		ArrayList<Integer[]> rules = new ArrayList<Integer[]>() {
			{
				// the first number in the pair is the chore you must complete before the second numbered chore in the pair
				// in other words, the second number is the chore you cannot complete before the first chore is finished
				add(new Integer[]{1, 7});
				add(new Integer[]{1, 4});
				add(new Integer[]{2, 1});
				add(new Integer[]{3, 4});
				add(new Integer[]{3, 5});
			}
		};


		// add aditional rules
		while (true) {
			Integer[] rule = new Integer[]{in.nextInt(), in.nextInt()};
			if (rule[0] == 0 && rule[1] == 0) {
				break;
			}
			rules.add(rule);
		}


		// start with no chores completed
		String completed = "";
		while (true) {
			// assume all chores can be completed
			ArrayList<Integer> canDo = new ArrayList<Integer>() {
				{
					for (int i = 1; i <= numTasks; i++) {
						add(i);
					}
				}
			};

			// remove already completed chores
			for (char c : completed.toCharArray()) {
				canDo.remove(Integer.valueOf(Character.toString(c)));
			}

			// remove a chore if a chore must be completed before it
			for (Integer[] rule : rules) {
				canDo.removeIf(r -> r == rule[1]);
			}

			// if there are any chores remaining that we can complete
			if (canDo.size() > 0) {
				// take the first chore
				int next = canDo.get(0);

				// complete the chore
				completed += String.valueOf(next);

				// change the rules so that we can complete any chore after it
				for (Integer[] rule : rules) {
					if (rule[0] == next) {
						rule[0] = rule[1];
						rule[1] = 0;
					}
				}
			}
			// if we cannot complete any more chores, do not continue
			else {
				break;
			}
		}



		// if we completed all the chores
		if (completed.length() >= numTasks) {
			for (char c : completed.toCharArray()) {
				System.out.print(c + " ");
			}
		}
		// if we cannot complete all the chores
		else {
			System.out.print("Cannot complete these tasks. Going to bed.");
		}
	}
}
