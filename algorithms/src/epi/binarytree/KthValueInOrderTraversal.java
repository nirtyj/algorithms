package epi.binarytree;

import java.util.ArrayList;
import java.util.List;

public class KthValueInOrderTraversal {

	public static BinaryTreeNode<Integer> findKthValue(BinaryTreeNode<Integer> root, Integer k) {
		List<Integer> tracker = new ArrayList<Integer>(1);
		tracker.add(0);
		return kthValueHelper(root, tracker, k);
	}

	private static BinaryTreeNode<Integer> kthValueHelper(BinaryTreeNode<Integer> root, List<Integer> val, int desiredKey) 
	{
		if (root == null)
			return null;

		BinaryTreeNode<Integer> foundInLeft = kthValueHelper(root.left, val, desiredKey);
		if (foundInLeft != null)
			return foundInLeft;

		val.set(0, val.get(0) + 1);

		if (val.get(0) == desiredKey)
			return root;

		BinaryTreeNode<Integer> foundInRight = kthValueHelper(root.right, val, desiredKey);

		return foundInRight;
	}
	
	/**
	 * Leet code accepted & verified
	 * @param root
	 */
	public int kthSmallest(BinaryTreeNode<Integer> root, int k) {
		int[] current = new int[1];
		BinaryTreeNode<Integer> node = inOrder(root, k, current);
		if (node != null)
			return node.data;
		return 0;
	}

	private BinaryTreeNode<Integer> inOrder(BinaryTreeNode<Integer> root, int k, int[] current) {
		if (root == null)
			return null;
		if (current[0] == k)
			return root;

		BinaryTreeNode<Integer> leftFound = inOrder(root.left, k, current);
		if (leftFound != null)
			return leftFound;

		current[0] = current[0] + 1;
		if (current[0] == k)
			return root;

		return inOrder(root.right, k, current);
	}
	
	 /**
		    8
		 6      10
		5  7      9
		
		k is 0
		k is 2
		8.s ~ 3
		10.s ~ 1
		5.s 0
		[5, 6,7  8, 9, 10]
	*/
	public static BinaryTreeNode<Integer> findKthValueWithS(BinaryTreeNode<Integer> root, Integer k) {
		if(root == null)
			return null;
		
		int remain = k - root.getNodesInLeftSubTree();
		if(remain == 0)
			return root;
		else if(remain < 0)
			return findKthValueWithS(root.left, k);
		else
			return findKthValueWithS(root.right, remain -1);
	}
	
}
