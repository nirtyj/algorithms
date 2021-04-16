package com.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MinimumAreaRectangle_LC939 {

    /**
     * find corresponding diagonal
     * @param points
     * @return
     */
    public int minAreaRectDiagonal(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p : points) {
            if (!map.containsKey(p[0])) {
                map.put(p[0], new HashSet<>());
            }
            map.get(p[0]).add(p[1]);
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<points.length; ++i) {
            for(int j=i+1; j<points.length; ++j) {
                int[] p1 = points[i];
                int[] p2 = points[j];
                if (p1[0] == p2[0] || p1[1] == p2[1]) { // if have the same x or y
                    continue;
                }
                if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) { // find other two points
                    min = Math.min(min, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    /**
     * sort by column method
     * @param points
     * @return
     */
    public int minAreaRect(int[][] points) {
        TreeMap<Integer, TreeSet<Integer>> pts = new TreeMap<>();
        for(int[] pt : points){
            TreeSet<Integer> ys = pts.getOrDefault(pt[0], new TreeSet<>());
            ys.add(pt[1]);
            pts.put(pt[0], ys);
        }
        int result = Integer.MAX_VALUE;
        for(Map.Entry<Integer, TreeSet<Integer>> entryOut : pts.entrySet()){
            // find x's higher than current x
            for(Map.Entry<Integer, TreeSet<Integer>> entryBigger : pts.tailMap(entryOut.getKey(), false).entrySet()){
                TreeSet<Integer> prevSet = new TreeSet<>(entryOut.getValue());
                TreeSet<Integer> currSet = new TreeSet<>(entryBigger.getValue());
                prevSet.retainAll(currSet); // find intersection to get the common y points.
                int xValDiff = entryBigger.getKey() - entryOut.getKey(); // length
                Integer prevY = null;
                for(Integer v : prevSet){
                    if (prevY == null){
                        prevY = v;
                        continue;
                    }
                    int yValDiff = v - prevY; // breadth
                    result = Math.min(result, xValDiff * yValDiff); // min of area.
                    prevY = v; // compare next set of y points
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
