package meeting8;

import java.util.Random;
import java.util.Scanner;

public class MiniMaxSum {
	
	static void miniMaxSum(int[] arr) {
        // initialize min and max to first 4 numbers. If we find a sum smaller or greater than min/max, update
        long max = (long)arr[0] + arr[1] + arr[2] + arr[3];
        long min = (long)arr[0] + arr[1] + arr[2] + arr[3];
        long sum;
        
        // loop to pick starting index
        for (int i = 0; i < arr.length; i++){
            
            sum = 0;
            
            for (int j = i; j < i + 4; j++){
                sum += (long)(arr[j % (arr.length)]);
            }
            
            if (sum >= max){
                max = sum;
            }
            
            if (sum <= min){
                min = sum;
            }
        }
        
        System.out.println(min + " " + max);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[] {1, 2, 3, 4, 5};
        miniMaxSum(arr);
        in.close();
    }      
}
	