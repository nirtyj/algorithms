package com.leetcode.medium;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class PartitionLabelsTest {

	@Test
	public void test() {
		PartitionLabels labels = new PartitionLabels();
		List<Integer> result = labels.partitionLabels("ababcbacadefegdehijhklij");
		assertEquals(3, result.size());
	}

}
