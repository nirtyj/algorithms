package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import com.leetcode.common.Interval;

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
}
