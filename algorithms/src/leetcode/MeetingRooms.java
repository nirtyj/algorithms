package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {

	/**
	 * leetcode verified
	 * @param intervals
	 * @return
	 */
	public boolean canAttendMeetings(Interval[] intervals) {

		if (intervals == null || intervals.length == 0)
			return true;

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

		Interval pre = intervals[0];
		for (int i = 1; i < intervals.length; i++) {
			Interval curr = intervals[i];
			if (curr.start < pre.end) {
				return false;
			}
			pre = curr;
		}
		return true;
	}

}
