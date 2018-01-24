package epi.binarytree;

import java.util.ArrayList;
import java.util.List;

import epi.binarytree.node.BinaryTreeNode;

public class BinaryTreeUtils {

	public static <T extends Comparable<?>> List<BinaryTreeNode<T>> getTreeAsList(T[] values) {
		List<BinaryTreeNode<T>> list = new ArrayList<BinaryTreeNode<T>>();
		for (T val : values) {
			BinaryTreeNode<T> node = null;
			if (val != null)
				node = new BinaryTreeNode<T>(val, null, null, null);
			list.add(node);
		}
		for (int i = 0; i < list.size(); i++) {
			BinaryTreeNode<T> node = list.get(i);
			if (node == null)
				continue;
			if (i != 0) {
				int parentIndex = (i - 1) / 2;
				node.setParent(list.get(parentIndex));
			}
			if ((i * 2) + 1 < (list.size()))
				node.setLeft(list.get((i * 2) + 1));
			if ((i * 2) + 2 < (list.size()))
				node.setRight(list.get((i * 2) + 2));
		}
		return list;
	}
	
	public static <T extends Comparable<T>> BinaryTreeNode<T> buildTree(T[] values) {
		return getTreeAsList(values).get(0);
	}
	
	
	public static Integer[] getTreeListAsArray(List<BinaryTreeNode<Integer>> nlist)
	{
		Integer[] intarr = new Integer[nlist.size()];
		
		for(int i=0;i<nlist.size();i++)
			intarr[i] = nlist.get(i).getData();
		return intarr;
	}
}
