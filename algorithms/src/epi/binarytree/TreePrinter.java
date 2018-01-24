package epi.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import epi.binarytree.node.BinaryTreeNode;

public class TreePrinter<T extends Comparable<?>> {
	
		private static final Pattern END_OF_LINE_WHITESPACE = Pattern.compile("\\s+$");
	    public BinaryTreeNode<T> root;

	    public TreePrinter(BinaryTreeNode<T> root) {
	        this.root = root;
	    }

	    private static <T extends Comparable<?>> int getMaximumHeight(BinaryTreeNode<T> node) {
	        if (node == null)
	            return 0;
	        int leftHeight = getMaximumHeight(node.left);
	        int rightHeight = getMaximumHeight(node.right);
	        return (leftHeight > rightHeight) ? leftHeight + 1 : rightHeight + 1;
	    }

	    private static String multiplyString(String string, int times) {
	        StringBuilder builder = new StringBuilder(string.length() * times);
	        for (int i = 0; i < times; ++i) {
	            builder.append(string);
	        }
	        return builder.toString();
	    }

	    public static String getStartingSpace(int height) {
	        return multiplyString("  ", ((int) Math.pow(2, height - 1)) / 2);
	    }

	    public static String getUnderScores(int height) {
	        int noOfElementsToLeft = ((int) Math.pow(2, height) - 1) / 2;
	        int noOfUnderScores = noOfElementsToLeft
	                - ((int) Math.pow(2, height - 1) / 2);

	        return multiplyString("__", noOfUnderScores);
	    }

	    public static String getSpaceBetweenTwoNodes(int height) {
	        if (height == 0)
	            return "";

	        int noOfNodesInSubTreeOfNode = ((int) Math.pow(2, height - 1)) / 2;
	        /** Sum of spaces of the subtrees of nodes + the parent node */
	        int noOfSpacesBetweenTwoNodes = noOfNodesInSubTreeOfNode * 2 + 1;

	        return multiplyString("  ", noOfSpacesBetweenTwoNodes);
	    }

	    public static <T extends Comparable<?>> String printNodes(List<BinaryTreeNode<T>> queueOfNodes,
	            int noOfNodesAtCurrentHeight, int height) {
	    	
	        StringBuilder nodesAtHeight = new StringBuilder();

	        String startSpace = getStartingSpace(height);
	        String spaceBetweenTwoNodes = getSpaceBetweenTwoNodes(height);

	        String underScore = getUnderScores(height);
	        String underScoreSpace = multiplyString(" ", underScore.length());

	        nodesAtHeight.append(startSpace);
	        for (int i = 0; i < noOfNodesAtCurrentHeight; i++) {
	        	BinaryTreeNode<T> node = (BinaryTreeNode<T>) queueOfNodes.get(i);
	            if (node == null) {
	                nodesAtHeight.append(underScoreSpace)
	                        .append("  ")
	                        .append(underScoreSpace)
	                        .append(spaceBetweenTwoNodes);
	            } else {
	                nodesAtHeight
	                        .append(node.left != null ? underScore
	                                : underScoreSpace)
	                        .append(node.data==null? "Ni" :String.format("%2d", node.data))
	                        .append(node.right != null ? underScore
	                                : underScoreSpace)
	                        .append(spaceBetweenTwoNodes);
	            }
	        }

	        return END_OF_LINE_WHITESPACE.matcher(nodesAtHeight.toString()).replaceFirst("") + "\n";
	    }

	    public static String getSpaceBetweenLeftRightBranch(int height) {
	        int noOfNodesBetweenLeftRightBranch = ((int) Math.pow(2, height - 1) - 1);

	        return multiplyString("  ", noOfNodesBetweenLeftRightBranch);
	    }

	    public static String getSpaceBetweenRightLeftBranch(int height) {
	        int noOfNodesBetweenLeftRightBranch = (int) Math.pow(2, height - 1);

	        return multiplyString("  ", noOfNodesBetweenLeftRightBranch);
	    }

	    public static <T extends Comparable<?>> String printBranches(List<BinaryTreeNode<T>> queueOfNodes,
	            int noOfNodesAtCurrentHeight, int height) {
	        if (height <= 1)
	            return "";
	        StringBuilder brachesAtHeight = new StringBuilder();

	        String startSpace = getStartingSpace(height);
	        String leftRightSpace = getSpaceBetweenLeftRightBranch(height);
	        String rightLeftSpace = getSpaceBetweenRightLeftBranch(height);

	        brachesAtHeight
	                .append(startSpace.substring(0, startSpace.length() - 1));

	        for (int i = 0; i < noOfNodesAtCurrentHeight; i++) {
	        	BinaryTreeNode<T> node = queueOfNodes.get(i);
	            if (node == null) {
	                brachesAtHeight.append(" ")
	                        .append(leftRightSpace)
	                        .append(" ")
	                        .append(rightLeftSpace);
	            } else {
	                brachesAtHeight.append(node.left != null ? "/" : " ")
	                        .append(leftRightSpace)
	                        .append(node.right != null ? "\\" : " ")
	                        .append(rightLeftSpace);
	            }
	        }

	        return brachesAtHeight.toString().replaceFirst("\\s+$", "") + "\n";
	    }

	    public static <T extends Comparable<?>>  String prettyPrintTree(BinaryTreeNode<T> root) {
	        LinkedList<BinaryTreeNode<T>> queueOfNodes = new LinkedList<>();
	        int height = getMaximumHeight(root);
	        int level = 0;
	        int noOfNodesAtCurrentHeight = 0;

	        queueOfNodes.add(root);
	        StringBuilder b = new StringBuilder();

	        while (!queueOfNodes.isEmpty() && level < height) {
	            noOfNodesAtCurrentHeight = ((int) Math.pow(2, level));

	            b.append(printNodes(queueOfNodes, noOfNodesAtCurrentHeight, height - level));
	            b.append(printBranches(queueOfNodes, noOfNodesAtCurrentHeight, height - level));

	            for (int i = 0; i < noOfNodesAtCurrentHeight; i++) {
	            	BinaryTreeNode<T> currNode = queueOfNodes.peek();
	                queueOfNodes.remove();
	                if (currNode != null) {
	                    queueOfNodes.add(currNode.left);
	                    queueOfNodes.add(currNode.right);
	                } else {
	                    queueOfNodes.add(null);
	                    queueOfNodes.add(null);
	                }
	            }
	            level++;
	        }
	        return b.toString();
	    }
}
