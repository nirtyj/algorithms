package leetcode.dynamic_programming;

public class JumpGame2 {

	public static int minJump(int[] A) {
		if (A.length <= 1)
			return 1;

		int maxReach = 0;
		int lastMaxReach = 0;
		int steps = 0;
		/**
		 * i <= max handles the case where there is no reach to the end.
		 */
		for (int i = 0; i <= maxReach && i < A.length; i++) {
			
			// when current jump is more than last max, increase a step
			// increases one step later after max is calculated
			if (lastMaxReach < i) {
				steps++;
				lastMaxReach = maxReach;
			}
			
			int reachFromHere = i + A[i];
			maxReach = Math.max(maxReach, reachFromHere);
		}

		/**
		 * if max has not reached the end, return 0
		 */
		if (maxReach < A.length - 1)
			return 0;

		return steps;

	}
}
