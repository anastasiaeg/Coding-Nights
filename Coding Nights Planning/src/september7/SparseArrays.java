package september7;

import java.util.HashMap;
import java.util.Scanner;

/**
 * From https://www.hackerrank.com/challenges/sparse-arrays/problem
 * @author anast_000
 *
 */
public class SparseArrays {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        
        HashMap<String, Integer> hmap = new HashMap<String, Integer>();
        int number = s.nextInt();
        s.nextLine();
        for (int i = 0; i < number; i++) {
            String thing = s.nextLine();
            hmap.put(thing, hmap.getOrDefault(thing, 0) + 1);
        }
        number = s.nextInt();
        s.nextLine();
        for (int i = 0; i < number; i++) {
            String thing = s.nextLine();
            System.out.println(hmap.getOrDefault(thing, 0));
        }
	}
}
