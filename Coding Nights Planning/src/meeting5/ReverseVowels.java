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
public class ReverseVowels {

	public static String revVowels(String[] input) {
		String vowels = "";
		String revVowels = "";
		for(int i = 0; i < input.length; i++) {
	        if(input[i].equalsIgnoreCase("a") || input[i].equalsIgnoreCase("e")
	        		|| input[i].equalsIgnoreCase("i") || input[i].equalsIgnoreCase("o")
	        		|| input[i].equalsIgnoreCase("u")) {
	        		vowels += input[i];
	        }
		}
		
		for(int k = vowels.length() - 1; k >= 0; k--) {
			revVowels += vowels.charAt(k) + "";
		}
		
		
		return revVowels;
	}
	
	public static String findOutput(String inputStr, String vowelStr) {
		String[] input = inputStr.split("");
		String[] vowels = vowelStr.split("");
		int k = 0;
		String output = "";
		for(int i = 0; i < input.length; i++) {
	        if(input[i].equalsIgnoreCase("a") || input[i].equalsIgnoreCase("e")
	        		|| input[i].equalsIgnoreCase("i") || input[i].equalsIgnoreCase("o")
	        		|| input[i].equalsIgnoreCase("u")) {
	        		
	        		output += vowels[k];
	        		k++;
	        } else {
	        		output += input[i];
	        }
		}
		
		
		return output;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = "";
			do {
				line = br.readLine();
				String[] strArr = line.split("");
				
				String vowels = revVowels(strArr);
				String revVowels = findOutput(line, vowels);

				if(revVowels.equals("")) {
					System.out.println("Please enter a string with 1 or more characters");

				} else {
					System.out.println("The reversed output is: " + revVowels);
				}
				
			} while (line != null);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


}
