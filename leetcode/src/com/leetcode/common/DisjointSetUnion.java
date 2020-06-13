package com.leetcode.common;

import java.util.stream.IntStream;

/**
 * used for union find
 */
public class DisjointSetUnion {
    int[] parent;

    public DisjointSetUnion(int size) {
        parent = IntStream.range(0, size + 1).toArray();
    }

    public int find(int x) {
        while(x != parent[x])
            x = parent[x];
        return x;
    }

    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}
