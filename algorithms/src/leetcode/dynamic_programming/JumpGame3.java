package leetcode.dynamic_programming;

public class JumpGame3 {

	/**
	 * number of jumps = 1 or 2 then fibonacci number sequence.
	 * fib(n-1) + fib(n-2);  for n steps
	 * 
	 * similar to that; run a loop for m jumps for n steps
	 * ways(n, m) = ways(n-1, m) + ways(n-2, m) + ... ways(n-m, m)
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	private static int countWaysUtil(int n, int m)
	{
	    if (n <= 1)
	        return n;
	    int res = 0;
	    
	    for (int i = 1; i<=m && i<=n; i++)
	        res = res+ countWaysUtil(n-i, m);
	    return res;
	}
	 
	// Returns number of ways to reach s'th stair with m possible steps
	public static int countWaysRecursion(int s, int m)
	{
	    return countWaysUtil(s+1, m);
	}
	
	private static int countWaysUtilDp(int n, int m)
	{
	    int[] res = new int[n];
	    res[0] = 1; res[1] = 1;
	    for (int i=2; i<n; i++)
	    {
	       res[i] = 0;
	       for (int j=1; j<=m && j<=i; j++)
	         res[i] = res[i] + res[i-j];
	    }
	    return res[n-1];
	}
	 
	// Returns number of ways to reach s'th stair with m possible steps
	public static int countWaysDp(int s, int m)
	{
	    return countWaysUtilDp(s+1, m);
	}
	
}
