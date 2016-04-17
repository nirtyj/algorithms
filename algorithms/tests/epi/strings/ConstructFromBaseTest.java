package epi.strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConstructFromBaseTest {

	@Test
	public void test() {
		assertEquals("1A7", ConstructFromBase.convertBase("615", 7, 13));
	}

}
