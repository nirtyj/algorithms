package leetcode.hard;

import java.util.Arrays;
import java.util.LinkedList;

import epi.binarytree.node.TreeNode;

/**
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, 
or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm
should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original
tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format,
so please be creative and come up with different approaches yourself.
*/
public class SerializeAndDeserialzeBinaryTree {

	/**
	 * Leetcode verified
	 * @param root
	 * @return
	 */
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      String val="";
      if(root == null) return "null,";
      val+= root.val+ ",";
      val+=serialize(root.left);
      val+=serialize(root.right);
      return val;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    		LinkedList<String> nodes = new LinkedList<String>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }
  
    private TreeNode buildTree(LinkedList<String> nodes) {
      String val = nodes.remove();
      if(val.equals("null")) return null;
      TreeNode node = new TreeNode(Integer.parseInt(val));
      node.left = buildTree(nodes);
      node.right = buildTree(nodes);
      return node;
    }
}