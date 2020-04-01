package com.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay), or
 * it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example: 19 is a happy number
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class HappyNumber {

    HashSet<Integer> seen = new HashSet<>();

    /**
     * Leetcode verified
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        if (seen.contains(n))
            return false;

        seen.add(n);
        List<Integer> nos = new ArrayList<>();
        while (n >= 1) {
            int digit = n % 10;
            nos.add(digit);
            n = n / 10;
        }

        int sum = 0;
        for (Integer i : nos) {
            sum = sum + i * i;
        }
        if (sum == 1)
            return true;
        else
            return isHappy(sum);
    }
}
