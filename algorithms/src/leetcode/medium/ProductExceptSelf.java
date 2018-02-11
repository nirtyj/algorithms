package leetcode.medium;

/**
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
*/
public class ProductExceptSelf {

	/**
	 * Leetcode verified
	 * @param nums
	 * @return
	 */
	public static int[] productExceptSelf(int[] nums) {
	    int[] result = new int[nums.length];	 
	    int[] t1 = new int[nums.length];
	    int[] t2 = new int[nums.length];
	    //Input - 1, 2, 3, 4
  
	    //scan from left to right; product of numbers before itself
	    t1[0]=1; // initialize the val to 1 for index 0 as no numbers before index 0
	    for(int i=0; i<nums.length-1; i++){
	        t1[i+1] = nums[i] * t1[i];
	    }
	    // 1, 1, 2, 6
	    
	    //scan from right to left; product of numbers after itself
	    t2[nums.length-1]=1; // initialize the val to 1 for last index as no numbers after last index
	    for(int i=nums.length-1; i>0; i--){
	        t2[i-1] = t2[i] * nums[i];
	    }
	    // 24, 12, 4, 1
	 
	    //multiply the prodcut of numbers before itself and product of numbers after itself
	    for(int i=0; i<nums.length; i++){
	        result[i] = t1[i] * t2[i];
	    }
	    // 24, 12, 8, 6
	    return result;
	}
}
