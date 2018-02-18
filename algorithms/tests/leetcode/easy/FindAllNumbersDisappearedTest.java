package leetcode.easy;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class FindAllNumbersDisappearedTest {

	@Test
	public void test() {
		int[] arr = {4,3,2,7,8,2,3,1};
		List<Integer> result = FindAllNumbersDisappeared.findDisappearedNumbers(arr);
		assertEquals(2, result.size());
	}

}
