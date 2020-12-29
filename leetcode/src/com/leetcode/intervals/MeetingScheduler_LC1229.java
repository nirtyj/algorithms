package com.leetcode.intervals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingScheduler_LC1229 {

    /**
     * PriorityQueue merged - as you wont have duplicates from 1 slot array.
     * remove slots that are smaller than duration
     * @param slots1
     * @param slots2
     * @param duration
     * @return
     */
    public List<Integer> minAvailableDurationBest(int[][] slots1, int[][] slots2, int duration) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        };
        PriorityQueue<int[]> pq = new PriorityQueue<>(comparator);
        for (int[] s : slots1) {
            if (s[1] - s[0] >= duration)
                pq.offer(s);
        }
        for (int[] s : slots2) {
            if (s[1] - s[0] >= duration)
                pq.offer(s);
        }
        while (pq.size() > 1) {
            int[] arr1 = pq.poll();
            int[] arr2 = pq.peek();
            if (Math.max(arr1[0], arr2[0]) + duration <= Math.min(arr1[1], arr2[1]))
                return Arrays.asList(Math.max(arr1[0], arr2[0]), Math.max(arr1[0], arr2[0]) + duration);
        }
        return Arrays.asList();
    }

    /**
     * Sorting with interval iterating
     * @param slots1
     * @param slots2
     * @param duration
     * @return
     */
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Comparator<int[]> comparator = Comparator.comparingInt(a -> a[0]);
        Arrays.sort(slots1, comparator);
        Arrays.sort(slots2, comparator);
        int i = 0;
        int j = 0;
        int[] arr1 = slots1[i];
        int[] arr2 = slots2[j];
        while(arr1 != null && arr2 != null){
            if (isOverLapWithEnoughDuration(arr1, arr2, duration)){
                return Arrays.asList(Math.max(arr1[0], arr2[0]), Math.max(arr1[0], arr2[0]) + duration);
            }
            if (arr1[1] <= arr2[1]) {
                if (i + 1 < slots1.length) {
                    i = i + 1;
                    arr1 = slots1[i];
                } else {
                    arr1 = null;
                }
            } else {
                if (j + 1 < slots2.length) {
                    j = j + 1;
                    arr2 = slots2[j];
                } else {
                    arr2 = null;
                }
            }
        }
        return Collections.EMPTY_LIST;
    }

    private boolean isOverLapWithEnoughDuration(int[] arr1, int[] arr2, int duration) {
        return Math.max(arr1[0], arr2[0]) + duration <= Math.min(arr1[1], arr2[1]);
    }
}
