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
	    assertTrue(FindSuccessor.findSuccessor(root) == null);
	    root.left = new BinaryTreeNode<Integer>(2, null, null);
	    root.left.parent = root;
	    assertTrue(FindSuccessor.findSuccessor(root.left).data == 3);

	    root.left.left = new BinaryTreeNode<Integer>(1, null, null);
	    root.left.left.parent = root.left;
	    assertTrue(FindSuccessor.findSuccessor(root.left).data == 3);
	    assertTrue(FindSuccessor.findSuccessor(root.left.left).data == 2);

	    root.right = new BinaryTreeNode<Integer>(5, null, null);
	    root.right.parent = root;
	    root.right.left = new BinaryTreeNode<Integer>(4, null, null);
	    root.right.left.parent = root.right;
	    root.right.right = new BinaryTreeNode<Integer>(6, null, null);
	    root.right.right.parent = root.right;
	    // should output 6
	    BinaryTreeNode<Integer> node = FindSuccessor.findSuccessor(root.right);
	    assertTrue(node.data.equals(6));
	    System.out.println(node.data);
	    // should output "null"
	    node = FindSuccessor.findSuccessor(root.right.right);
	    assertTrue(node == null);
	}

}
