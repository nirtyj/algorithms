package epi.hashtables;

import static org.junit.Assert.*;

import org.junit.Test;

public class LetterTest {

	@Test
	public void test() {
		assertTrue(Letter.canFormMagazine("foobar", "fadfasdfoerwerowrbwqerar"));
	}
	
	@Test
	public void test2() {
		assertFalse(Letter.canFormMagazine("foobar", "f"));
	}

	@Test
	public void test3() {
		assertTrue(Letter.canFormMagazine2("foobar", "fadfasdfoerwerowrbwqerar"));
	}
	
	@Test
	public void test4() {
		assertFalse(Letter.canFormMagazine2("foobar", "f"));
	}
	
	@Test
	public void test5() {
		assertTrue(Letter.canFormMagazine2("foooobar", "fadfasdfoerwerowrbwqeraroo"));
	}

}
