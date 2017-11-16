package meeting5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Sort array of strings ["queen", "apple", queea"] in qwerty
 * @author anast_000
 *
 */
public class QwertySort {
	public static void main(String[] args) {
		String[] sort = {"qween", "apple"};
		System.out.println(Arrays.toString(sort));
		Arrays.sort(sort);
		System.out.println(Arrays.toString(sort));
		Comparator<String> comp = new QwertyComparator(false);
		Arrays.sort(sort, comp);
		System.out.println(Arrays.toString(sort));
		
	}
	
	public static class QwertyComparator implements Comparator<String> {
		String qwerty = "QWERTYUIOPASDFGHJKLZXCVBNM";
		HashMap<Character, Integer> dictionary;
		boolean sensitive;
		
		public QwertyComparator(boolean sensitive) {
			this.sensitive = sensitive;
			dictionary = new HashMap<Character, Integer>();
			for (int i = 0; i < qwerty.length(); i++) {
				dictionary.put(qwerty.charAt(i), i);
			}
			if (sensitive) {
				String lower = qwerty.toLowerCase();
				for (int i = 0; i < lower.length(); i++) {
					dictionary.put(lower.charAt(i), i + qwerty.length());
				}
			}
		}
		
		@Override
		public int compare(String s1, String s2) {
			if (!sensitive) {
				s1 = s1.toUpperCase();
				s2 = s2.toUpperCase();
			}
			for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
				if (dictionary.getOrDefault(s1.charAt(i), (int)s1.charAt(i))
						!= dictionary.getOrDefault(s2.charAt(i), (int)s2.charAt(i))) {
					return dictionary.getOrDefault(s1.charAt(i), (int)s1.charAt(i)) - 
							dictionary.getOrDefault(s2.charAt(i), (int)s2.charAt(i));
				}
			}
			if (s1.length() == s2.length()) return 0;
			return s2.length() - s1.length();
		}
		
	}
}
