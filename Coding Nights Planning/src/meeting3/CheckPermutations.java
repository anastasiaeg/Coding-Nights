package meeting3;

import java.util.Hashtable;

public class CheckPermutations {
	public static void main(String[] args) {
		System.out.println("Is 103s5 a permutation of 1234560s789? " + permutation("103s5", "1234560s789"));
	}

	public static boolean permutation(String is, String of) {
		Hashtable<Character, Boolean> ht = new Hashtable<Character, Boolean>();
		for (int i = 0; i < of.length(); i++) {
			ht.put(of.charAt(i), true);
		}
		for (int i = 0; i < is.length(); i++) {
			if (!ht.getOrDefault(is.charAt(i), false)) {
				return false;
			}
		}
		return true;
	}
}
