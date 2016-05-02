package bitmanipulation;

import static org.junit.Assert.*;

import org.junit.Test;

public class BasicManipulationTest {
	BasicBitManipulation basic = new BasicBitManipulation();
	
	@Test
	public void testGetbit() {
		/**
		 * Integer.valueOf("11010100", 2);
		 * Integer.toBinaryString("234");
		 */
		assertTrue(basic.getBit(Integer.valueOf("11010100", 2), 4));
		assertFalse(basic.getBit(Integer.valueOf("11010100", 2), 0));
		assertTrue(basic.getBit(Integer.valueOf("11010100", 2), 7));
	}

	@Test
	public void testClearbit() {		
		assertEquals((int)Integer.valueOf("11010000", 2), basic.clearBit(Integer.valueOf("11010100", 2), 2));
		assertEquals((int)Integer.valueOf("11010100", 2), basic.clearBit(Integer.valueOf("11010100", 2), 0));
		assertEquals((int)Integer.valueOf("01010100", 2), basic.clearBit(Integer.valueOf("11010100", 2), 7));
	}
	
	@Test
	public void testFlipbit() {		
		assertEquals((int)Integer.valueOf("11010000", 2), basic.flipBit(Integer.valueOf("11010100", 2), 2));
		assertEquals((int)Integer.valueOf("11010101", 2), basic.flipBit(Integer.valueOf("11010100", 2), 0));
		assertEquals((int)Integer.valueOf("01010100", 2), basic.flipBit(Integer.valueOf("11010100", 2), 7));
		assertEquals((int)Integer.valueOf("10010100", 2), basic.flipBit(Integer.valueOf("11010100", 2), 6));
		assertEquals((int)Integer.valueOf("11110100", 2), basic.flipBit(Integer.valueOf("11010100", 2), 5));
	}
	
	
	@Test
	public void testSetbit() {		
		assertEquals((int)Integer.valueOf("11010100", 2), basic.setBit(Integer.valueOf("11010100", 2), 2));
		assertEquals((int)Integer.valueOf("11010101", 2), basic.setBit(Integer.valueOf("11010100", 2), 0));
		assertEquals((int)Integer.valueOf("11010100", 2), basic.setBit(Integer.valueOf("11010100", 2), 7));
		assertEquals((int)Integer.valueOf("11010100", 2), basic.setBit(Integer.valueOf("11010100", 2), 6));
		assertEquals((int)Integer.valueOf("11110100", 2), basic.setBit(Integer.valueOf("11010100", 2), 5));
	}
	
	@Test
	public void testSetIbit() {		
		assertEquals((int)Integer.valueOf("11010100", 2), basic.setBit(Integer.valueOf("11010100", 2), 2, true));
		assertEquals((int)Integer.valueOf("11010000", 2), basic.setBit(Integer.valueOf("11010100", 2), 2, false));	
		
		assertEquals((int)Integer.valueOf("11010101", 2), basic.setBit(Integer.valueOf("11010100", 2), 0, true));
		assertEquals((int)Integer.valueOf("11010100", 2), basic.setBit(Integer.valueOf("11010100", 2), 0, false));	
		
		assertEquals((int)Integer.valueOf("11010100", 2), basic.setBit(Integer.valueOf("11010100", 2), 7, true));
		assertEquals((int)Integer.valueOf("01010100", 2), basic.setBit(Integer.valueOf("11010100", 2), 7, false));	
		
		assertEquals((int)Integer.valueOf("11010100", 2), basic.setBit(Integer.valueOf("11010100", 2), 6, true));
		assertEquals((int)Integer.valueOf("10010100", 2), basic.setBit(Integer.valueOf("11010100", 2), 6, false));
		
		assertEquals((int)Integer.valueOf("11110100", 2), basic.setBit(Integer.valueOf("11010100", 2), 5, true));
		assertEquals((int)Integer.valueOf("11010100", 2), basic.setBit(Integer.valueOf("11010100", 2), 5, false));
	}
	
	@Test
	public void testclearBitsMSBThroughI() {		
		assertEquals((int)Integer.valueOf("00000100", 2), basic.clearBitsMSBThroughI(Integer.valueOf("11010100", 2), 3));
		assertEquals((int)Integer.valueOf("0", 2), basic.clearBitsMSBThroughI(Integer.valueOf("11010101", 2), 0));
	}
	
	@Test
	public void clearBitsIthrough0() {		
		assertEquals((int)Integer.valueOf("11010000", 2), basic.clearBitsIthrough0(Integer.valueOf("11010100", 2), 3));
		assertEquals((int)Integer.valueOf("11010100", 2), basic.clearBitsIthrough0(Integer.valueOf("11010101", 2), 0));
	}
	
	@Test
	public void testSetBitsMSBThroughI() {		
		assertEquals((int)Integer.valueOf("11111100", 2), basic.setBitsMSBThroughI(Integer.valueOf("11010100", 2), 3));
		assertEquals((int)Integer.valueOf("11111111", 2), basic.setBitsMSBThroughI(Integer.valueOf("11010101", 2), 0));
	}
	
	@Test
	public void testSetBitsIthrough0() {		
		assertEquals((int)Integer.valueOf("11011111", 2), basic.setBitsIthrough0(Integer.valueOf("11010100", 2), 3));
		assertEquals((int)Integer.valueOf("11010101", 2), basic.setBitsIthrough0(Integer.valueOf("11010101", 2), 0));
	}
	
	@Test
	public void testsignBits() {	
		assertEquals(0, basic.getSignBit(1));
		assertEquals(1, basic.getSignBit(-5));
		assertEquals(0, basic.getSignBit(-0));
		assertEquals(0, basic.getSignBit(8));
		assertEquals(1, basic.getSignBit(-99));		
	}
	
	@Test
	public void testNegativeNumbers() {		
		assertEquals(5, basic.getNegativeNumber(-5));
		assertEquals(1, basic.getNegativeNumber(-1));
		assertEquals(99, basic.getNegativeNumber(-99));
	}
	
	@Test
	public void testPowerof2() {		
		assertEquals(false, basic.isPowerOf2(5));
		assertEquals(false, basic.isPowerOf2(1));
		assertEquals(false, basic.isPowerOf2(98));
		assertEquals(true, basic.isPowerOf2(64));
	}
	

	@Test
	public void testBitSetcountA() {		
		assertEquals(4, basic.bitSetcountA(Integer.valueOf("11010100", 2)));
		assertEquals(5, basic.bitSetcountA(Integer.valueOf("11010101", 2)));
		assertEquals(8, basic.bitSetcountA(Integer.valueOf("11111111", 2)));
		assertEquals(0, basic.bitSetcountA(Integer.valueOf("0", 2)));
	}
	
	@Test
	public void testBitSetcountB() {		
		assertEquals(4, basic.bitSetcountB(Integer.valueOf("11010100", 2)));
		assertEquals(5, basic.bitSetcountB(Integer.valueOf("11010101", 2)));
		assertEquals(8, basic.bitSetcountB(Integer.valueOf("11111111", 2)));
		assertEquals(0, basic.bitSetcountA(Integer.valueOf("0", 2)));
	}
	
}
