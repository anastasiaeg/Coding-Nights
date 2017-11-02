package meeting4;

import java.util.HashSet;

public class Sum2 {
	public static void main(String[] args) {
		int[] array = {0, 4, 7, 2, 5};
		System.out.println(sumTwo(array, 9));
	}
	
	/**
	 * Return true if two of the numbers in an array would sum up to "sum"
	 * @param array
	 * @param sum
	 * @return
	 */
	public static boolean sumTwo(int[] array, int sum) {
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int x : array) {
			if (hs.contains(sum - x)) return true;
			hs.add(x);
		}
		return false;
	}

	/**
	 * Return true if two of the numbers in an array would sum up to "sum"
	 * @param array
	 * @param sum
	 * @return
	 */
	public static boolean sumTwoEasy(int[] array, int sum) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] + array[j] == sum) return true;
			}
		}
		return false;
	}
}
