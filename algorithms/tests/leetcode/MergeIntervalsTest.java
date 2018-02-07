package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class MergeIntervalsTest {

	@Test
	public void test() {
		Interval v1 = new Interval(1, 3);
		Interval v2 = new Interval(2, 6);
		Interval v3 = new Interval(8, 10);
		Interval v4 = new Interval(15, 18);
		ArrayList<Interval> arrs = new ArrayList<>();
		arrs.add(v1);
		arrs.add(v2);
		arrs.add(v3);
		arrs.add(v4);
		assertEquals(3, MergeIntervals.merge(arrs).size());
	}

}
