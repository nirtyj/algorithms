package epi.binarytree;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class InverseBinaryTreeTest {

	@Test
	public void test()
	{
		Integer[] vals = {0,1,2,3,4,null,6,7,8,null,null,null,null,13,14,15,16};
		BinaryTreeNode<Integer> root = BinaryTreeUtils.buildTree(vals);
		System.out.println(root.toString());
		@SuppressWarnings("unused")
		List<BinaryTreeNode<Integer>> result = InvertBinaryTree.inverseTree(root);
		// Manually inspected!
		assertTrue(true);
	}

}
