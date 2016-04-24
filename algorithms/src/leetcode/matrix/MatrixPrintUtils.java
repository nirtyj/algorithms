package leetcode.matrix;

import java.util.List;

public class MatrixPrintUtils {
	public void printMatrix(List<List<Integer>> matrix)
		{
			for(int i=0;i<matrix.size(); i++)
			{
				for(int j=0;j<matrix.get(i).size();j++)
					System.out.print(matrix.get(i).get(j)+ "\t");
				System.out.println();
			}
		}
}

