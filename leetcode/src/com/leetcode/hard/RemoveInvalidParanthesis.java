package com.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * <p>
 * Note: The input string may contain letters other than the parentheses ( and ).
 * <p>
 * Examples:
 * "()())()" -> ["()()()", "(())()"]
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * ")(" -> [""]
 */
public class RemoveInvalidParanthesis {

    Set<String> result = new HashSet<String>();
    int max = 0;

    /**
     * Leetcode verified
     *
     * @param s
     * @return
     */
    public List<String> removeInvalidParentheses(String s) {
        if (s == null)
            return Collections.emptyList();
        dfsHelper(s, "", 0, 0);
        List<String> res = new ArrayList<>(result);
        if (res.isEmpty()) {
            res.add("");
        }
        return res;
    }

    private void dfsHelper(String left, String right, int leftCounter, int maxCurrent) {
        // ending condition
        if (left.isEmpty()) {
            // count left == 0 means.. it is a valid parathesis condition
            if (!right.isEmpty() && leftCounter == 0 && maxCurrent >= max && !result.contains(right)) {
                max = maxCurrent;
                result.add(right);
            }
            return;
        }

        char c = left.charAt(0);

        // opening
        if (c == '(') {
            // keep ( subtree
            dfsHelper(left.substring(1), right + "(", leftCounter + 1, maxCurrent + 1);
            // drop ( subtree
            dfsHelper(left.substring(1), right, leftCounter, maxCurrent);
        }
        // closing
        else if (c == ')') {
            // if there is any left braces in stack, decrement one, subtree keeping it only if the leftCounter is > 0
            if (leftCounter > 0) {
                dfsHelper(left.substring(1), right + ")", leftCounter - 1, maxCurrent);
            }
            // subtree with not keeping it
            dfsHelper(left.substring(1), right, leftCounter, maxCurrent);
        } else {
            // other character -> add it to right
            dfsHelper(left.substring(1), right + left.charAt(0), leftCounter, maxCurrent);
        }
    }
}
