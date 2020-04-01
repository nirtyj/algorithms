package com.leetcode.medium;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PartitionLabelsTest {

    @Test
    public void test() {
        PartitionLabels_363 labels = new PartitionLabels_363();
        List<Integer> result = labels.partitionLabels("ababcbacadefegdehijhklij");
        assertEquals(3, result.size());
    }

}
