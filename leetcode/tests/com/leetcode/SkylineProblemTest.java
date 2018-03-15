package com.leetcode;

import java.util.Arrays;

import org.junit.Test;

import com.leetcode.hard.SkylineProblem;

public class SkylineProblemTest {

	@Test
	public void test() {
		int[][] input = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
		for(int[] inp : SkylineProblem.getSkyline(input))
		{
			System.out.println(Arrays.toString(inp));
		}
	}

	@Test
	public void test2() {
		int[][] input = {{0,1,3}};
		for(int[] inp : SkylineProblem.getSkyline(input))
		{
			System.out.println(Arrays.toString(inp));
		}
	}
}
