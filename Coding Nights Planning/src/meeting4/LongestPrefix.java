package meeting4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestPrefix {

	/**
	 * Horizontal scanning of the string array
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix(String[] strs) {
	    if (strs.length == 0) {
	    		return "";
	    }
	    String prefix = strs[0];
	    for (int i = 1; i < strs.length; i++)
	        while (strs[i].indexOf(prefix) != 0) {
	            prefix = prefix.substring(0, prefix.length() - 1);
	            if (prefix.isEmpty()) {
	            		return "";
	            }
	        }        
	    return prefix;
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = "";
			do {
				line = br.readLine();
				String[] strArr = line.split(" ");
				
				if(strArr.length == 1) {
					System.out.println("Invalid input. Format:[string] [string]");
				} else {
					String returned = longestCommonPrefix(strArr);
					if(returned.equals("")) {
						System.out.println("No common prefix was found");

					} else {
						System.out.println("The common longest prefix is: " + returned);
					}
				}
			} while (line != null);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
