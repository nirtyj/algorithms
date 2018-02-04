package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExcelTitleTest {

	@Test
	public void test() {
		//assertEquals("A", ExcelTitle.convertToTitle(1));
		//assertEquals("Z", ExcelTitle.convertToTitle(26));
		//assertEquals("AA", ExcelTitle.convertToTitle(27));
		//assertEquals("AZ", ExcelTitle.convertToTitle(52));
		assertEquals("BA", ExcelTitle.convertToTitle(53));
	}

}
