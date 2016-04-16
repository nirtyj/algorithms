package epi.binarytree;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class LCATest {

	@Test
	public void testLowestCommonAncestor() {
		BinaryTreeNode<Integer> tree = new BinaryTreeNode<>(3, null, null,null);
		tree.setLeft(new BinaryTreeNode<>(2, null, null,null));
		tree.getLeft().setLeft(new BinaryTreeNode<>(1, null, null,null));
		tree.setRight(new BinaryTreeNode<>(5, null, null,null));
		tree.getRight().setLeft(new BinaryTreeNode<>(4, null, null,null));
		tree.getRight().setRight(new BinaryTreeNode<>(6, null, null,null));
		// should output 3
		BinaryTreeNode<Integer> x = LCA.findLCA(tree, tree.getLeft(), tree.getRight());
		assertTrue(x.getData().equals(3));
		// should output 5
		x =  LCA.findLCA(tree, tree.getRight().getLeft(), tree.getRight().getRight());
		assertTrue(x.getData().equals(5));
		// should output 5
		x =  LCA.findLCA(tree, tree.getRight(), tree.getRight().getRight());
		assertTrue(x.getData().equals(5));
		// should output 3
		x =  LCA.findLCA(tree, tree.getLeft().getLeft(), tree.getRight().getRight());
		assertTrue(x.getData().equals(3));
		// should output 3
		x =  LCA.findLCA(tree, tree.getLeft().getLeft(), tree);
		assertTrue(x.getData().equals(3));
	}
	
	@Test
	public void testLowestCommonAncestor1() {		
		Integer[] vals = {0,1,2,3,4,null,6,7,8,null,null,null,null,13,14,15,16};
		List<BinaryTreeNode<Integer>> list = BinaryTreeUtils.getTreeAsList(vals);
		assertTrue(list.get(0) ==  LCA.findLCA(list.get(0), list.get(0), list.get(16)));		
	}
	
	@Test
	public void testLowestCommonAncestor2() {		
		Integer[] vals = {0,1,2,3,4,null,6,7,8,null,null,null,null,13,14,15,16};
		List<BinaryTreeNode<Integer>> list = BinaryTreeUtils.getTreeAsList(vals);
		assertTrue(list.get(7) ==  LCA.findLCA(list.get(0), list.get(15), list.get(16)));		
	}
	
	@Test
	public void testLowestCommonAncestor3() {		
		Integer[] vals = {0,1,2,3,4,null,6,7,8,null,null,null,null,13,14,15,16};
		List<BinaryTreeNode<Integer>> list = BinaryTreeUtils.getTreeAsList(vals);
		assertTrue(list.get(1) ==  LCA.findLCA(list.get(0), list.get(4), list.get(16)));		
	}
	
	@Test
	public void testLowestCommonAncestorwithParent1() {		
		Integer[] vals = {0,1,2,3,4,null,6,7,8,null,null,null,null,13,14,15,16};
		List<BinaryTreeNode<Integer>> list = BinaryTreeUtils.getTreeAsList(vals);
		assertTrue(list.get(0) ==  LCA.findLCAWithParent(list.get(0), list.get(16)));		
	}
	
	@Test
	public void testLowestCommonAncestorwithParent2() {		
		Integer[] vals = {0,1,2,3,4,null,6,7,8,null,null,null,null,13,14,15,16};
		List<BinaryTreeNode<Integer>> list = BinaryTreeUtils.getTreeAsList(vals);
		assertTrue(list.get(7) ==  LCA.findLCAWithParent(list.get(15), list.get(16)));		
	}
	
	@Test
	public void testLowestCommonAncestorwithParent3() {		
		Integer[] vals = {0,1,2,3,4,null,6,7,8,null,null,null,null,13,14,15,16};
		List<BinaryTreeNode<Integer>> list = BinaryTreeUtils.getTreeAsList(vals);
		assertTrue(list.get(1) ==  LCA.findLCAWithParent(list.get(4), list.get(16)));		
	}	
}
