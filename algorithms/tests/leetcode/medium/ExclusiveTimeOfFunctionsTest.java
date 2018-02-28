package leetcode.medium;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ExclusiveTimeOfFunctionsTest {

	@Test
	public void test() {
		String[] arr = { "0:start:0", "1:start:2", "1:end:5", "0:end:6" };
		int[] result = ExclusiveTimeOfFunctions.exclusiveTime(2, Arrays.asList(arr));
		assertEquals(2, result.length);
	}

	@Test
	public void test2() {
		String[] arr = { "0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7" };
		int[] result = ExclusiveTimeOfFunctions.exclusiveTime(1, Arrays.asList(arr));
		assertEquals(1, result.length);
	}

	@Test
	public void test3() {
		String[] arr = { "0:start:0", "1:start:5", "2:start:6", "3:start:9", "4:start:11", "5:start:12", "6:start:14",
				"7:start:15", "1:start:24", "1:end:29", "7:end:34", "6:end:37", "5:end:39", "4:end:40", "3:end:45",
				"0:start:49", "0:end:54", "5:start:55", "5:end:59", "4:start:63", "4:end:66", "2:start:69", "2:end:70",
				"2:start:74", "6:start:78", "0:start:79", "" + "0:end:80", "6:end:85", "1:start:89", "1:end:93",
				"2:end:96", "2:end:100", "1:end:102", "2:start:105", "2:end:109", "0:end:114" };
		int[] result = ExclusiveTimeOfFunctions.exclusiveTime(1, Arrays.asList(arr));
		assertEquals(1, result.length);
	}
}
