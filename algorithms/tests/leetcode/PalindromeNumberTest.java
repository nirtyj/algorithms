package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalindromeNumberTest {

	@Test
	public void test() {
		assertEquals(true , PalindromeNumber.isPalindrome(131));
		assertEquals(false , PalindromeNumber.isPalindrome(1445));
		assertEquals(true , PalindromeNumber.isPalindrome(1441));
	}

}
