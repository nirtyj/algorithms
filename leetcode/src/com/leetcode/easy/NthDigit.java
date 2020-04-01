package com.leetcode.easy;

/**
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * <p>
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 3
 * <p>
 * Output:
 * 3
 * Example 2:
 * <p>
 * Input:
 * 11
 * <p>
 * Output:
 * 0
 * <p>
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 */
public class NthDigit {

    /**
     * 1 - 			9  : 9 * 1
     * 10 -	   	    99 : 90 * 2
     * 100 -      999 : 900 * 3
     * 1000 -    9999 : 9000 * 4
     * Leetcode verified
     *
     * @param n
     * @return
     */
    public static int findNthDigit(int n) {
        int length = 1; // 1, 2, 3, 4
        long possibilities = 9; // 9, 90, 900, 9000
        int start = 1; // 1, 10, 1000

        // finds the length .. reduce the number also by length * possibilties(range)
        while (n > length * possibilities) {
            n -= length * possibilities;
            length += 1;
            possibilities *= 10;
            start *= 10;
        }

        start = start + (n - 1) / length; // finding the actual number from start.. (n-1)/length gives you number from start
        String s = Integer.toString(start);
        // index of the digit in the number
        // n-1/length = number
        // n-1%length = digit
        return Character.getNumericValue(s.charAt((n - 1) % length));
    }

    /**
     * Memory limit exceeded
     *
     * @param n
     * @return
     */
    public int findNthDigitMLE(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; sb.length() < n; i++) {
            sb.append(i);
        }
        return Integer.parseInt(sb.toString().substring(n - 1, n));
    }
}
