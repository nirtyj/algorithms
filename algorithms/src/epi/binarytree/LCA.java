package epi.binarytree;

public class LCA {

	static class LcaData {
		boolean n1found;
		boolean n2found;
		BinaryTreeNode<Integer> lca;
		int val;

		LcaData() {
		}

		LcaData(boolean n1found, boolean n2found, BinaryTreeNode<Integer> lca) {
			this.n1found = n1found;
			this.n2found = n2found;
			this.lca = lca;
		}
	}

	public static BinaryTreeNode<Integer> findLCA(BinaryTreeNode<Integer> tree, BinaryTreeNode<Integer> node1,
			BinaryTreeNode<Integer> node2) {

		if (tree == null || tree == node1 || tree == node2)
			return tree;

		BinaryTreeNode<Integer> left = findLCA(tree.left, node1, node2);
		BinaryTreeNode<Integer> right = findLCA(tree.right, node1, node2);
		if (left != null && right != null)
			return tree;
		return left != null ? left : right;
	}

	public BinaryTreeNode<Integer> lowestCommonAncestorBST(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> p,
			BinaryTreeNode<Integer> q) {
		BinaryTreeNode<Integer> m = root;

		if (m.data > p.data && m.data < q.data) {
			return m;
		} else if (m.data > p.data && m.data > q.data) {
			return lowestCommonAncestorBST(root.left, p, q);
		} else if (m.data < p.data && m.data < q.data) {
			return lowestCommonAncestorBST(root.right, p, q);
		}

		return root;
	}

	public static BinaryTreeNode<Integer> findLCALong(BinaryTreeNode<Integer> tree, BinaryTreeNode<Integer> node1,
			BinaryTreeNode<Integer> node2) {
		LcaData data = LCAHelper(tree, node1, node2);
		return data.lca;
	}

	private static LcaData LCAHelper(BinaryTreeNode<Integer> tree, BinaryTreeNode<Integer> node1,
			BinaryTreeNode<Integer> node2) {

		if (tree == null)
			return new LcaData(false, false, null);

		LcaData data = new LcaData();

		if (node1 == tree)
			data.n1found = true;
		else if (node2 == tree)
			data.n2found = true;

		if (data.n1found == false || data.n2found == false) {
			LcaData leftData = LCAHelper(tree.getLeft(), node1, node2);
			if (leftData.n1found && leftData.n2found)
				return leftData;

			LcaData rightData = LCAHelper(tree.getRight(), node1, node2);
			if (rightData.n1found && rightData.n2found)
				return rightData;

			data.n1found = data.n1found || leftData.n1found || rightData.n1found;
			data.n2found = data.n2found || leftData.n2found || rightData.n2found;
		}

		if (data.n1found && data.n2found) {
			data.lca = tree;
		}
		return data;
	}

	public static BinaryTreeNode<Integer> findLCAWithParent(BinaryTreeNode<Integer> node1,
			BinaryTreeNode<Integer> node2) {
		int depthOfN1 = getDepthInTree(node1);
		int depthOfN2 = getDepthInTree(node2);

		if (depthOfN1 != depthOfN2) 
		{
			int diff = Math.abs(depthOfN1 - depthOfN2);
			while (diff != 0) {
				if(depthOfN1 > depthOfN2)
				{
					node1 = node1.getParent();
				}else
				{
					node2 = node2.getParent();
				}
				diff--;
			}
		}

		while (node1 != node2 && node1 != null && node2 != null) {
			node1 = node1.getParent();
			node2 = node2.getParent();
		}
		
		return node1;
	}

	public static int getDepthInTree(BinaryTreeNode<Integer> node1) {
		int depth = 0;
		while(node1!=null)
		{
			node1 = node1.parent;
			depth++;
		}
		return depth;
	}

}
