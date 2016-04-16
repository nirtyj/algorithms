package epi.binarytree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HasPathSumTest {

	@Test
	public void test() {
		Integer[] vals = {0,1,2,3,4,null,6,7,8,null,null,null,null,13,14,15,16};
		assertEquals(true,  HasPathSum.hasPathSum(BinaryTreeUtils.buildTree(vals), 5));
		assertEquals(true,  HasPathSum.hasPathSum(BinaryTreeUtils.buildTree(vals), 27));
		
		assertEquals(false,  HasPathSum.hasPathSum(BinaryTreeUtils.buildTree(vals), 100));
		assertEquals(true,  HasPathSum.hasPathSum(BinaryTreeUtils.buildTree(vals), 26));
		assertEquals(true,  HasPathSum.hasPathSum(BinaryTreeUtils.buildTree(vals), 21));
		
		// uncomment the root.left == null and root.right == null check
		// then you can check partial paths
		
		//assertEquals(true,  problems.hasPathSum(list.get(0), 0));
		//assertEquals(true,  problems.hasPathSum(list.get(0), 1));
		//assertEquals(true,  problems.hasPathSum(list.get(0), 2));
		assertEquals(true,  HasPathSum.hasPathSum(BinaryTreeUtils.buildTree(vals), 12));
		assertEquals(true,  HasPathSum.hasPathSum(BinaryTreeUtils.buildTree(vals), 22));
		assertEquals(false,  HasPathSum.hasPathSum(BinaryTreeUtils.buildTree(vals), 23));
	}

}
