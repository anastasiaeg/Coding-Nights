/**
 * 
 */
package meeting5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author sriyamadapusivasudevan
 *
 */
public class Palindrome {

	/**
	 *  Returns true if palindrome, false if not.
	 * @param s - input string
	 * @param i - start index
	 * @param j - end index
	 * @return true if palindrome or not
	 */
    public static boolean isPalindromeRange(String s, int i, int j) {
        for (int k = i; k <= i + (j - i) / 2; k++) {
            if (s.charAt(k) != s.charAt(j - k + i)) {
            		return false;
            }
        }
        return true;
    }
    
    /**
     * Returns true if its a palindrome after removing one letter
     * @param s
     * @return
     */
    public static boolean validPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                int j = s.length() - 1 - i;
                return (isPalindromeRange(s, i+1, j) ||
                        isPalindromeRange(s, i, j-1));
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = "";
			do {
				System.out.println("Enter a string: ");
				line = br.readLine();
				line = line.trim();
				if(line.length() == 0) {
					System.out.println("Please enter a string with more than one character");
				} else {
					Boolean returned = validPalindrome(line);
					if(returned == true) {
						System.out.println("True");

					} else {
						System.out.println("False");
					}
				}
			} while (line != null);

		} catch (IOException e) {
			System.out.println("Bad format");
		} catch (NumberFormatException e) {
			System.out.println("Bad format");
		}
		
	}
}
