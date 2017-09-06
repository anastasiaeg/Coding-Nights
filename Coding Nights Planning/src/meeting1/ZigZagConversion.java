package meeting1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Coding Nights - Problem #4 Solution
 * @author sriyamadapusivasudevan
 *
 */
public class ZigZagConversion {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			/* The string to be zig-zagged */
			String text = br.readLine();
			
			/* Number of rows is always going to be odd */
			int noRows = Integer.parseInt(br.readLine());
		    
			/*
			 * In order to represent the zig-zagged form of the
			 * word in a matrix, we need to find the number of
			 * columns required.
			 * 
			 * Logic: 
			 * Split the text into sections of rows and rows - 2 until
			 * a flag that keeps track becomes less than number of rows.
			 * [rows|rows - 2|rows|rows-2 ...] 
			 * 
			 */
			while(text != null) {
		    	String[] input = text.split("");
				int len = text.length();
				int noCols = 0;
				while(len > noRows) {
					len = len - noRows;
					noCols ++;
					len = len - (noRows-2);
					if(len < 0) {
						break;
					}
					noCols+=(noRows-2);
				}
				noCols++;
				String[][] mock = new String[noRows][noCols];
				int k = 0;
				
				/*
				 * Creating the zig-zag representation of the given text.
				 * 
				 * Logic:
				 * If the column iterating variable is a multiple of (noRows - 1),
				 * then fill the matrix with the input[k] (vertically down). If
				 * (i + j) is a multiple of (noRows - 1), then fill matrix with
				 * input[k] (diagonal) and if anything else, leave it blank.
				 */
				for(int j = 0; j < noCols && k < text.length(); j++) {
					for(int i = 0; i < noRows && k < text.length(); i++) {
						if(j % (noRows-1) == 0) {
							mock[i][j] = input[k];
							k++;
						} else if((i+j) % (noRows-1) == 0) {
							mock[i][j] = input[k];
							k++;
						} else {
							mock[i][j] = "";
						}
					}
				}
				
				/*
				 * Print the matrix going row first
				 */
				for(int i = 0; i < noRows; i++) {
					for(int j = 0; j < noCols; j++) {
						if(mock[i][j] != null) {
							System.out.print(mock[i][j]);
						}
					}
				}
				System.out.println();
				
				/* Accept more input from the user if need be */
				text = br.readLine();
				noRows = Integer.parseInt(br.readLine());
		    }
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
