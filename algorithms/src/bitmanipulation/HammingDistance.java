package bitmanipulation;

/**
 * Leetcode verified
 * Hamming distance between 2 integers XOR gives different
 * bits. Count them
 */
public class HammingDistance {

	/**
	 * @param a
	 * @param b
	 * @return
	 */
	public int countDigitsToMake(int a, int b) {
		// XOR gives the bits that are different
		int c = a ^ b;
		int digits = 0;
		// count the number of bits
		while (c != 0) {
			digits++;
			// its more like decimal = decimal / 10
			// remove the last digit from the number.
			c = c & (c - 1);
		}
		return digits;
	}

}
