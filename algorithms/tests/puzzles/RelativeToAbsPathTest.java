package puzzles;

import static org.junit.Assert.*;

import org.junit.Test;

public class RelativeToAbsPathTest {

	@Test
	public void test() {
		String relpath = "/windows/abs/../temp/new/../";
		assertEquals("/windows/temp", RelativeToAbsPath.resolvePath(relpath));
	}
	
	@Test
	public void test2() {
		String relpath = "/windows/abs/temp/../../new/";
		assertEquals("/windows/new", RelativeToAbsPath.resolvePath(relpath));
	}

}
