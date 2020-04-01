package com.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * <p>
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 * <p>
 * For example,
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 */
public class TwoSumIII {

    /**
     * Memory limit exceeded
     */
    HashSet<Integer> sum;
    HashSet<Integer> key;
    /**
     * Leetcode verified
     */
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    /**
     * Initialize your data structure here.
     */
    public TwoSumIII() {
        key = new HashSet<Integer>();
        sum = new HashSet<Integer>();
    }

    // Add the number to an internal data structure.
    public void add(int number) {
        if (map.containsKey(number))
            map.put(number, map.get(number) + 1);
        else {
            map.put(number, 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num1 = entry.getKey();
            int num2 = value - num1;
            if ((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2)))
                return true;
        }
        return false;
    }

    /**
     * Add the number to an internal data structure..
     */
    public void addSlower(int number) {
        for (Integer k : key) {
            sum.add(k + number);
        }
        key.add(number);
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean findSlower(int value) {
        return sum.contains(value);
    }
}
