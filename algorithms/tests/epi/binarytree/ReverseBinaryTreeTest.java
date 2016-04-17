package epi.binarytree;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ReverseBinaryTreeTest {

	@Test
	public void test() {
		Integer[] vals = {0,1,2,3,4,null,6,7,8,null,null,null,null,13,14,15,16};
		BinaryTreeNode<Integer> node1 = BinaryTreeUtils.buildTree(vals);
		ReverseEqualsBinaryTree.reverseTree(node1);	
		BinaryTreeNode<Integer> node2  = BinaryTreeUtils.buildTree(vals);
		ReverseEqualsBinaryTree.reverseTree(node1);
		assertTrue(ReverseEqualsBinaryTree.isEqualTrees(node1, node2));
	}

}
