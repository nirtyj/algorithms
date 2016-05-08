package epi.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNextRight {

	public void connect(BinaryTreeNode<Integer> root) {
	    if(root == null) 
	        return;
	    
	    Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
	    queue.add(root);
	    recurseHelper(queue);
	}

	private void recurseHelper(Queue<BinaryTreeNode<Integer>> queue) {
		Queue<BinaryTreeNode<Integer>> subqueue = new LinkedList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> prev = null;
		while(!queue.isEmpty())
	    {
			BinaryTreeNode<Integer> curr = queue.poll();
	    	if(prev != null)
	    	{
	    		prev.setSibling(curr);
	    	}
	    	prev = curr;	
	    	if(curr.left!=null)	
	        	subqueue.add(curr.left);
	        if(curr.right!=null)	
	    	    subqueue.add(curr.right);
	    }
	    
		if(!subqueue.isEmpty())
			recurseHelper(subqueue);
	}
}
