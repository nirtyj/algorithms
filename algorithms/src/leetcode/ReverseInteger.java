package leetcode;

public class ReverseInteger {

	/**
	 * reverse by divide and multiply 
	 * @param num
	 * @return
	 */
	public static int reversDigits(int num)
	{
		int result = 0;
		boolean isnegative = num <0;
		num = Math.abs(num);
		while(num>0)
		{
			int val = num % 10;
			result = result*10 + val;
			num = num /10;
		}
		return isnegative ? -result : result;
	}
	
}
