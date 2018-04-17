package com.leetcode.add_mult_pow;

/**
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/
public class MultiplyTwoNums {

	/**
	 * Leetcode verified
	 * @param num1
	 * @param num2
	 * @return
	 */
	 public static String multiply(String num1, String num2) {
	        int len1 = num1.length();
	        int len2 = num2.length();
	        int len = len1 + len2;
	        int[] mul = new int[len];
	        for (int i = len1 - 1; i >= 0; i--) {  	
	            int a = num1.charAt(i) - '0';
	            
	            // start of end - offset one for every top loop
	            int k = len2 + i;
	            
	            for (int j = len2 - 1; j >= 0; j--) {
	                int b = num2.charAt(j) - '0';
	                int c = mul[k] + a * b;
	                
	                // mod is put in current index
	                mul[k] = c % 10;
	                
	                // carry is put in previous index
	                mul[k - 1] = mul[k - 1] + c /10;
	                
	                // reduce the index for next iteration
	                k--;
	            }
	        }
	        int i = 0;
	        // ignore all the zeros in the beginning
	        while(mul[i] == 0 && i < len - 1) 
	        		i++;
	        
	        // convert to string
	        StringBuilder sb = new StringBuilder();
	        for (; i < len; i++)
	            sb.append(mul[i]);
	        return sb.length() == 0 ? "0" : sb.toString();
	    }
}
