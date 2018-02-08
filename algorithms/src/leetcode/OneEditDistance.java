package leetcode;

/**
 * Leetcode verified
 * @author njaganathan
 *
 */
public class OneEditDistance {
	public boolean isOneEditDistance(String s, String t) {
		// if lengths differ more than 1 - false
		if (Math.abs(s.length() - t.length()) > 1)
			return false;
		
		// if length is equal, its modify
		if (s.length() == t.length())
			return isOneModify(s, t);
		
		// if s is greater than t by 1, its deleted
		if (s.length() > t.length())
			return isOneDel(s, t);
		
		// if s is less than t by 1, its added
		return isOneDel(t, s);
	}

	// if you hit a mismatch, see others match except that character
	public boolean isOneDel(String s, String t) {
		for (int i = 0, j = 0; i < s.length() && j < t.length(); i++, j++) {
			if (s.charAt(i) != t.charAt(j)) {
				return s.substring(i + 1).equals(t.substring(j));
			}
		}
		return true;
	}

	// mofify, count number of unequals
	public boolean isOneModify(String s, String t) {
		int diff = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != t.charAt(i))
				diff++;
		}
		return diff == 1;
	}
}
