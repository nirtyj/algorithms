package com.leetcode.linesweep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.
 *
 * The population of some year x is the number of people alive during that year. The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1]. Note that the person is not counted in the year that they die.
 *
 * Return the earliest year with the maximum population.
 *
 *
 *
 * Example 1:
 *
 * Input: logs = [[1993,1999],[2000,2010]]
 * Output: 1993
 * Explanation: The maximum population is 1, and 1993 is the earliest year with this population.
 * Example 2:
 *
 * Input: logs = [[1950,1961],[1960,1971],[1970,1981]]
 * Output: 1960
 * Explanation:
 * The maximum population is 2, and it had happened in years 1960 and 1970.
 * The earlier year between them is 1960.
 */
public class MaximumPopulationYear_LC1854 {

    /**
     *  for each birth year put + 1
     *  for each death yar put -1.
     *  sort and then keep adding. if it exceeds, previous max, update the result
     * @param logs
     * @return
     */
    public int maximumPopulation(int[][] logs) {
        ArrayList<Integer[]> list = new ArrayList<>();
        for (int[] log : logs) {
            list.add(new Integer[]{log[0], 1});
            list.add(new Integer[]{log[1], -1});
        }
        Collections.sort(list, (a, b) -> (a[0].equals(b[0]) ? Integer.compare(a[1], b[1]) :  Integer.compare(a[0], b[0])));
        int max = 0;
        int year = 0;
        int count = 0;
        for (Integer[] p : list) {
            count = count + p[1];
            if (count > max) {
                max = count;
                year = p[0];
            }
        }
        return year;
    }

    /**
     * HAcky way
     * @param logs
     * @return
     */
    public int maximumPopulationHacky(int[][] logs) {
        if (logs.length == 1) {
            return logs[0][0];
        }
        Map<Integer, Integer> yearPop = new HashMap<>();
        for (int[] log : logs) {
            for (int i = log[0]; i < log[1]; i++) {
                int pop = yearPop.getOrDefault(i, 0);
                pop++;
                yearPop.put(i, pop);
            }
        }
        int bigPop = 0;
        int year = 2050;
        for (int i = 2050; i >= 1950; i--) {
            if (yearPop.containsKey(i)) {
                int pop = yearPop.get(i);
                if (pop >= bigPop) {
                    bigPop = pop;
                    year = i;
                }
            }
        }
        return year;
    }
}
