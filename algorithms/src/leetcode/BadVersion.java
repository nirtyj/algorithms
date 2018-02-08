package leetcode;

public class BadVersion {

	int val;

	BadVersion(int badVersion) {
		val = badVersion;
	}

	private boolean isBadVersion(int i) {
		return (i >= val);
	}

	/**
	 * Leetcode verified
	 * @param n
	 * @return
	 */
	public int firstBadVersion(int n) {
		int start = 1, end = n;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (!isBadVersion(mid))
				start = mid + 1;
			else
				end = mid;
		}
		return start;
	}
}
