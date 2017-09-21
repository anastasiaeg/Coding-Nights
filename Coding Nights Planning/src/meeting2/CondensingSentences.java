package meeting2;

import java.util.Scanner;

public class CondensingSentences {
	public static void main(String[] args) {
		Scanner s0 = new Scanner(System.in);
		Scanner s = new Scanner(s0.nextLine());
		s0.close();
		String one = s.next(), two = "";
		
		while (s.hasNext()) {
			two = s.next();
			String out = linkedStrings(one, two);
			if (out == null) {
				System.out.print(one + " ");
				one = two;
			} else {
				one = out;
			}
		}
		System.out.print(one);
		s.close();
	}
	
	public static String linkedStrings(String one, String two) {
		for (int i = 0; i < one.length(); i++) {
			if (one.charAt(i) == two.charAt(0)) {
				String out = one.substring(0, i) + two;
				if (out.length() >= one.length() && out.substring(0, one.length()).equals(one)) {
					return out;
				}
			}
		}
		return null;
	}
}
