package meeting8;

import java.util.ArrayList;
import java.util.List;

/**
 * Print out all of the self dividing numbers in a given range. 
 * Self dividing numbers is a number that is divisible by every digit it contains. 
 * @author anast_000
 *
 */
public class SelfDividingNumbers {
	public static void main(String[] args) {
		//[1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22] 
		System.out.println(selfDividingNumbers(1, 22));
	}
	
	public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> l = new ArrayList<Integer>();
        for (int i = left; i <= right; i++) {
            int thing = i;
            for (; thing > 0; thing /= 10) {
	            if (thing % 10 == 0 || i % (thing % 10) != 0) {
	                break;
	            }
            }
            if (thing == 0) l.add(i);
        }
        return l;
    }
}
