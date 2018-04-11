package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import com.leetcode.common.Interval;

/**
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
*/
public class MeetingRoomsII {

	/**
	 * Leetcode verified
	 * @param intervals
	 * @return
	 */
	public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;

		Arrays.sort(intervals, new Comparator<Interval>() {
			// sort the start if they are different
			// if start is same, sort based on the end
			public int compare(Interval i1, Interval i2) {
				if (i1.start != i2.start)
					return i1.start - i2.start;
				else
					return i1.end - i2.end;
			}
		});

		ArrayList<Interval> queue = new ArrayList<Interval>();
		queue.add(intervals[0]);

		for (int i = 1; i < intervals.length; i++) {
			Interval curr = intervals[i];
			boolean isSet = false;
			for (int q = 0; q < queue.size(); q++) {
				if (curr.start < queue.get(q).end) {
					continue;
				} else {
					queue.set(q, curr);
					isSet = true;
					break;
				}
			}
			if (isSet == false) {
				queue.add(curr);
			}
		}
		return queue.size();
	}
	
	
	/**
	 * Instead of going from one by one.. use minheap to get the finishing first
	 * interval.
	 */
	public int minMeetingRooms1(Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;

		Arrays.sort(intervals, new Comparator<Interval>() {
			// sort the start if they are different
			// if start is same, sort based on the end
			public int compare(Interval i1, Interval i2) {
				if (i1.start != i2.start)
					return i1.start - i2.start;
				else
					return i1.end - i2.end;
			}
		});

		PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.end - b.end;
			}
		});

		heap.offer(intervals[0]);

		for (int i = 1; i < intervals.length; i++) {
			Interval finishingfirst = heap.poll();
			if (intervals[i].start < finishingfirst.end) {
				heap.offer(intervals[i]);
			} else {
				finishingfirst.end = intervals[i].end;
			}
			heap.offer(finishingfirst);
		}
		return heap.size();
	}
	
	/**
	 * Most efficient
	 * @param intervals
	 * @return
	 */
	public int minMeetingRooms2(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endsItr = 0;
        for(int i=0; i<starts.length; i++) {
            if(starts[i]<ends[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;
    }
}
