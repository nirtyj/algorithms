package leetcode;

public class FindCelebrity {
	// dummy implementation
	boolean knows(int a, int b) {
		return false;
	}

	/**
	 * Leetcode verifed
	 * @param n
	 * @return
	 */
	public int findCelebrity(int n) {
		int candidate = 0;
		// find the candidate. 
		// if someone doesnt know a candidate, they are not a candidate. but someone could be a candidate
		// so switch for the candidate
		for (int i = 1; i < n; i++) {
			if (knows(candidate, i))
				candidate = i;
		}
		// validate if the candidate is real
		// if !(that candidate should not know i, or others should know candidate) - there is no candidate
		for (int i = 0; i < n; i++) {
			if (i != candidate && (knows(candidate, i) || !knows(i, candidate)))
				return -1;
		}
		return candidate;
	}
}
