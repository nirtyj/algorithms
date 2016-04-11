package bitmanipulation;

import static org.junit.Assert.*;

import org.junit.Test;

public class HammingDistanceTest {

	@Test
	public void test() {
		HammingDistance hammingDistance = new HammingDistance();
		assertEquals(3 , hammingDistance.countDigitsToMake(Integer.parseInt("110011011", 2), Integer.parseInt("111010001", 2)));
		assertEquals(0 , hammingDistance.countDigitsToMake(Integer.parseInt("110011011", 2), Integer.parseInt("110011011", 2)));
	}
}
