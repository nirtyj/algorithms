package epi.sorting;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SalaryThresholdTest {

	@Test
	public void test() {
		Double[] targetSalaries = { 20.0, 30.0, 40.0, 90.0, 100.0 };
		assertEquals(new Double(60.0), SalaryThreshold.findSalaryCap(210, Arrays.asList(targetSalaries)));
	}

}
