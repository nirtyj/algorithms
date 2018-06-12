package com.leetcode.trees;

import static org.junit.Assert.*;

import org.junit.Test;

import com.leetcode.common.TreeNode;

public class LargestBSTSubTreeTest {

	@Test
	public void test() {
		LargestBSTSubTree_333 t = new LargestBSTSubTree_333();
		TreeNode root = new TreeNode(10);
		
		TreeNode n5 = new TreeNode(5);
		
		TreeNode n1 = new TreeNode(1);
		TreeNode n8 = new TreeNode(8);
		
		TreeNode n15 = new TreeNode(15);
		
		TreeNode n7 = new TreeNode(7);
		
		root.left = n5;
		root.right = n15;
		n5.left = n1;
		n5.right = n8;
		n15.right = n7;
		assertEquals(3, t.largestBSTSubtree(root));
	}
	
	@Test
	public void test2() {
		LargestBSTSubTree_333 t = new LargestBSTSubTree_333();
		TreeNode root = new TreeNode(1);
		
		TreeNode n3 = new TreeNode(3);
	
		TreeNode n4 = new TreeNode(4);
		TreeNode n2 = new TreeNode(2);
		
		TreeNode n5 = new TreeNode(5);
		
		root.left = n3;
		root.right = n2;
		n3.left = n4;
		n2.right = n5;
		assertEquals(2, t.largestBSTSubtree(root));
	}
	
	@Test
	public void test3() {
		LargestBSTSubTree_333 t = new LargestBSTSubTree_333();
		TreeNode root = new TreeNode(4);
		
		TreeNode n1 = new TreeNode(1);
	
		TreeNode n6 = new TreeNode(6);
		
		TreeNode n5 = new TreeNode(5);
		
		TreeNode n2 = new TreeNode(2);
		
		root.left = n1;
		root.right = n6;
		n6.left = n5;
		n5.left = n2;
		assertEquals(3, t.largestBSTSubtree(root));
	}

}
