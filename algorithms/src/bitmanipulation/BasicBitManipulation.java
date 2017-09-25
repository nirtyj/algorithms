package bitmanipulation;

/**
 * 
 * byte: Byte data type is a 8-bit signed two's complement integer.
 * 
 * Short: Short data type is a 16-bit signed two's complement integer.
 * 
 * int: Int data type is a 32-bit signed two's complement integer.
 * 
 * long: Long data type is a 64-bit signed two's complement integer.
 * 
 * float: Float data type is a single-precision 32-bit IEEE 754 floating point.
 * 
 * double: double data type is a double-precision 64-bit IEEE 754 floating
 * point.
 * 
 * boolean: boolean data type represents one bit of information.
 * 
 * char: char data type is a single 16-bit Unicode character.
 * test change
 */
public class BasicBitManipulation {
	
	/**
	 * @param number
	 * @param position
	 * @return
	 */
	public boolean getBit(int number, int position)
	{		
		return ((number & (1 << position)) != 0);
	}
	
	/**
	 * 
	 * @param number
	 * @param position
	 * @return
	 */
	public int clearBit(int number,int position)
	{
		return  number & ~(1 << position);
	}
	
	/**
	 * 
	 * @param number
	 * @param position
	 * @return
	 */
	public int flipBit(int number, int position)
	{		
		return number ^(1 << position);		
	}
		
	/**
	 * 
	 * @param num
	 * @param i
	 * @return
	 */
	public int clearBitsMSBThroughI(int num, int i)
	{
		int mask = (1<<i) - 1;
		return num & mask;
	}
	
	/**
	 * 
	 * @param num
	 * @param i
	 * @return
	 */
	public int clearBitsIthrough0(int num, int i)
	{
		int mask = ~(-1 >>> (31-i));
		return num & mask;
	}
	
	/**
	 * 
	 * @param number
	 * @param position
	 * @return
	 */
	public int setBit(int number, int position)
	{
		return number | (1 << position);
	}
	
	/**
	 * 
	 * @param num
	 * @return
	 */
	public int countDigits(int num)
	{
		int digits = 0;
		for (digits = 0; num > 0; num >>= 1)
			digits++;
		return digits;
	}
	
	/**
	 * 
	 * @param num
	 * @return
	 */
	public int countDigitsformula(int num)
	{
		return (int)(Math.floor(Math.log10(num))) + 1;
	}
	
	/**
	 * 
	 * @param num
	 * @param i
	 * @return
	 */
	public int setBitsMSBThroughI(int num, int i)
	{		
		int digits = countDigits(num);
		int mask = 0;
		for (int j=i;j<digits; j++)
		{
			mask = mask | (1<<j);
		}
		return num | mask;
	}
	
	/**
	 * 
	 * @param num
	 * @param i
	 * @return
	 */
	public int setBitsIthrough0(int num, int i)
	{
		int mask = (-1 >>> (31-i));
		return num | mask;
	}
	
	/**
	 * 
	 * @param number
	 * @param position
	 * @param boolValue
	 * @return
	 */
	public int setBit(int number,int position,boolean boolValue)
	{
		int val = boolValue ? 1:0;
		int mask = ~(1 << position);
		return (number & mask) | (val<< position);
	}
	
	/**
	 * AND with 1 to get LSB. to get next bit shift right
	 * @param number
	 * @return
	 */
	public int getLSB(int number)
	{
		return number & 1;
	}
	
	/**
	 * Integer is 32 bits. so set sign bit AND and power shift
	 * @param number
	 * @return
	 */
	public int getSignBit(int number)
	{
		int val = number & 0x80000000;
		return val >>> 31;
	}
	
	/**
	 * right bit 0 - power of 2
	 * @param num
	 * @return
	 */
	public boolean isPowerOf2(int num)
	{
		if(num==1)
			return false;
		return (num > 0) && ((num & (num - 1)) == 0);
	}
	
	/**
	 * Negative number is two's complement + 1
	 * @param num
	 * @return
	 */
	public int getNegativeNumber(int num)
	{
		return (~num + 1);
	}
	
	/**
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
	
	/**
	 * O(m) - m number of bits set
	 * @param num
	 * @return
	 */
	public int bitSetcountB(int num)
	{
		int setbits =0;
		while(num != 0)
		{
			setbits++;
			num = num & (num-1);
		}
		return setbits;
	}
}
