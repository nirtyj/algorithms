package bitmanipulation;

/**
 * Hamming distance between 2 integers
 * XOR gives different bits.
 * Count them
 */
public class HammingDistance {

	
	 /** @param a
	 * 	@param b
	 *	 @return
	 */
	public int countDigitsToMake(int a,int b)
	{
		int c = a ^ b;
		int digits = 0;
		while (c !=0)
		{
			digits++;
			c = c & (c-1);
		}
		return digits;
	}

}
