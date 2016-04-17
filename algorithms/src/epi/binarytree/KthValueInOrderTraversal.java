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
