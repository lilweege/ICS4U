import java.util.Scanner;
public class NotReplace {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println(notReplace(input.nextLine()));
		input.close();
	}

	private static String notReplace(String s) {
		String out = "";
		String[] n = s.split(" ");
		for (int i = 0; i < n.length; i++) {
			if (n[i].equals("is")) {
				out += "is not ";
			}
			else if (n[i].contains("-")) {
				String[] d = n[i].split("-");
				for (int j = 0; j < d.length; j++) {
					if (d[j].equals("is")) {
						out += "is not";
						if (j == d.length-1) {
							out += " ";
						}
						else {
							out += "-";
						}
					}
				}
			}
			else {
				out += n[i] + " ";
			}
		}
		
		return out;
	}
}
