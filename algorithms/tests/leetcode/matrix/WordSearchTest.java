package leetcode.matrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordSearchTest {

	public static char[][] getMatrix2() {
		char[][] matrix = {
						 {'A', 'B', 'C', 'E'},
						 {'S', 'F', 'C', 'S'},
						 {'A', 'D', 'E','E'},
						 };
		return matrix;
	}
	
	@Test
	public void test() {
		char[][] maze = getMatrix2();
		assertEquals(true, WordSearch.exist(maze, "ABCCED"));
		assertEquals(true, WordSearch.exist(maze, "SEE"));
		assertEquals(false, WordSearch.exist(maze, "ABCB"));
		
	}


}
