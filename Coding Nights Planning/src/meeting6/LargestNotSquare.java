package meeting6;

import java.util.Arrays;

public class LargestNotSquare {
	public static void main(String[] args) {
		int[] array = {36, 0, 16, 4, 7, 15, 20};
		System.out.println("Largest not perfect square number in an array " + Arrays.toString(array) + " is " + largestNotSquare(array));
	}
	
	public static int largestNotSquare(int[] array) {
		int max = Integer.MIN_VALUE;
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] > max) {
				double sqr = Math.sqrt(array[i]);
				if (sqr != Math.floor(sqr)) {
					return array[i];
				}
			}
		}
		return max;
	}
}
