package com.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class AndroidUnlockPatterns {

	static int skip[][] = new int[10][10];
	static 
	{
	    skip[1][3] = skip[3][1] = 2;
	    skip[1][7] = skip[7][1] = 4;
	    skip[3][9] = skip[9][3] = 6;
	    skip[7][9] = skip[9][7] = 8;
	    skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
	}
    
	
	static int totalPatterns = 0;
	public static int numberOfPatterns(int m, int n) {
		if (m > n)
			return 0;
		totalPatterns = 0;
		for (Integer key : getTotalNumbers()) {
			LinkedHashSet<Integer> visited = new LinkedHashSet<Integer>();
			visited.add(key);
			List<Integer> nextNodes = getNextNodes(key, visited);
			recurseHelper(key, nextNodes, visited, m, n);
		}
		return totalPatterns;
	}

	private static List<Integer> getNextNodes(Integer key, LinkedHashSet<Integer> visited) {
		List<Integer> nextNodes = getTotalNumbers();
		nextNodes.remove(key);
		List<Integer> toRemoves = new ArrayList<>();
		toRemoves.addAll(visited);
		for(Integer n : nextNodes)
		{
			if(key == 4 && n == 6)
				System.out.println();
			if( (!visited.contains(skip[key][n])) && skip[key][n] != 0)
				toRemoves.add(n);
		}
		nextNodes.removeAll(toRemoves);
		return nextNodes;
	}
	
	private static List<Integer> getTotalNumbers()
	{
		List<Integer> list = new ArrayList<Integer>();
		for(int i  =1 ;i <= 9; i++)
			list.add(i);
		return list;
	}

	private static void recurseHelper(Integer key, List<Integer> nextNodes, LinkedHashSet<Integer> visited, int min, int max) {
		if (visited.size() > max)
			return;

		if (visited.size() >= min) {
			System.out.println(visited);
			totalPatterns++;
		}

		for (Integer nextHopVal : nextNodes) {
			LinkedHashSet<Integer> newVisited = new LinkedHashSet<>(visited);
			newVisited.add(nextHopVal);
			List<Integer> nextNodesForNext = getNextNodes(key, newVisited);
			recurseHelper(nextHopVal, nextNodesForNext, newVisited, min, max);
			//newVisited.remove(nextHopVal);
		}
	}
}
