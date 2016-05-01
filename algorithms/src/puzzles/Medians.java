package puzzles;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class Medians {

	public static int findMedian(List<Integer> arr) {
		return medianHelper(arr, 0, arr.size() - 1);
	}

	private static int medianHelper(List<Integer> arr, int start, int end) {
		Random r = new Random(0);
		while (start <= end) {

			int newPivotIndex = start + r.nextInt(end - start + 1);
			int newPivotIdx = partitionAroundPivot(arr, newPivotIndex, start, end);
			if (newPivotIdx == arr.size() / 2) {
				return arr.get(newPivotIdx);
			} else if (newPivotIdx < arr.size() / 2) {
				start = newPivotIndex + 1;
			} else {
				end = newPivotIndex - 1;
			}
		}
		throw new NoSuchElementException();
	}

	private static int partitionAroundPivot(List<Integer> A, int pivotIndx, int start, int end) {

		int pivotVal = A.get(pivotIndx);
		int newPivotIndex = start;
		Collections.swap(A, end, pivotIndx);
		for(int i= start; i<end;i++)
		{
			if(A.get(i)>pivotVal)
				Collections.swap(A, i, newPivotIndex++);
		}
		Collections.swap(A, end, newPivotIndex);
		return newPivotIndex;
	}
}
