package epi.dynamic_programming;

public class LevenshteinDistance {

	public static int minDistance(String word1, String word2) {
		
		int word1Length = word1.length();
		int word2Length = word2.length();
		
		int[][] matrix = new int[word1Length+1][word2Length+1];
		
		for(int i = 0; i<=word1Length; i++)
			matrix[i][0] = i;
		
		for(int j = 0; j<=word2Length; j++)
			matrix[0][j] = j;
		
		for(int i = 0; i<word1Length; i++)
		{
			char m = word1.charAt(i);
			for(int j = 0; j<word2Length; j++)
			{
				char n = word2.charAt(j);
				if (m == n) 
				{
					matrix[i+1][j+1] = matrix[i][j];
				} 
				else 
				{
					int replace = matrix[i][j] + 1;
					int insert = matrix[i][j + 1] + 1;
					int delete = matrix[i + 1][j] + 1;
					matrix[i + 1][j + 1] = Math.min(delete, Math.min(replace, insert));
				}
			}				
		}	
		
		return matrix[word1Length][word2Length];
	}
}
