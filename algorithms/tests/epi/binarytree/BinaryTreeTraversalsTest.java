package epi.binarytree;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class BinaryTreeTraversalsTest {

	@Test
	public void testPreOrder() {		
		Integer[] vals = {0,1,2,3,4,null,6,7,8,null,null,null,null,13,14,15,16};
		List<BinaryTreeNode<Integer>> nlist = BinaryTreeTraversals.getPreOrderTraversal(BinaryTreeUtils.buildTree(vals));	
		assertEquals("[0, 1, 3, 7, 15, 16, 8, 4, 2, 6, 13, 14]", Arrays.toString(BinaryTreeUtils.getTreeListAsArray(nlist)));
	}
	
	@Test
	public void testInOrder() {		
		Integer[] vals = {0,1,2,3,4,null,6,7,8,null,null,null,null,13,14,15,16};
		List<BinaryTreeNode<Integer>> nlist = BinaryTreeTraversals.getInOrderTraversal(BinaryTreeUtils.buildTree(vals));	
		assertEquals("[15, 7, 16, 3, 8, 1, 4, 0, 2, 13, 6, 14]", Arrays.toString(BinaryTreeUtils.getTreeListAsArray(nlist)));
	}
	
	@Test
	public void testPostOrder() {		
		Integer[] vals = {0,1,2,3,4,null,6,7,8,null,null,null,null,13,14,15,16};
		List<BinaryTreeNode<Integer>> nlist = BinaryTreeTraversals.getPostOrderTraversal(BinaryTreeUtils.buildTree(vals));	
		assertEquals("[15, 16, 7, 8, 3, 4, 1, 13, 14, 6, 2, 0]", Arrays.toString(BinaryTreeUtils.getTreeListAsArray(nlist)));
	}
	
	@Test
	public void testLevelOrder() {
		Integer[] vals = {0,1,2,3,4,null,6,7,8,null,null,null,null,13,14,15,16};
		List<BinaryTreeNode<Integer>> nlist = BinaryTreeTraversals.getLevelOrderTraversal(BinaryTreeUtils.buildTree(vals));	
		assertEquals("[0, 1, 2, 3, 4, 6, 7, 8, 13, 14, 15, 16]", Arrays.toString(BinaryTreeUtils.getTreeListAsArray(nlist)));
	}

	@Test
	public void testLevelOrderByK() {
		Integer[] vals = {0,1,2,3,4,null,6,7,8,null,null,null,null,13,14,15,16};
		List<BinaryTreeNode<Integer>> nlist = BinaryTreeTraversals.getLevelOrderTraversal(BinaryTreeUtils.buildTree(vals), 3);	
		assertEquals("[7, 8, 13, 14]", Arrays.toString(BinaryTreeUtils.getTreeListAsArray(nlist)));
	}
	
	@Test
	public void testLevelOrderByK1() {
		Integer[] vals = {0,1,2,3,4,null,6,7,8,null,null,null,null,13,14,15,16};
		List<BinaryTreeNode<Integer>> nlist = BinaryTreeTraversals.getLevelOrderTraversal(BinaryTreeUtils.buildTree(vals), 4);	
		assertEquals("[15, 16]", Arrays.toString(BinaryTreeUtils.getTreeListAsArray(nlist)));
	}
	
	@Test
	public void testDepthFirstOrderByK() {
		Integer[] vals = {0,1,2,3,4,null,6,7,8,null,null,null,null,13,14,15,16};
		List<BinaryTreeNode<Integer>> nlist = BinaryTreeTraversals.getNodeAtLevelByDepthFirstTraversal(BinaryTreeUtils.buildTree(vals), 3);	
		assertEquals("[7, 8, 13, 14]", Arrays.toString(BinaryTreeUtils.getTreeListAsArray(nlist)));
	}
	
	@Test
	public void testDepthFirstByK1() {
		Integer[] vals = {0,1,2,3,4,null,6,7,8,null,null,null,null,13,14,15,16};
		List<BinaryTreeNode<Integer>> nlist = BinaryTreeTraversals.getNodeAtLevelByDepthFirstTraversal(BinaryTreeUtils.buildTree(vals), 4);	
		assertEquals("[15, 16]", Arrays.toString(BinaryTreeUtils.getTreeListAsArray(nlist)));
	}
}
