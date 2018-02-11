package leetcode.easy;

/**
Write a function that takes an unsigned integer and returns the number of ’1' bits it has 
(also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011,
so the function should return 3.
*/
public class NumberOf1BitsHammingWeight {

	/**
	 * O(m) - m number of bits set - Leetcode verified
	 * @param num
	 * @return
	 */
	public int hammingWeight(int num) {
		int setbits = 0;
		while (num != 0) {
			setbits++;
			num = num & (num - 1);
		}
		return setbits;
	}
	
	/**
	 * Time limit Exceeded
	 * O(n)
	 * @param num
	 * @return
	 */
	public int bitSetcountA(int num)
	{
		int setbits =0;
		while(num != 0)
		{
			setbits = setbits + (num & 1);
			num = num >> 1;
		}
		return setbits;
	}
}
