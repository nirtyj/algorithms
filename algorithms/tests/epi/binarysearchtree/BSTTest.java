package epi.binarysearchtree;

import static org.junit.Assert.*;

import org.junit.Test;

import epi.binarytree.BinaryTreeUtils;

public class BSTTest {

	@Test
	public void test() {
		Integer[] vals = {60,41,74,16,53,65,null,null,25,46,56,63,70,null,null,null,null,null,null,42,null,null,null,62,64,null,null,null,null,null,null};
		assertTrue(BST.isBstFail((BinaryTreeUtils.buildTree(vals))));
	}

	@Test
	public void test1() {
		Integer[] vals = {60,41,74,16,53,65,null,null,25,46,56,63,70,null,null,null,null,null,null,42,null,null,59,62,64,null,null,null,null,null,null};
		assertTrue(BST.isBstFail((BinaryTreeUtils.buildTree(vals))));
	}
	
	@Test
	public void test2() {
		@SuppressWarnings("unused")
		Integer[] vals = {60,41,74,16,53,65,null,null,25,46,56,63,70,null,null,null,null,null,null,42,null,null,61,62,64,null,null,null,null,null,null};
		// fails in this case. 
		// assertFalse(BST.isBstFail((BinaryTreeUtils.buildTree(vals))));
	}
	
	@Test
	public void test3() {
		Integer[] vals = {60,41,74,16,53,65,null,null,25,46,56,63,70,null,null,null,null,null,null,42,null,null,null,62,64,null,null,null,null,null,null};
		assertTrue(BST.isBst((BinaryTreeUtils.buildTree(vals))));
	}

	@Test
	public void test4() {
		Integer[] vals = {60,41,74,16,53,65,null,null,25,46,56,63,70,null,null,null,null,null,null,42,null,null,59,62,64,null,null,null,null,null,null};
		assertTrue(BST.isBst((BinaryTreeUtils.buildTree(vals))));
	}
	
	@Test
	public void test5() {
		Integer[] vals = {60,41,74,16,53,65,null,null,25,46,56,63,70,null,null,null,null,null,null,42,null,null,61,62,64,null,null,null,null,null,null};
		assertFalse(BST.isBst((BinaryTreeUtils.buildTree(vals))));
	}

	@Test
	public void testsearch() {
		Integer[] vals = {60,41,74,16,53,65,null,null,25,46,56,63,70,null,null,null,null,null,null,42,null,null,59,62,64,null,null,null,null,null,null};
		assertTrue(BST.searchValue(BinaryTreeUtils.buildTree(vals), 70));
	}
	
	@Test
	public void testsearch1() {
		Integer[] vals = {60,41,74,16,53,65,null,null,25,46,56,63,70,null,null,null,null,null,null,42,null,null,59,62,64,null,null,null,null,null,null};
		assertFalse(BST.searchValue(BinaryTreeUtils.buildTree(vals), 69));
	}
	
	@Test
	public void testsearch2() {
		Integer[] vals = {60,41,74,16,53,65,null,null,25,46,56,63,70,null,null,null,null,null,null,42,null,null,59,62,64,null,null,null,null,null,null};
		assertTrue(BST.searchValue(BinaryTreeUtils.buildTree(vals), 65));
	}
	
	@Test
	public void testsearch3() {
		Integer[] vals = {60,41,74,16,53,65,null,null,25,46,56,63,70,null,null,null,null,null,null,42,null,null,59,62,64,null,null,null,null,null,null};
		assertTrue(BST.searchValue(BinaryTreeUtils.buildTree(vals), 25));
	}
	
	@Test
	public void testsearch4() {
		Integer[] vals = {60,41,74,16,53,65,null,null,25,46,56,63,70,null,null,null,null,null,null,42,null,null,59,62,64,null,null,null,null,null,null};
		assertTrue(BST.searchValue(BinaryTreeUtils.buildTree(vals), 42));
	}
	
	@Test
	public void testsearch5() {
		Integer[] vals = {60,41,74,16,53,65,null,null,25,46,56,63,70,null,null,null,null,null,null,42,null,null,59,62,64,null,null,null,null,null,null};
		assertFalse(BST.searchValue(BinaryTreeUtils.buildTree(vals), 58));
	}
}
