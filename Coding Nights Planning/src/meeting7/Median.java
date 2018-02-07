package meeting7;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Median {
	public static void main(String[] args) {
		int[] randomInts = new int[500];
		for (int i = 0; i < 500; i++) {
			randomInts[i] = (int)(Math.random()*10000);
		}
		
		int[] check = {0, 5, 8, 9, -2};
		System.out.println("Median of this array is " + medianHard(check));
	}
	
	/**
	 * O(nlogn) because of sorting
	 * @param array
	 * @return
	 */
	public static double medianEasy(int[] array) {
		Arrays.sort(array);
		return array.length % 2 == 0? (double)(array[array.length / 2] + array[array.length / 2 - 1]) / 2: array[array.length / 2];
	}
	
	/**
	 * O(n)!!
	 */
	public static double medianHard(int[] array) {
		//Precautions
		if (array == null) return 0;
		if (array.length == 0) return 0;
		//Create two priority queues for minimum and maximum
		PriorityQueue<Integer> min = new PriorityQueue<Integer>();
		PriorityQueue<Integer> max = new PriorityQueue<Integer>((a,b)-> b - a); // this is a lambda expression for reversing the comparison method! 
		
		for (int i = 0; i < array.length; i++) {
			min.add(array[i]);
			max.add(array[i]);
		}
		while (min.peek() < max.peek()) {
			min.poll();
			max.poll();
		}
		return (double)(min.poll() + max.poll()) / 2;
	}
}
