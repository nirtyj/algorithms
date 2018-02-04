package interviewchallenges;

public class Oracle {

	/**
	 * calculateNumberOfIslands
 		
		Phone interview:
		1. Number of islands
		2. Design API. Handle robustness
		
		POST calculation
		{
		
		
		}
		
		GET calculation
		{
		   inputMatrix: 
		   status: IN_PROGRESS ? FINISHED
		   results: null, 0/100
		}
		
		
		1. Available
		2. latency 
		3. Exception requests. 
		4. concurrent requests
	 */

	/**
	 * Leetcode verified
	 * @param matrix
	 * @return
	 */
	public int numIslands(char[][] matrix) {
		// do null check, and size > 0 check
		if (matrix == null || matrix.length <= 0)
			return 0;

		boolean[][] visitedArray = new boolean[matrix.length][matrix[0].length];
		int count = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				count = count + recursiveHelper(matrix, visitedArray, i, j);
			}
		}
		return count;
	}

	public int recursiveHelper(char[][] matrix, boolean[][] visitedArray, int i, int j) {
		// base condition
		if (i < 0 || i > matrix.length - 1 || j < 0 || j > matrix[0].length - 1)
			return 0;

		if (visitedArray[i][j] == true)
			return 0;

		visitedArray[i][j] = true;
		if (matrix[i][j] == '0') {
			return 0;
		} else {
			recursiveHelper(matrix, visitedArray, i - 1, j);
			recursiveHelper(matrix, visitedArray, i, j - 1);
			recursiveHelper(matrix, visitedArray, i + 1, j);
			recursiveHelper(matrix, visitedArray, i, j + 1);
		}
		return 1;
	}
	
	// on campus expectations
	// 1. LRU cache
	// 2. Binary tree mirror
	// 3. closest value to a given value in a BST
	// 4. duplicate number in an array of size N
	// 5. BST, Scheduling
	
	/**
	 * On Campus
	 * 
	 * 1 round.
	 *    Large file with texts. Count chars, words, sentences.
	 *    	ignore empty lines, spaces, and tabs.
	 *    	code tokenizer
	 *  
	 *  2. round.
	 *  	  Design Dropbox system
	 *  		Patch with ID
	 *  		distributed storage.
	 *  		distributed protocol
	 *  		testing.
	 *  		Billing
	 *  
	 *  3. round
	 *  		Manager interview
	 *  		Behavioral
	 *  
	 *  4. round
	 *  		Large image with some fun but less memory space
	 *  			split up the image
	 *  			How do you handle stiching up the files after output
	 *  		code if a string has invalid paranthesis
	 *  			design with args to take in about paranthesis
	 *  
	 *  5. round
	 *  		Explain what is Json
	 *  		How to represent diff between objects.
	 *  			Json has no set types
	 *  			represent with 3 fields - additions, deletions, modifications
	 *  			each represented with dots - > company.employee.name = foor
	 *  		use different de-limiter
	 *  
	 */
	
}
