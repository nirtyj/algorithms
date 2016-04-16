package epi.hashtables;

import java.util.HashSet;
import java.util.Set;

import epi.binarytree.Node;

public class LCAWithHash {

	public Node findLca(Node node1, Node node2)
	{
		Set<Node> set = new HashSet<Node>();
		while (node1 != null || node2 != null) 
		{
			if(node1 !=null)
			{
				if (set.contains(node1)) {
					return node1;
				} else {
					set.add(node1);
					node1 = node1.parent;
				}
			}
			
			if (set.contains(node2)) {
				return node2;
			} else {
				set.add(node2);
				node1 = node2.parent;
			}
		}
		throw new IllegalArgumentException("No LCA found");
	}
}
