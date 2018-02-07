package meeting7;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Find the median of random integers array
 * @author anast_000
 *
 */
public class Median {
	public static void main(String[] args) {
		int[] randomInts = new int[(int)(Math.random() * 100)];
		for (int i = 0; i < randomInts.length; i++) {
			randomInts[i] = (int)(Math.random()*10000);
		}
		fromDataStream();
		int[] check = {0, 5, 8, 9, -2};
		System.out.println("Median of array " + Arrays.toString(check) + "\nis " + medianEasy(check));
		System.out.println("Median of array " + Arrays.toString(randomInts) + "\nis " + medianHard(randomInts));
	}
	
	/**
	 * O(nlogn) because of sorting
	 * @param array
	 * @return
	 */
	public static double medianEasy(int[] array) {
		//Precautions
		if (array == null) return 0;
		if (array.length == 0) return 0;
		Arrays.sort(array);
		return array.length % 2 == 0? (double)(array[array.length / 2] + array[array.length / 2 - 1]) / 2: array[array.length / 2];
	}
	
	/**
	 * O(n)!! but worse memory wise because we're creating two priority queues
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
	
	/**
	 * Challenge run! 
	 * @return
	 */
	public static void fromDataStream() {
	    Scanner scanner = new Scanner( System.in );

	    PriorityQueue<Integer> min = new PriorityQueue<Integer>((a,b)-> b - a);
		PriorityQueue<Integer> max = new PriorityQueue<Integer>();
	    System.out.print( "Type in an integer, if you want to exit, type any character: " );
	    
    	while (scanner.hasNextInt()) {
    		int thing = scanner.nextInt();
    		if (max.size() == 0) {
    			max.add(thing);
    			System.out.println("Median is " + thing);
    		} else {
    			if (thing < max.peek()) {
    				min.add(thing);
    				while (min.size() > max.size()) {
    					max.add(min.poll());
    				}
    			} else {
    				max.add(thing);
    				while (max.size() > min.size()) {
    					min.add(max.poll());
    				}
    			}
    		}
    		
            System.out.println("Max: " + Arrays.toString(max.toArray()));
            System.out.println("Min: " + Arrays.toString(min.toArray()));
            System.out.println("Median is " + (max.size() > min.size()?max.peek(): (max.peek() + min.peek()) / 2.0));
    	}

    	scanner.close();
	}
}
