package dynamic_programming;

import java.util.ArrayList;

public class Knapsack01 {

	/**
     * Solves 0/1 knapsack in bottom up dynamic programming
     */
	static int matrix[][];
    public static int findKnapsackBottomUp(int wt[],int val[], int W){
       
        // weights - row
        // capacity from 1 to max in cols
    	matrix = new int[wt.length+1][W+1];
    	 
        // skip i = 0 & j = 0
        for(int i=1; i <= val.length; i++)
        {
            for(int j= 1; j <= W; j++)
            {
            	// if current max capacity is less than current weight.
            	// this weight cannot contribute to the max capacity.
                if(j < wt[i-1]){
                	// choosing current weight will exceed max current capacity
                	// so, choose previous max value
                    matrix[i][j] = matrix[i-1][j];
                }else{
                	// max of (max of not picking i,
                	//                   value by picking i + max of val by not picking previous ,)
                    matrix[i][j] = Math.max(matrix[i-1][j], 
                    		 				val[i-1] + matrix[i-1][j - wt[i-1]]);
                }
            }
        }
        return matrix[val.length][W];
    }
    
	/**
	 * http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
	 * Recursive Top - down approach
	 */
	public static int findKnapsackTopDown(int[] w, int[] v, int capacity)
	{
		ArrayList<Integer> indices = new ArrayList<>();
		return knapSackHelper(w, v, capacity, 0, indices, 0);
	}

	private static int knapSackHelper(int[] w, int[] v, int capacity, int currentCap, ArrayList<Integer> indices, int currIndex) {
		
		if(currentCap == capacity)
		{
			return findValues(v, indices);
		}
		
		int maxValue = 0;
		for (int i = currIndex; i < w.length; i++) 
		{
			int newCap = currentCap + w[i];
			if(newCap > capacity)
			{
				maxValue = Math.max(maxValue, findValues(v, indices));
			}
			else
			{
				indices.add(i);
				maxValue = Math.max(maxValue, knapSackHelper(w, v, capacity, newCap, indices, i + 1));
				indices.remove(indices.size()-1);
			}
		}
		return maxValue;
	} 
	
	private static int findValues(int[] v, ArrayList<Integer> indices)
	{
		int sum = 0;
		for(int key : indices)
		{
			sum = sum + v[key];
		}
		return sum;
	}
}
