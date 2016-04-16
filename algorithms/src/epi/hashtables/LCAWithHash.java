package epi.hashtables;

import java.util.HashSet;
import java.util.Set;

import epi.binarytree.BinaryTreeNode;

public class LCAWithHash {

	public BinaryTreeNode<Integer> findLca(BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2)
	{
		Set<BinaryTreeNode<Integer>> set = new HashSet<BinaryTreeNode<Integer>>();
		while (node1 != null || node2 != null) 
		{
			if(node1 !=null)
			{
				if (set.contains(node1)) {
					return node1;
				} else {
					set.add(node1);
					node1 = node1.getParent();
				}
			}
			
			if (set.contains(node2)) {
				return node2;
			} else {
				set.add(node2);
				node1 = node2.getParent();
			}
		}
		throw new IllegalArgumentException("No LCA found");
	}
}
