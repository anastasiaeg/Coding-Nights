package meeting3;

import java.util.Arrays;

public class Wigglesort {
	public static void main(String[] args) {
		int[] thing = {1, 8, 3, 7,3, 1};
		thing = wiggle(thing);
		for (int i = 0; i < thing.length; i++) {
			System.out.println(thing[i]);
		}
	}
	
	public static int[] wiggle(int[] thing) {
		Arrays.sort(thing);
		int[] one = new int[thing.length / 2], 
				two = new int[thing.length / 2 + (thing.length % 2 != 0 ? 1 : 0)];
		int sizeO = 0, sizeT = 0;
		for (int i = 0; i < thing.length; i++) {
			if (i < thing.length / 2) {
				one[sizeO++] = thing[i];
			} else {
				two[sizeT++] = thing[i];
			}
		}
		int[] output = new int[thing.length];
		int sizeOut = 0;
		for (int i = 0; i < thing.length / 2; i++) {
			output[sizeOut++] = one[i];
			output[sizeOut++] = two[thing.length / 2 - i - 1];
		}
		return output;
	}
}
