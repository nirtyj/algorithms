package epi.binarysearchtree;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import epi.binarytree.BinaryTreeTraversals;
import epi.binarytree.BinaryTreeUtils;
import epi.binarytree.node.BinaryTreeNode;
import epi.linkedlist.LinkedListNode;

public class SortedLinkedListToHeightBalanedBSTTest {

	@Test
	public void test() {
		LinkedListNode L = new LinkedListNode(1, new LinkedListNode(2, new LinkedListNode(3, new LinkedListNode(4,  new LinkedListNode(5, new LinkedListNode(6, null))))));
		BinaryTreeNode<Integer> result = SortedLinkedListToHeightBalanedBST.sortedListToBST(L);
		Integer[] resultarr = {1, 2 ,3, 4, 5, 6};
		assertTrue(Arrays.equals(resultarr, BinaryTreeUtils.getTreeListAsArray(BinaryTreeTraversals.getInOrderTraversal(result))));
	}
}
