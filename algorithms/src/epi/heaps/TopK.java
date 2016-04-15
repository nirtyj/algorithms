package epi.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class TopK {

	List<String> findKLongestStrings( int k, Iterator<String> inputStream)
	{
		PriorityQueue<String> minHeap = new PriorityQueue<String>(k, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		});
		
		while(inputStream.hasNext())
		{
			minHeap.add(inputStream.next());
			if(minHeap.size()>k)
			{
				minHeap.poll();	
			}
		}
		return new ArrayList<String>(minHeap);
	}
}
