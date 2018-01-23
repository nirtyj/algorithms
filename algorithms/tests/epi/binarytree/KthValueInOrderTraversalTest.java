package epi.binarytree;

import static org.junit.Assert.*;

import org.junit.Test;

public class KthValueInOrderTraversalTest {

	@Test
	public void test() {
		Integer[] vals = {0,1,2,3,4,null,6,7,8,null,null,null,null,13,14,15,16};
		assertEquals(1, KthSmallestInBST.findKthValue(BinaryTreeUtils.buildTree(vals), 6).data.intValue());
		assertEquals(15, KthSmallestInBST.findKthValue(BinaryTreeUtils.buildTree(vals), 1).data.intValue());
		assertEquals(3, KthSmallestInBST.findKthValue(BinaryTreeUtils.buildTree(vals), 4).data.intValue());
		assertEquals(8, KthSmallestInBST.findKthValue(BinaryTreeUtils.buildTree(vals), 5).data.intValue());
		assertEquals(0, KthSmallestInBST.findKthValue(BinaryTreeUtils.buildTree(vals), 8).data.intValue());
		assertEquals(2, KthSmallestInBST.findKthValue(BinaryTreeUtils.buildTree(vals), 9).data.intValue());
		assertEquals(14, KthSmallestInBST.findKthValue(BinaryTreeUtils.buildTree(vals), 12).data.intValue());
		
	}
	
	

}
