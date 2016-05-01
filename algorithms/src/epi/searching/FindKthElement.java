package epi.searching;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class FindKthElement {

	public static int findKthLargest(List<Integer> A, int k) {
		return findKthLargestInner(A, 0, A.size() -1 , k);
	}

	public static int findKthLargestInner(List<Integer> A, int start, int end, int k) {
		Random r = new Random(0);
		while (start <= end) {
			// Generates a random integer in [left, right].
			int pivotIdx = start + r.nextInt(end - start + 1);
			int newPivotIdx = partitionAroundPivot(A, pivotIdx, start, end);
			if (newPivotIdx == A.size() - k) {
				return A.get(newPivotIdx);
			} else if (newPivotIdx > A.size() - k) {
				end = newPivotIdx - 1;				
			} else {
				start = newPivotIdx + 1;
			}
		}
		throw new NoSuchElementException("no k-th node in array A");
	}

	private static int partitionAroundPivot(List<Integer> A, int pivotIndx, int start, int end) {
		
		int pivotValue = A.get(pivotIndx);
	    int newPivotIdx = start;

	    Collections.swap(A, pivotIndx, end);
	    for (int i = start; i < end; ++i) {
	      if (A.get(i) < pivotValue) {
	        Collections.swap(A, i, newPivotIdx++);
	      }
	    }
	    Collections.swap(A, end, newPivotIdx);
	    return newPivotIdx;
	}

	public static int findKthSmallest(List<Integer> A, int k) {
		return findKthSmallestInner(A, 0, A.size() -1 , k);
	}
	
	public static int findKthSmallestInner(List<Integer> A, int start, int end, int k) {
		Random r = new Random(0);
		while (start <= end) {
			// Generates a random integer in [left, right].
			int pivotIdx = start + r.nextInt(end - start + 1);
			int newPivotIdx = partitionAroundPivot(A, pivotIdx, start, end);
			if (newPivotIdx ==  k - 1) {
				return A.get(newPivotIdx);
			} else if (newPivotIdx > k - 1) {
				end = newPivotIdx - 1;				
			} else {
				start = newPivotIdx + 1;
			}
		}
		throw new NoSuchElementException("no k-th node in array A");
	}
}
