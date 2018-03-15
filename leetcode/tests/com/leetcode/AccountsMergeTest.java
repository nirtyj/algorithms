package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.leetcode.medium.AccountsMerge;

public class AccountsMergeTest {

	@Test
	public void test() {
		
		String[] arr1 = {"John","johnsmith@mail.com","john_newyork@mail.com"};
		List<String> list1  = Arrays.asList(arr1);
		
		String[] arr2 = {"John","johnsmith@mail.com","john00@mail.com"};
		List<String> list2  = Arrays.asList(arr2);
		
		String[] arr3 = {"Mary","mary@mail.com"};
		List<String> list3  = Arrays.asList(arr3);
		
		String[] arr4 = {"John","johnnybravo@mail.com"};
		List<String> list4  = Arrays.asList(arr4);
		
		List<List<String>> input = new ArrayList<>();
		input.add(list1);
		input.add(list2);
		input.add(list3);
		input.add(list4);
		List<List<String>> ouput = AccountsMerge.accountsMerge(input);
		System.out.println();
	}

	@Test
	public void test2() {
		
		String[] arr1 = {"David","David0@m.co","David1@m.co"};
		List<String> list1  = Arrays.asList(arr1);
		
		String[] arr2 = {"David","David3@m.co","David4@m.co"};
		List<String> list2  = Arrays.asList(arr2);
		
		String[] arr3 = {"David","David4@m.co","David5@m.co"};
		List<String> list3  = Arrays.asList(arr3);
		
		String[] arr4 = {"David","David2@m.co","David3@m.co"};
		List<String> list4  = Arrays.asList(arr4);
		

		String[] arr5 = {"David","David1@m.co","David2@m.co"};
		List<String> list5  = Arrays.asList(arr5);
		
		List<List<String>> input = new ArrayList<>();
		input.add(list1);
		input.add(list2);
		input.add(list3);
		input.add(list4);
		input.add(list5);
		List<List<String>> ouput = AccountsMerge.accountsMerge(input);
		System.out.println();
	}

}
