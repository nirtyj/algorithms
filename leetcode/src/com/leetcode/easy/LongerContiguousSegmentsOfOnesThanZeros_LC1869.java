package com.leetcode.easy;

public class LongerContiguousSegmentsOfOnesThanZeros_LC1869 {

    /**
     * @param s
     * @return
     */
    public boolean checkZeroOnes(String s) {
        int ones = 0;
        int zeros = 0;
        int tempOnes = 0;
        int tempZeros = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                tempOnes++;
                tempZeros = 0;
            } else {
                tempZeros++;
                tempOnes = 0;
            }
            zeros = Math.max(zeros, tempZeros);
            ones = Math.max(ones, tempOnes);
        }
        return (ones > zeros ? true : false);
    }
}
