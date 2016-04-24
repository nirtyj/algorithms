package epi.recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

	private static final double LOG_2 = Math.log(2);

	public static List<List<Integer>> powerSet2n(List<Integer> A) {
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < (1 << A.size()); i++) {
			int bits = i;
			ArrayList<Integer> ints = new ArrayList<>();
			while (bits != 0) {
				// bits & ~(bits-1) finds the least set bit
				// then try to find the which bit position that is set by
				// lets say lsb = 4, 100 
				// then 2^x = 4 . x = 2 i.e needs to be 2nd position
				// hence 2^x = 4, => log 2(4) => Math.log(4) / Math.log(2)
				int bitposition = (int) (Math.log(bits & ~(bits - 1)) / LOG_2);
				ints.add(A.get(bitposition));
				bits = bits & (bits - 1);
			}
			result.add(ints);
		}
		return result;
	}
}
