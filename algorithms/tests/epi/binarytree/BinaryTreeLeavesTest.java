package epi.binarytree;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class BinaryTreeLeavesTest {

	@Test
	public void test() {
		Integer[] vals = {0,1,2,3,4,null,6,7,8,null,null,null,null,13,14,15,16};
		List<BinaryTreeNode<Integer>> nlist = BinaryTreeLeaves.createListOfLeaves(BinaryTreeUtils.buildTree(vals));	
		assertEquals("[15, 16, 8, 4, 13, 14]", Arrays.toString(BinaryTreeUtils.getTreeListAsArray(nlist)));
	}

}
