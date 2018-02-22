package meeting9;

import java.util.Arrays;
import java.util.HashMap;

public class InNewOrder {
	public static void main(String[] args) {
		char[] newOrder = {'q','w', 'e','r', 't', 'y'};
		String[] stuffs = {"qwerty", "Qwerty", "qry", "yet"};
		System.out.println(Arrays.toString(inOrder(newOrder, stuffs)));
	}
	
	public static Boolean[] inOrder(char[] newOrder, String[] check) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for (int i = 0; i < newOrder.length; i++) {
			hm.put(newOrder[i], i);
		}
		Boolean[] output = new Boolean[check.length];
		for (int i = 0; i < check.length; i++) {
			int past = -1;
			boolean changed = false;
			for (int j = 0; j < check[i].length(); j++) {
				if (!hm.containsKey(check[i].charAt(j))) {
					changed = true;
					break;
				}
				int curr = hm.get(check[i].charAt(j));
				if (past < curr) {
					past = curr;
				} else {
					changed = true;
					break;
				}
			}
			output[i] = !changed;
			
		}
		return output;
	}
}
