package epi.binarytree;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindSuccessorTest {

	@Test
	public void test() {
		//    3
	    //  2   5
	    // 1   4 6
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(3, null, null);
	    assertTrue(FindSuccessorInBST.findSuccessorWithParent(root) == null);
	    root.left = new BinaryTreeNode<Integer>(2, null, null);
	    root.left.parent = root;
	    assertTrue(FindSuccessorInBST.findSuccessorWithParent(root.left).data == 3);

	    root.left.left = new BinaryTreeNode<Integer>(1, null, null);
	    root.left.left.parent = root.left;
	    assertTrue(FindSuccessorInBST.findSuccessorWithParent(root.left).data == 3);
	    assertTrue(FindSuccessorInBST.findSuccessorWithParent(root.left.left).data == 2);

	    root.right = new BinaryTreeNode<Integer>(5, null, null);
	    root.right.parent = root;
	    root.right.left = new BinaryTreeNode<Integer>(4, null, null);
	    root.right.left.parent = root.right;
	    root.right.right = new BinaryTreeNode<Integer>(6, null, null);
	    root.right.right.parent = root.right;
	    // should output 6
	    BinaryTreeNode<Integer> node = FindSuccessorInBST.findSuccessorWithParent(root.right);
	    assertTrue(node.data.equals(6));
	    System.out.println(node.data);
	    // should output "null"
	    node = FindSuccessorInBST.findSuccessorWithParent(root.right.right);
	    assertTrue(node == null);
	}

}
