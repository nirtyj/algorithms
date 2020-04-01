package com.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParenthesis {

    public static List<String> generateBalancedParentheses(int numPairs) {
        List<String> result = new ArrayList<>();
        directedGenerateBalancedParentheses("", numPairs, numPairs, result);
        return result;
    }

    private static void directedGenerateBalancedParentheses(String inputString, int numLeftParensNeeded,
                                                            int numRightParensNeeded, List<String> result) {
        // base case, both are 0, add the result
        if (numLeftParensNeeded == 0 && numRightParensNeeded == 0) {
            result.add(inputString);
            return;
        }

        // two subtrees - one with opening and one with closing. closing is always done when its num of left is already generated
        // if both are greater than or equal to 1, insert (
        if (numLeftParensNeeded >= 1 && numRightParensNeeded >= 1) {
            directedGenerateBalancedParentheses(inputString + "(", numLeftParensNeeded - 1, numRightParensNeeded,
                    result);
        }

        // insert the ) when the left is less than right
        if (numLeftParensNeeded < numRightParensNeeded) {
            directedGenerateBalancedParentheses(inputString + ")", numLeftParensNeeded, numRightParensNeeded - 1,
                    result);
        }
    }
}
