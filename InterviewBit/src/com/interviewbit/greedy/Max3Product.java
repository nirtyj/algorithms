package com.interviewbit.greedy;

import java.util.ArrayList;
import java.util.Collections;

/**
Highest Product
Given an array of integers, return the highest product possible by multiplying 3 numbers from the array

Input:
array of integers e.g {1, 2, 3}
 NOTE: Solution will fit in a 32-bit signed integer 
Example:

[0, -1, 3, 100, 70, 50]

=> 70*50*100 = 350000

 NOTE: You only need to implement the given function. Do not read input, instead use the arguments to the function. Do not print the output, instead return values as specified. Still have a doubt? Checkout Sample Codes for more details. 
*/
public class Max3Product {
	
	/**
	 * Verified
	 * @param A
	 * @return
	 */
	public int maxp3(ArrayList<Integer> A) {
		Collections.sort(A);
		return Math.max(A.get(0) * A.get(1) * A.get(A.size() - 1),
				A.get(A.size() - 1) * A.get(A.size() - 2) * A.get(A.size() - 3));
	}
}
