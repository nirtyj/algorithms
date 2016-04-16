package epi.binarytree;

import static org.junit.Assert.*;

import org.junit.Test;

public class SymmetricBinaryTreeTest {

	@Test
	public void test() {
		BinaryTreeNode<Integer> symmTree = new BinaryTreeNode<>();
	    assertTrue(SymmetricBinaryTree.isSymmetric(symmTree));
	    symmTree.setLeft(new BinaryTreeNode<Integer>());
	    assertFalse(SymmetricBinaryTree.isSymmetric(symmTree));
	    symmTree.setRight(new BinaryTreeNode<Integer>());
	    assertTrue(SymmetricBinaryTree.isSymmetric(symmTree));
	    symmTree.getRight().setRight(new BinaryTreeNode<Integer>());
	    assertTrue(!SymmetricBinaryTree.isSymmetric(symmTree));
	    BinaryTreeNode<Integer> nonSymmTree = new BinaryTreeNode<>();
	    nonSymmTree.setLeft(new BinaryTreeNode<Integer>());
	    nonSymmTree.getLeft().setLeft(new BinaryTreeNode<Integer>());
	    nonSymmTree.setRight(new BinaryTreeNode<Integer>());
	    nonSymmTree.getRight().setLeft(new BinaryTreeNode<Integer>());
	    nonSymmTree.getRight().setRight(new BinaryTreeNode<Integer>());
	    assertTrue(!SymmetricBinaryTree.isSymmetric(nonSymmTree));
	    symmTree = new BinaryTreeNode<>();
	    symmTree.setLeft(new BinaryTreeNode<Integer>());
	    symmTree.setRight(new BinaryTreeNode<Integer>());
	    assertTrue(SymmetricBinaryTree.isSymmetric(symmTree));
	}

	@Test
	public void test2() {
		BinaryTreeNode<Integer> symmTree = new BinaryTreeNode<>();
	    assertTrue(SymmetricBinaryTree.isSymmetricByPrint(symmTree));
	    symmTree.setLeft(new BinaryTreeNode<Integer>());
	    assertFalse(SymmetricBinaryTree.isSymmetricByPrint(symmTree));
	    symmTree.setRight(new BinaryTreeNode<Integer>());
	    assertTrue(SymmetricBinaryTree.isSymmetricByPrint(symmTree));
	    symmTree.getRight().setRight(new BinaryTreeNode<Integer>());
	    assertTrue(!SymmetricBinaryTree.isSymmetricByPrint(symmTree));
	    BinaryTreeNode<Integer> nonSymmTree = new BinaryTreeNode<>();
	    nonSymmTree.setLeft(new BinaryTreeNode<Integer>());
	    nonSymmTree.getLeft().setLeft(new BinaryTreeNode<Integer>());
	    nonSymmTree.setRight(new BinaryTreeNode<Integer>());
	    nonSymmTree.getRight().setLeft(new BinaryTreeNode<Integer>());
	    nonSymmTree.getRight().setRight(new BinaryTreeNode<Integer>());
	    assertTrue(!SymmetricBinaryTree.isSymmetricByPrint(nonSymmTree));
	    symmTree = new BinaryTreeNode<>();
	    symmTree.setLeft(new BinaryTreeNode<Integer>());
	    symmTree.setRight(new BinaryTreeNode<Integer>());
	    assertTrue(SymmetricBinaryTree.isSymmetricByPrint(symmTree));
	}

}
