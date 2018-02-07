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
public class BinaryTreeVerticalOrderTraversal {

	int minKey = 0;
	int maxKey = 0;
	Map<Integer, List<Integer>> map = new HashMap<>();

	private static class NodeDeviation {
		TreeNode node;
		int deviation;

		public NodeDeviation(TreeNode tnode, int deviation) {
			this.node = tnode;
			this.deviation = deviation;
		}
	}

	public List<List<Integer>> verticalOrder(TreeNode root) {
		if (root == null)
			return Collections.emptyList();

		minKey = 0;
		maxKey = 0;
		map.clear();

		Queue<NodeDeviation> queue = new LinkedList<NodeDeviation>();
		queue.add(new NodeDeviation(root, 0));

		while (!queue.isEmpty()) {
			NodeDeviation nd = queue.poll();
			TreeNode node = nd.node;
			int deviation = nd.deviation;
			if (map.containsKey(deviation)) {
				List<Integer> val = map.get(deviation);
				val.add(node.val);
			} else {
				if (deviation < minKey)
					minKey = deviation;
				else if (deviation > maxKey)
					maxKey = deviation;

				List<Integer> vals = new ArrayList<>();
				vals.add(node.val);
				map.put(deviation, vals);
			}
			if (node.left != null) {
				queue.add(new NodeDeviation(node.left, deviation - 1));
			}

			if (node.right != null) {
				queue.add(new NodeDeviation(node.right, deviation + 1));
			}
		}

		List<List<Integer>> result = new ArrayList<>();
		for (int i = minKey; i <= maxKey; i++) {
			result.add(map.get(i));
		}
		return result;
	}
}