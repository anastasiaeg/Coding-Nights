package meeting9;

import java.util.Arrays;

public class SmallestLetterGreaterThanTarget {
	public static void main(String[] args) {
		char[] letters = {'c', 'j', 'f'};
		System.out.println(Arrays.toString(letters) + " and target 'a', smallest = " + smallest(letters, 'a'));
	}
	
	public static char smallest(char[] letters, char target) {
		Arrays.sort(letters);
        char smallest = letters[0];
        for (int i = 0; i < letters.length; i++) {
            if (target < letters[i]) {
                smallest = letters[i];
                break;
            }
        }
        return smallest;
	}
}
