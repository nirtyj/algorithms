package puzzles;

import static org.junit.Assert.*;

import org.junit.Test;

public class EquilibriumIndexTest {

	@Test
	public void test() {
		Integer[] arr = {-7, 1, 5, 2, -4, 3, 0};
		assertEquals(3, EquilibriumIndex.getBalancePoint(arr));
	}

}
