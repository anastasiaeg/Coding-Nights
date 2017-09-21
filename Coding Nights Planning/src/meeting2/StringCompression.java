package meeting2;

import java.util.Scanner;

public class StringCompression {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String word = s.nextLine();
		int max = 1;
		char prev = '\0';
		for (int i = 0; i < word.length(); i++) {
			if (prev == '\0' || prev != word.charAt(i)) {
				System.out.print(max != 1?max + "" + word.charAt(i):word.charAt(i));
				max = 1;
				prev = word.charAt(i);
			} else if (word.charAt(i) == prev) {
				max++;
			}
		}
		if (max != 1) System.out.print(max);
		s.close();
	}
}
