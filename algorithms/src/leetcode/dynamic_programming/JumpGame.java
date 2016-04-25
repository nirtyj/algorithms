package leetcode.dynamic_programming;

public class JumpGame {

	public static boolean canJump(int[] A) {
		if (A.length <= 1)
			return true;

		int max = A[0];

		for (int i = 1; i < A.length; i++) {
			
			// failure case - max is less than equal to current step but current step is 0 
			if (max <= i && A[i] == 0)
				return false;

			/**
			 * is it worth going to next step and jump from there ? do we get updated max.
			 */
			int reachFromHere = i + A[i];
			max = Math.max(max, reachFromHere);

			// success case
			if (max >= A.length - 1)
				return true;
		}

		return false;

	}
}
