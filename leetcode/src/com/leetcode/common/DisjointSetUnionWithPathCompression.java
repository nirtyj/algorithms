package com.leetcode.common;

import java.util.stream.IntStream;

/**
 * With path compression for DisjointSet Union
 */
public class DisjointSetUnionWithPathCompression {
    int[] id;
    int[] sizeArr;

    public DisjointSetUnionWithPathCompression(int size) {
        id = IntStream.range(0, size + 1).toArray();
        sizeArr = new int[size];
    }

    public int find(int x) {
        int root = x;
        // find
        while (root != id[root]) {
            root = id[root];
        }
        // compress
        while (x != root) {
            int next = id[x];
            id[x] = root;
            x = next;
        }
        return root;
    }

    public void union(int x, int y) {
        int xroot = find(x);
        int yroot = find(y);
        if (xroot == yroot) {
            return;
        }
        // assign yroot to xroot
        if (sizeArr[xroot] >= sizeArr[yroot]) {
            sizeArr[xroot] = sizeArr[xroot] + sizeArr[yroot];
            id[yroot] = xroot;
        } else { // assign xroot to yroot
            sizeArr[yroot] = sizeArr[yroot] + sizeArr[xroot];
            id[xroot] = yroot;
        }
    }
}
