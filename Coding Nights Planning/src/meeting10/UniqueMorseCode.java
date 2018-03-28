package meeting10;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueMorseCode {
	static HashMap<Character, String> dictionary;
	static String[] thing = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
	static {
		dictionary = new HashMap<Character, String>();
		char alphabet = 'A';
		for (int i = 0; i < thing.length; i++) {
			dictionary.put(alphabet, thing[i]);
			dictionary.put((char)((int)alphabet + 32), thing[i]);
			alphabet = (char)((int)alphabet + 1);
		}
	}
	
	public static void main(String[] args) {
		String[] words = {"gin", "zen", "gig", "msg"};
		System.out.println("Number of unique morse combinations: " + uniqueMorse(words));
	}
	
	public static int uniqueMorse(String[] input) {
		HashSet<String> hs = new HashSet<String>();
		
		for (int i = 0; i < input.length; i++) {
			String current = "";
			for (int j = 0; j < input[i].length(); j++) {
				current += dictionary.get(input[i].charAt(j));
			}
			hs.add(current);
		}
		return hs.size();
	}
}
