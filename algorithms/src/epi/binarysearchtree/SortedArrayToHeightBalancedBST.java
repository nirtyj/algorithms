package epi.binarysearchtree;

import epi.binarytree.BinaryTreeNode;

public class SortedArrayToHeightBalancedBST {

	/**
	 * Leet code verified and accepted
	 * @param nums
	 * @return
	 */
	public BinaryTreeNode<Integer> sortedArrayToBST(int[] nums) {
        if(nums == null)
            return null;
       return helper(nums, 0, nums.length -1);
    }
    
    private BinaryTreeNode<Integer> helper(int[] nums, int i, int j)
    {
        if(j<0 || i>j || i>nums.length-1)
            return null;
            
        if(i==j)
        {
            return new BinaryTreeNode<Integer>(nums[i]);
        }
        
        int mid = i + (j-i)/2;
        BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(nums[mid]);
        node.left = helper(nums, i, mid-1);
        node.right = helper(nums, mid +1, j);
        return node;
    }
}
