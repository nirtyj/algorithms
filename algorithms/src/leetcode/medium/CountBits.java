package leetcode.medium;

public class CountBits {

   /**
    0 - 0 - 0
    1 - 1 - 1
    2 - 10 - 1
    3 - 11 - 2
    4 - 100 - 1
    5 - 101 - 2
    6 - 110 - 2
    7 - 111 - 3
    8 - 1000 - 1
    9 - 1001 - 2
    10 - 1010 -2
    11 - 1011 - 3
    12 - 1100 - 2
    13 - 1101 - 3
    14 - 1110 - 3
    15 - 1000 - 1
    16 - 1001 - 2
    */
	public static int[] countBits(int num) {
		int[] f = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			// previous shifted value + odd or even
			f[i] = f[i / 2] + i % 2;
			// or... both are valid
			f[i] = f[i >> 1] + (i & 1);
		}
		return f;
	}

}
