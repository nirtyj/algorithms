package puzzles;

public class EquilibriumIndex {

	public static int getBalancePoint(Integer[] input)
	{
		int rightSum = 0;
		for(int k : input)
		{
			rightSum += k;
		}
		
		int leftSum = 0;
		for(int i=0;i<input.length;i++)
		{
			rightSum -= input[i];
			if(leftSum == rightSum)
				return i;
			leftSum += input[i];
		}
		
		return -1;
	}
}
