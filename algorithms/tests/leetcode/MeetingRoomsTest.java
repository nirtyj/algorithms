package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class MeetingRoomsTest {

	@Test
	public void test() {
		MeetingRooms m = new MeetingRooms();
		Interval i1 = new Interval(6, 10);
		Interval i2 = new Interval(13, 14);
		Interval i3 = new Interval(12, 14);
		Interval[] intervals = { i1, i2, i3};
		assertEquals(false, m.canAttendMeetings(intervals));
	}

}
