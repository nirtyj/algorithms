package interviewchallenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Microsoft {

	/**
	 * Online coding challenge
	 * 1. Rotate Image to 270 degrees
	 * 2. Shortest distances between two words in a file
	 * 3. Difference between Iaas, Paas, Saas
	 * 4. Actor to Actor links. find what's wrong. Make it production ready.
	 */
	
	private static Map<String, ArrayList<Integer>> locations = new HashMap<String, ArrayList<Integer>>();
	 
	private static void storeLocations(String[] text) {
	    for (int i = 0; i < text.length; ++i) {
	        String word = text[i];
	        if (locations.keySet().contains(word)) {
	            ArrayList<Integer> location = locations.get(word);
	            location.add(i);
	            locations.put(word, location);
	        } else {
	            ArrayList<Integer> location = new ArrayList<Integer>();
	            location.add(i);
	            locations.put(word, location);
	        }
	    }
	}
	 
	private static int modified_binary_search(ArrayList<Integer> array,
	        int target) {
	    int low = 0;
	    int high = array.size();
	    while (low < high) {
	        int mid = low + (high - low) / 2;
	        if (target == array.get(mid))
	            return target;
	        if (target < array.get(mid))
	            high = mid;
	        else
	            low = mid + 1;
	    }
	    if (low >= 0 && low < array.size())
	        return array.get(low);
	    else
	        return array.get(array.size() - 1);
	}
	 
	private static int shortest_distance(String a, String b) {
	    int min = Integer.MAX_VALUE;
	    for (int index_a : locations.get(a)) {
	        ArrayList<Integer> array = locations.get(b);
	        int nearest_index_b = modified_binary_search(array, index_a);
	        int distance = Math.abs(nearest_index_b - index_a);
	        if (distance < min)
	            min = distance;
	    }
	    return min;
	}
	  
	/**
	 * Onsite 4 rounds
	 *  data structures knowledge, problem solving, past experience and learnability.
	 *  Two system design, two coding interviews.  
	 *  Set the next node of a Binary Tree, being the node to its left on the same height.  
	 *  Deeply clone a singly linked list in which each node has an extra pointer that points to a random node.  
	 *  few array/string manipulation questions 
	 *  closest common ancestors to 2 nodes in a n-ary tree.  
	 *  Reverse words in a sentence.
	 *  Given root node to a binary tree, reconstruct it and return its root node  
	 *  Given 2d matrix and a string. Write a function to check if string is contained in the 2d matrix  
	 *  Run length encoding, write compression function given input array and output array of bytes
	 *  
	 *  - Design an API for searching for contact information.
		- Choose a data structure for search function
		- Implement search function 
		
		Why Microsoft
		 arrays, linked lists, strings, etc. 
		 string traversal, arrays + math 
		
		Given a list of n unsorted key-value tuples which are too large to fit in memory, return the k tuples with the greatest value where n is several orders of magnitude greater than k. This list may be dispersed across multiple machines.  
		Given a tree of order n which is neither complete or a search tree, write a function to construct a new tree of order m in-place. Memory usage is bound to 2 times the size of the tree. The new tree must be complete, and a node A cannot be a child of another node B in the new tree if A was an ancestor of B in the old tree.  
		Given a list of movement commands (up, down, left, right, undo previous action), write a function that returns the final (x,y) coordinate. Followup: how would you handle other kinds of commands and undoing them? What kind of design pattern is this?  
		Given two very large timestamped sorted log files that do not fit in memory (possibly on different machines), merge them in timestamp order. Provide some test cases.  

		Describe how you would design a data experimentation platform.  
		DP and Backtracking
		multi threading and distributed systems.
		Given 4 coins of values 1, 5, 10, and 20, find all the combinations of coins that can add up to K.  
		Print out all the nodes in a binary in order without recursion.  
		Return the longest palindromic substring. 
		Print nodes in balanced tree level by level and reversing the print order every other level.  
		Get k largest elements in a list, extremely large list (doesn't fit in memory), write actual test cases.  
		Find the common ancestor in a binary tree.
		Given the head of a linked list, write a program in your language of choice to return the middle node of the list.
		 two rectangles overlap
		 Implement a LRU cache.  
		 Find max continuous sum in array?
		 next larger element in a BST.
		 Simple design questions like messaging and elevator controller
		 two strings are anagrams
	 */
	
	/**
	 * Onsite Interview 
	 * 
	    Round 1
	    Braces match use stack to implement
		Use constant variable.
		What about two different braces
		Two different braces with const not possible 
		Use stack. 
		How to do logger for that. File logging 
		Console logging.
		.Logger design with database. Collector interface
	    Implement Math.Sqrt
		Expose this as library. Not a service. 
		What about multiple threads using the same method. Synchronized
		Implement key value database as service.
		
		
		Round 2
		Is bst. 
		Count how many elements that are violation. Of the bst property.
		Max of left and pass it to the right. Return up the max of right 
		
		Round 3
		one child is boy.
		Probability of other is a girl
		Boy born on a Tuesday
		Load balancer question startergies to distribute.
		Hashcode on url. So that's caching can be effective for those application pages 
		Client server not responding. How to back off. Exponential back off. Randomized backoff 
		Retry.
		Multiple clients. Then Randomized jitter with exponential.
		Clone graph.
		 Dfs. Bfs.
		
		Round 4:
		Implement Math.Sqrt
		Expose this as library. Not a service. 
		What about multiple threads using the same method. Synchronized
		Implement key value database as service.
		
		Edit distance
	 */
}
