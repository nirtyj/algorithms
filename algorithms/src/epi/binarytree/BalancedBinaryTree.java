package epi.binarytree;

import epi.binarytree.node.BinaryTreeNode;

public class BalancedBinaryTree {

	static class BalancedData {
		int height;
		boolean balanced;

		BalancedData(int height, boolean balanced) {
			this.height = height;
			this.balanced = balanced;
		}
	}

	public static boolean isBalanced(BinaryTreeNode<Integer> tree) {
		return checkBalance(tree).balanced;
	}

	private static BalancedData checkBalance(BinaryTreeNode<Integer> node) {
		if (node == null) {
			return new BalancedData(0, true);
		} else {
			BalancedData leftBalanced = checkBalance(node.getLeft());
			if (leftBalanced.balanced == false) {
				return leftBalanced;
			}

			BalancedData rightBalanced = checkBalance(node.getRight());
			if (rightBalanced.balanced == false) {
				return rightBalanced;
			}

			BalancedData currentBalance = new BalancedData(Math.max(leftBalanced.height, rightBalanced.height) + 1,
					Math.abs(leftBalanced.height - rightBalanced.height) <= 1);
			return currentBalance;
		}
	}

}
