package epi.binarytree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import epi.binarytree.node.BinaryTreeNode;

public class BalancedBinaryTreeTest {

	@Test
	public void test() {
		BinaryTreeNode<Integer> tree = new BinaryTreeNode<>();
		tree.setLeft(new BinaryTreeNode<Integer>());
		tree.getLeft().setLeft(new BinaryTreeNode<Integer>());
		tree.setRight(new BinaryTreeNode<Integer>());
		tree.getRight().setLeft(new BinaryTreeNode<Integer>());
		tree.getRight().setRight(new BinaryTreeNode<Integer>());
		assertTrue(BalancedBinaryTree.isBalanced(tree));
		tree = new BinaryTreeNode<>();
		tree.setLeft(new BinaryTreeNode<Integer>());
		tree.getLeft().setLeft(new BinaryTreeNode<Integer>());
		assertFalse(BalancedBinaryTree.isBalanced(tree));
	}
	
	@Test
	public void test1()
	{
		Integer[] vals = {0,1,2,3,4,null,6,7,8,null,null,null,null,13,14,15,16};
		assertFalse(BalancedBinaryTree.isBalanced(BinaryTreeUtils.buildTree(vals)));
	}

}
