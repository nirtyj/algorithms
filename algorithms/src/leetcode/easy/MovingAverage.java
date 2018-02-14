package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
*/
public class MovingAverage {

	Queue<Integer> array = new LinkedList<Integer>();
	int previousSum = 0;
	int size;

	/** Leetcode verified */
	public MovingAverage(int size) {
		this.size = size;
	}

	public double next(int val) {
		if (array.size() < size) {
			array.add(val);
			previousSum = previousSum + val;
			return (double) previousSum / array.size();
		} else {
			Integer old = array.remove();
			previousSum = previousSum - old;
			array.add(val);
			previousSum = previousSum + val;
			return (double) previousSum / array.size();
		}
	}
}
