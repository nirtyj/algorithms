package com.leetcode.easy;

/**
 * Given an array of characters, compress it in-place.
 * <p>
 * The length after compression must always be smaller than or equal to the original array.
 * <p>
 * Every element of the array should be a character (not int) of length 1.
 * <p>
 * After you are done modifying the input array in-place, return the new length of the array.
 * <p>
 * <p>
 * Follow up:
 * Could you solve it using only O(1) extra space?
 * <p>
 * <p>
 * Example 1:
 * Input:
 * ["a","a","b","b","c","c","c"]
 * <p>
 * Output:
 * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * <p>
 * Explanation:
 * "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 * Example 2:
 * Input:
 * ["a"]
 * <p>
 * Output:
 * Return 1, and the first 1 characters of the input array should be: ["a"]
 * <p>
 * Explanation:
 * Nothing is replaced.
 * Example 3:
 * Input:
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * <p>
 * Output:
 * Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 * <p>
 * Explanation:
 * Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
 * Notice each digit has it's own entry in the array.
 */
public class StringCompression {

    /**
     * Leetcode verified
     *
     * @param chars
     * @return
     */
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0)
            return 0;
        else if (chars.length == 1)
            return 1;

        int compareTo = 0;
        int writeIndex = 1;
        int i = 1;
        while (i < chars.length) {
            int rep = 0;
            while (i < chars.length && chars[compareTo] == chars[i]) {
                rep++;
                i++;
            }
            if (rep > 0) {
                rep++;
                String reps = Integer.toString(rep);
                int j = 0;
                while (j < reps.length()) {
                    chars[writeIndex++] = reps.charAt(j++);
                }
            } else {
                compareTo = i;
                i++;
                chars[writeIndex++] = chars[compareTo];
            }
        }
        return writeIndex;
    }
}
