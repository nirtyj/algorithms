package epi.recursion;

import java.util.ArrayList;
import java.util.List;

import epi.binarytree.BinaryTreeNode;

public class GenerateBinaryTrees {

	public static List<BinaryTreeNode<Integer>> generateAllBinaryTrees(int numNodes) {
		List<BinaryTreeNode<Integer>> result = new ArrayList<>();
		// Empty tree, add as an essential to make left = null & iterate through right nodes
		if (numNodes == 0) { 
			result.add(null);
		}
		
		/**
		  0=>   0__
			         \
			          0
			           \
			            0
		            
		            0__
			            \
			             0
			           /
			           0
		   1=>    0
				 /  \
				 0   0
				 
		   2 => 	 __ 0
				   /
				   0
				    \
				     0
 				    __ 0
				   /
				   0
				 /
				 0		
		 */
	            
		for (int numLeftTreeNodes = 0; numLeftTreeNodes < numNodes; ++numLeftTreeNodes) {
			int numRightTreeNodes = numNodes - 1 - numLeftTreeNodes;
			List<BinaryTreeNode<Integer>> leftSubtrees = generateAllBinaryTrees(numLeftTreeNodes);
			List<BinaryTreeNode<Integer>> rightSubtrees = generateAllBinaryTrees(numRightTreeNodes);
			// Generates all combinations of leftSubtrees and rightSubtrees.
			for (BinaryTreeNode<Integer> left : leftSubtrees) {
				for (BinaryTreeNode<Integer> right : rightSubtrees) {
					result.add(new BinaryTreeNode<>(0, left, right));
				}
			}
		}
		return result;
	}
}
