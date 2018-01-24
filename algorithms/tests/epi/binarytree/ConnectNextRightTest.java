package epi.binarytree;

import static org.junit.Assert.*;

import org.junit.Test;

import epi.binarytree.node.BinaryTreeNode;

public class ConnectNextRightTest {

	private static void simpleTest() {
		//     3
		//  2     5
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(3);
		root.left = new BinaryTreeNode<>(2);
		root.right = new BinaryTreeNode<>(5);
		ConnectNextRight.constructRightSibling(root);
		assertTrue(root.next == null);
		assertTrue(root.left.next == root.right);
		assertTrue(root.right.next == null);
	}

	@Test
	public void test() {
		simpleTest();
		//     3
		//  2     5
		// 1 7   4 6
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(3);
		root.left = new BinaryTreeNode<>(2);
		root.left.right = new BinaryTreeNode<>(7);
		root.left.left = new BinaryTreeNode<>(1);
		root.right = new BinaryTreeNode<>(5);
		root.right.left = new BinaryTreeNode<>(4);
		root.right.right = new BinaryTreeNode<>(6);
		ConnectNextRight.constructRightSibling(root);
		assertTrue(root.next == null);
		assertTrue(root.left.next == root.right);
		assertTrue(root.left.left.next == root.left.right);
		assertTrue(root.left.right.next == root.right.left);
		assertTrue(root.right.left.next == root.right.right);
	}

	private static void simpleTestRecursive() {
		//     3
		//  2     5
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(3);
		root.left = new BinaryTreeNode<>(2);
		root.right = new BinaryTreeNode<>(5);
		ConnectNextRight.constructRightSiblingRecursive(root);
		assertTrue(root.next == null);
		assertTrue(root.left.next == root.right);
		assertTrue(root.right.next == null);
	}

	@Test
	public void testRecursive() {
		simpleTestRecursive();
		//     3
		//  2     5
		// 1 7   4 6
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(3);
		root.left = new BinaryTreeNode<>(2);
		root.left.right = new BinaryTreeNode<>(7);
		root.left.left = new BinaryTreeNode<>(1);
		root.right = new BinaryTreeNode<>(5);
		root.right.left = new BinaryTreeNode<>(4);
		root.right.right = new BinaryTreeNode<>(6);
		ConnectNextRight.constructRightSiblingRecursive(root);
		assertTrue(root.next == null);
		assertTrue(root.left.next == root.right);
		assertTrue(root.left.left.next == root.left.right);
		assertTrue(root.left.right.next == root.right.left);
		assertTrue(root.right.left.next == root.right.right);
	}

}
