package leetcode.medium;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FriendCirclesTest {

	@Test
	public void test() {
		int[][] input = {{1,1,0},{1,1,0},{0,0,1}};
		assertEquals(2, FriendCircles.findCircleNum(input));
	}

}