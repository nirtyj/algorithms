package com.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.easy.ExcelTitle;

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
