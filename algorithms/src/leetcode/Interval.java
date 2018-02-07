package leetcode;

public class Interval {
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	protected int start;
	protected int end;

	@Override
	public String toString() {
		return "[" + start + ", " + end + "]";
	}
}