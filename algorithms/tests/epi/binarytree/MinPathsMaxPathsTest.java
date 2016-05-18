package epi.binarytree;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MinPathsMaxPathsTest {

	@Test
	public void test() {
		Integer[] vals = {0,1,2,3,4,null,6,7,8,null,null,null,null,13,14,15,16};
		List<BinaryTreeNode<Integer>> nlist = MinPathsMaxPaths.getMinPaths(BinaryTreeUtils.buildTree(vals));	
		assertEquals("[0, 1, 4]", Arrays.toString(BinaryTreeUtils.getTreeListAsArray(nlist)));

	}
	
	@Test
	public void test1() {
		Integer[] vals = {0,1,2,3,4,null,6,7,8,null,null,null,null,13,14,15,16};
		List<BinaryTreeNode<Integer>> nlist = MinPathsMaxPaths.getMaxPaths(BinaryTreeUtils.buildTree(vals));	
		assertEquals("[0, 1, 3, 7, 15]", Arrays.toString(BinaryTreeUtils.getTreeListAsArray(nlist)));
	}

}
