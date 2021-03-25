package com.leetcode.easy;

/**
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 *
 *
 *
 * Example 1:
 *
 * Input: num1 = "11", num2 = "123"
 * Output: "134"
 * Example 2:
 *
 * Input: num1 = "456", num2 = "77"
 * Output: "533"
 * Example 3:
 *
 * Input: num1 = "0", num2 = "0"
 * Output: "0"
 *
 *
 * Constraints:
 *
 * 1 <= num1.length, num2.length <= 104
 * num1 and num2 consist of only digits.
 * num1 and num2 don't have any leading zeros except for the zero itself.
 *
 *
 * Follow up: Could you solve it without using any built-in BigInteger library or converting the inputs to integer directly?
 */
public class AddStrings_LC415 {
    public String addStrings(String num1, String num2) {
        int n1L = num1.length();
        int n2L = num2.length();
        if (n1L > n2L) {
            int diff = n1L - n2L;
            for (int i=1;i<= diff; i++) {
                num2 = '0' + num2;
            }
        } else if (n2L > n1L) {
            int diff = n2L - n1L;
            for (int i=1;i<= diff; i++) {
                num1 = '0' + num1;
            }
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i= Math.max(num1.length(), num2.length()) - 1; i >= 0; i--){
            int v1 = num1.charAt(i) - '0';
            int v2 = num2.charAt(i) - '0';
            int v3 = v1 + v2 + carry;
            carry = v3 / 10;
            sb.append(v3 % 10);
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
