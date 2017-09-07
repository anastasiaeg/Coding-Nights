package meeting1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Series problem
 * @author sriyamadapusivasudevan
 *
 */
public class Series {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		try {
			n = Integer.parseInt(br.readLine());
			while(n != -1) {
				double numerator = Math.pow(n, 2) + n + 1;
				double denominator = Math.pow(n, 2) + 4;
				System.out.println(numerator/denominator);
				n = Integer.parseInt(br.readLine());
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}