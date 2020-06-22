package com.leetcode.medium;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * Your country has an infinite number of lakes. Initially, all the lakes are empty, but when it rains over the nth lake, the nth lake becomes full of water. If it rains over a lake which is full of water, there will be a flood. Your goal is to avoid the flood in any lake.
 *
 * Given an integer array rains where:
 *
 * rains[i] > 0 means there will be rains over the rains[i] lake.
 * rains[i] == 0 means there are no rains this day and you can choose one lake this day and dry it.
 * Return an array ans where:
 *
 * ans.length == rains.length
 * ans[i] == -1 if rains[i] > 0.
 * ans[i] is the lake you choose to dry in the ith day if rains[i] == 0.
 * If there are multiple valid answers return any of them. If it is impossible to avoid flood return an empty array.
 *
 * Notice that if you chose to dry a full lake, it becomes empty, but if you chose to dry an empty lake, nothing changes. (see example 4)
 *
 *
 *
 * Example 1:
 *
 * Input: rains = [1,2,3,4]
 * Output: [-1,-1,-1,-1]
 * Explanation: After the first day full lakes are [1]
 * After the second day full lakes are [1,2]
 * After the third day full lakes are [1,2,3]
 * After the fourth day full lakes are [1,2,3,4]
 * There's no day to dry any lake and there is no flood in any lake.
 * Example 2:
 *
 * Input: rains = [1,2,0,0,2,1]
 * Output: [-1,-1,2,1,-1,-1]
 * Explanation: After the first day full lakes are [1]
 * After the second day full lakes are [1,2]
 * After the third day, we dry lake 2. Full lakes are [1]
 * After the fourth day, we dry lake 1. There is no full lakes.
 * After the fifth day, full lakes are [2].
 * After the sixth day, full lakes are [1,2].
 * It is easy that this scenario is flood-free. [-1,-1,1,2,-1,-1] is another acceptable scenario.
 * Example 3:
 *
 * Input: rains = [1,2,0,1,2]
 * Output: []
 * Explanation: After the second day, full lakes are  [1,2]. We have to dry one lake in the third day.
 * After that, it will rain over lakes [1,2]. It's easy to prove that no matter which lake you choose to dry in the 3rd day, the other one will flood.
 * Example 4:
 *
 * Input: rains = [69,0,0,0,69]
 * Output: [-1,69,1,1,-1]
 * Explanation: Any solution on one of the forms [-1,69,x,y,-1], [-1,x,69,y,-1] or [-1,x,y,69,-1] is acceptable where 1 <= x,y <= 10^9
 * Example 5:
 *
 * Input: rains = [10,20,20]
 * Output: []
 * Explanation: It will rain over lake 20 two consecutive days. There is no chance to dry any lake.
 */
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
