package meeting7;

public class RotateArray {
	
	public static void main(String[] args) {
			// test input
			int[] test = new int[] {1,2,3,4,5,6,7};
			int[] result = rotate(test, 3);
			
			for (int i = 0; i < result.length; i++) {
	        	System.out.print(result[i] + " ");
	        }	
	}
	
	public static int[] rotate(int[] nums, int k) {
        
        // make a temporary array to store shifted nums
        int[] temp = new int[nums.length];
        int newIdx = 0;
        for (int i=0; i < nums.length; i++) {
        	// find new index -- take the amount shifted and wrap around if reach final index
        	newIdx = (i + k)%(nums.length);
        	// set the value of the new index of the temp array to the current value in nums[]
        	temp[newIdx] = nums[i];
        }
        // copy temp array into nums[] to replace it
        for (int i = 0; i < nums.length; i++) {
        	nums[i] = temp[i];
        }
        
        return nums;
    }
	
	//Go here for other solutions: https://leetcode.com/problems/rotate-array/solution/
}
