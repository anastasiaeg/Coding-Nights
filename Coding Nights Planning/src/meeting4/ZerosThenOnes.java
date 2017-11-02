package meeting4;

import java.util.Arrays;

public class ZerosThenOnes {
	public static void main(String[] args) {
		int[] array = {0,1,0,1,1,1,0,1,1,1};
		System.out.println(Arrays.toString(zerosFirst(array)));
	}
	
	/**
	 * What sort an array of random ones and zeros so that all the zeros are on the left and all the ones are on the right. 
	 * @param array
	 * @return
	 */
	public static int[] zerosFirst(int[] array) {
		int[] output = new int[array.length];
		int ones = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 1) ones++;
		}
		for (int i = array.length - 1; i > array.length - 1 - ones; i--) {
			output[i] = 1;
		}
		return output;
	}
}
