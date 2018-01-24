package epi.binarytree;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import epi.binarytree.node.BinaryTreeNode;

public class ExteriorBinaryTreeTest {

	private static List<Integer> createOutputList(
		      List<BinaryTreeNode<Integer>> L) {
		    List<Integer> result = new ArrayList<Integer>();
		    for (BinaryTreeNode<Integer> l : L) {
		      result.add(l.data);
		    }
		    return result;
		  }
	@Test
	public void test() {
		 	BinaryTreeNode<Integer> tree = new BinaryTreeNode<>(3, null, null);
		    List<BinaryTreeNode<Integer>> L = ExteriorBinaryTree.exteriorBinaryTree(tree);
		    List<Integer> result = createOutputList(L);
		    List<Integer> goldenResult = Arrays.asList(3);
		    assertTrue(goldenResult.equals(result));

		    tree.left = new BinaryTreeNode<>(2, null, null);
		    L = ExteriorBinaryTree.exteriorBinaryTree(tree);
		    result = createOutputList(L);
		    goldenResult = Arrays.asList(3, 2);
		    assertTrue(goldenResult.equals(result));

		    tree.left.right = new BinaryTreeNode<>(0, null, null);
		    tree.left.right.left = new BinaryTreeNode<>(-1, null, null);
		    tree.left.right.right = new BinaryTreeNode<>(-2, null, null);
		    tree.left.left = new BinaryTreeNode<>(1, null, null);
		    tree.right = new BinaryTreeNode<>(5, null, null);
		    tree.right.left = new BinaryTreeNode<>(4, null, null);
		    tree.right.right = new BinaryTreeNode<>(6, null, null);
		    L = ExteriorBinaryTree.exteriorBinaryTree(tree);
		    result = createOutputList(L);
		    goldenResult = Arrays.asList(3, 2, 1, -1, -2, 4, 6, 5);
		    assertTrue(goldenResult.equals(result));
	}

}
