package meeting3;

import java.util.Arrays;

public class IsUnique {
	public static void main(String[] args) {
		System.out.println(isUniqueBad("abc"));
		System.out.println(isUniqueNeutral("abcd"));
		System.out.println(isUniqueGood("abcjdsa"));
	}
	
	public static boolean isUniqueBad(String s) {
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) return false;
			}
		}
		return true;
	}
	
	public static boolean isUniqueNeutral(String s) {
		char[] in = s.toCharArray();
		Arrays.sort(in);
		char prev = in[0];
		for (int i = 1; i < in.length; i++) {
			if (prev == in[i]) return false;
			prev = in[i];
		}
		return true;
	}
	
	public static boolean isUniqueGood(String s) {
		boolean[] table = new boolean[128];
		for (int i = 0; i < s.length(); i++) {
			if (table[s.charAt(i)]) return false;
			table[s.charAt(i)] = true;
		}
		return true;
	}
}
