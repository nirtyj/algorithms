package epi.binarytree;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestConsequtivePathsTest {

	@Test
	public void test() {
		Integer[] vals = {0,1,2,3,4,null,6,7,8,null,null,null,null,13,14,15,16};
		BinaryTreeNode<Integer> node1 = BinaryTreeUtils.buildTree(vals);
		assertEquals(4, LongestConsequtivePaths.longestConsecutivePaths(node1));
	}
	
	@Test
	public void test2() {
		Integer[] vals = {10,1,2,3,4,null,16,17,8,null,null,null,null,13,14,15,16,17};
		BinaryTreeNode<Integer> node1 = BinaryTreeUtils.buildTree(vals);
		assertEquals(3, LongestConsequtivePaths.longestConsecutivePaths(node1));
	}

}
