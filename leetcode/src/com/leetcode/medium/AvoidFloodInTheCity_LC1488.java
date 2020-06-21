package com.leetcode.medium;

import java.util.HashMap;
import java.util.TreeSet;

public class AvoidFloodInTheCity_LC1488 {

    /**
     * k log n; k, number of days, n number of dry days days.
     *
     * @param rains
     * @return
     */
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer, Integer> flood = new HashMap<>();
        TreeSet<Integer> freeDayPos = new TreeSet<>();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) { // lazy removal. keep collecting the freeDays to dry
                freeDayPos.add(i);
            } else {
                boolean contains = flood.containsKey(rains[i]);
                if (contains) { // if its full, try to dry it using a possible freeday index, greater than previous seen lake day
                    int post = flood.get(rains[i]);
                    Integer dryPos = freeDayPos.ceiling(post);
                    if (dryPos == null) { // there are no zeros after previously seen lake day
                        return new int[0];
                    }
                    rains[dryPos] = rains[i]; // set that free day to remove the lake (note no index set). if it was index, it would be post
                    freeDayPos.remove(dryPos); // remove that free day available
                }
                flood.put(rains[i], i); // update last seen lake as today. (i)
                rains[i] = -1; // we consumed the rain. - set as -1
            }
        }
        // set the available free days to 1. Doesnt matter what it is being set to.
        for (int i : freeDayPos)
            rains[i] = 1;
        return rains;
    }
}
