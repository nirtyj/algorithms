package com.leetcode.common;

public class Interval {
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public Interval() {
	}

	public int start;
	public int end;

	@Override
	public String toString() {
		return "[" + start + ", " + end + "]";
	}
}