package epi.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import epi.binarytree.node.TreeNode;

public class BinaryTreePaths {

	List<String> result = new ArrayList<>();

	/**
	 * Leetcode verified
	 * @param root
	 * @return
	 */
	public List<String> binaryTreePaths(TreeNode root) {
		if (root == null)
			return Collections.emptyList();
		result.clear();
		binaryTreePaths(root, new ArrayList<>());
		return result;
	}

	public void binaryTreePaths(TreeNode root, List<String> current) {
		if (root == null)
			return;

		current.add(Integer.toString(root.val));

		if (root.left == null && root.right == null) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < current.size(); i++) {
				String s = current.get(i);
				if (i == current.size() - 1) {
					sb.append(s);
				} else {
					sb.append(s + "->");
				}

			}
			result.add(sb.toString());
			current.remove(current.size() - 1);
			return;
		}

		binaryTreePaths(root.left, current);
		binaryTreePaths(root.right, current);

		current.remove(current.size() - 1);
	}
}
