package epi.binarytree;

/**
https://careercup.com/question?id=5089243010433024
You have a binary tree which consists of 0 or 1 in the way, that each node value is a LOGICAL AND between its children:


	 0
   /   \
  0     1
 / \   / \
0   1  1  1
You need to write a code, which will invert given LEAF and put tree in a correct state.

*/
public class LogicalAndTree {

	private static class Node {
		int data;
		Node left;
		Node right;
		Node(int data) {
			this.data = data;
		}
	}

	public static void convertTree(Node root)
	{
	    if (root.left == null && root.right == null)
	        return;
	 
	    /* first recur on left child */
	    convertTree(root.left);
	 
	    /* then recur on right child */
	    convertTree(root.right);
	 
	    if (root.left != null && root.right != null)
	    {
	        root.data = root.left.data & root.right.data;
	    }
	}
	
	public static void flipAndSetTree(Node root, Node element)
	{
		if(root == element)
			root.data = root.data == 0 ? 1 : 0;

	    if (root.left == null && root.right == null)
	        return;
	 
	 
	    /* first recur on left child */
	    flipAndSetTree(root.left,element);
	 
	    /* then recur on right child */
	    flipAndSetTree(root.right, element);
	 
	    if (root.left != null && root.right != null)
	    {
	        root.data = root.left.data & root.right.data;
	    }
	}
	
	static void printInorder(Node root)
	{
	    if (root == null)
	        return;
	 
	    /* first recur on left child */
	    printInorder(root.left);
	 
	    /* then print the data of node */
	    System.out.format("%d ", root.data);
	 
	    /* now recur on right child */
	    printInorder(root.right);
	}
	
	public static void main(String[] args)
	{
		    /* Create following Binary Tree
		             0
		           /   \
		          0     1
		         / \   / \
		        0   1 1   1
		             */
		 
		    Node root = new Node(0);
		    root.left=new Node(0);
		    root.right=new Node(1);
		    root.left.left=new Node(0);
		    root.left.right=new Node(1);
		    root.right.left=new Node(1);
		    root.right.right=new Node(1);
		    System.out.println("\n Inorder traversal before conversion ");
		    printInorder(root);
		 
		   // convertTree(root);
		 
		    flipAndSetTree(root, root.left.left);
		    System.out.println("\n Inorder traversal after conversion ");
		    printInorder(root);
	}
}

