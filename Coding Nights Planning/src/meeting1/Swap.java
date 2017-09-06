package meeting1;

import java.util.Scanner;

public class Swap {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNextLine()) {
			String number = s.nextLine();
			int max = Integer.MIN_VALUE, first = 0, second = 0;
			boolean swapped = false;
			
			while (!swapped) {
				for (int i = second; i < number.length(); i++) {
					int current = Integer.parseInt("" + number.charAt(i));
					if (current > max) {
						max = current;
						first = i;
					} else if (current > max) {
						first = i;
					}
				}
				if (second == number.length() - 1 || second != first) {
					swapped = true;
				} else {
					second++;
					max = Integer.MIN_VALUE;
				}
			}
			
			for (int i = 0; i < number.length(); i++) {
				System.out.print(i == first?number.charAt(second):(i == second?number.charAt(first):number.charAt(i)));
			}
			System.out.println(first == second?"\nDidn't swap anything":"\nSwapped " + (first + 1) + " and " + (second + 1));
		}
		s.close();
	}
}
