package epi.binarytree;

public class MaxHeightInTree {

	public static int getMaxHeight(BinaryTreeNode<Integer> tree)
	{
		if(tree == null)
			return 0;
		
		return Math.max(getMaxHeight(tree.getLeft()), getMaxHeight(tree.getRight())) + 1;		
	}	
}
