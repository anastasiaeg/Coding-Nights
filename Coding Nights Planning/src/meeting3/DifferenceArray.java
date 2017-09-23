package meeting3;

import java.util.Hashtable;

public class DifferenceArray {
	public static void main(String[] args) {
		int k = 2;
		int[] array = {1, 7, 5, 9, 2, 12, 3};
		
		System.out.println("Easy O(n^2): " + easy(k, array));
		System.out.println("Hard O(n): " + hard(k, array));
	}
	
	public static int easy(int k, int[] array) {
		int output = 0;
		for (int i = 0; i < array.length; i++) {
			int current = array[i];
			for (int j = i + 1; j < array.length; j++) {
				if (current + k == array[j] || current - k == array[j]) {
					output++;
				}
			}
		}
		return output;
	}
	
	public static int hard(int k, int[] array) {
		int output = 0;
		Hashtable<Integer, Boolean> hash = new Hashtable<Integer, Boolean>();
		for (int i = 0; i < array.length; i++) {
			hash.put(array[i], true);
		}
		for (int i = 0; i < array.length; i++) {
			if (hash.getOrDefault(array[i] - 2, false)) output++;
		}
		return output;
	}
	
}
