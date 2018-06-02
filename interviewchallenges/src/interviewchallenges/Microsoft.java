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
	  
}
