package epi.binarytree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxHeightInTreeTest {

	@Test
	public void test() {
		Integer[] vals = { 0, 1, 2, 3, 4, null, null, 7, 8, null, null, null, null, null, null, 15, 16 };
		assertEquals(5, MaxHeightInTree.getMaxHeight(BinaryTreeUtils.buildTree(vals)));
	}
}
