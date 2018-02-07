package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import epi.binarytree.node.TreeNode;

/**
 * Leetcode verified
 * @author njaganathan
 *
 */
public class BinaryTreeLevelOrderTraversal {
	Map<Integer, List<Integer>> map = new HashMap<>();

	int maxHeight = 0;

	private static class NodeHeight {
		TreeNode node;
		int height;

		public NodeHeight(TreeNode tnode, int height) {
			this.node = tnode;
			this.height = height;
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null)
			return Collections.emptyList();

		map.clear();

		Queue<NodeHeight> queue = new LinkedList<NodeHeight>();
		queue.add(new NodeHeight(root, 0));

		while (!queue.isEmpty()) {
			NodeHeight nd = queue.poll();
			TreeNode node = nd.node;
			int height = nd.height;
			if (map.containsKey(height)) {
				List<Integer> val = map.get(height);
				val.add(node.val);
			} else {
				if (height > maxHeight)
					maxHeight = height;
				List<Integer> vals = new ArrayList<>();
				vals.add(node.val);
				map.put(height, vals);
			}
			if (node.left != null) {
				queue.add(new NodeHeight(node.left, height + 1));
			}

			if (node.right != null) {
				queue.add(new NodeHeight(node.right, height + 1));
			}
		}

		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i <= maxHeight; i++) {
			result.add(map.get(i));
		}
		return result;
	}
}
