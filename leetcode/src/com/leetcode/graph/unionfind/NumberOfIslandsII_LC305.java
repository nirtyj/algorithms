package com.leetcode.graph.unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A 2d grid map of m rows and n columns is initially filled with water.
 * We may perform an addLand operation which turns the water at position (row, col) into a land.
 * Given a list of positions to operate, count the number of islands after each addLand operation.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example:
 *
 * Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
 * Output: [1,1,2,3]
 */
public class NumberOfIslandsII_LC305 {

    static int[][] directions = {{-1, 0}, {+1, 0}, {0, -1}, {0, +1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        Union u = new Union(m * n);
        List<Integer> result = new ArrayList<>();
        for (int[] position : positions) {
            int id = getKey(m, n, position[0], position[1]);
            // set the id to be its same value (root) unless it has been seen before
            u.set(id);
            // go all possible directions and find union if its valud
            for (int[] dir : directions) {
                if (position[0] + dir[0] < 0 || position[0] + dir[0] >= m || position[1] + dir[1] < 0 || position[1] + dir[1] >= n) {
                    continue;
                }
                // get the id of the directions to go to.
                int connId = getKey(m, n, position[0] + dir[0], position[1] + dir[1]);
                // union only if the connId is valid
                u.union(id, connId);
            }
            // get number of components - increases every time you initialize. decrease every time you union.
            result.add(u.numComponents);
        }
        return result;
    }

    /**
     * find that id for a x,y in a matrix
     * @param m
     * @param n
     * @param i
     * @param j
     * @return
     */
    private int getKey(int m, int n, int i, int j) {
        return i * n + j;
    }

    public class Union {
        int[] id;
        int numComponents = 0;

        public Union(int size) {
            id = new int[size];
            Arrays.fill(id, -1);
        }

        /**
         * initialize that id
         * @param x
         */
        public void set(int x) {
            if (id[x] != x) {
                id[x] = x;
                numComponents++;
            }
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
            // not initialized
            if (id[y] == -1) {
                return;
            }
            int xroot = find(x);
            int yroot = find(y);
            if (xroot == yroot) {
                return;
            }
            // assign yroot to xroot
            id[yroot] = xroot;
            numComponents--;
        }
    }

    public static void main(String[] args) {
        NumberOfIslandsII_LC305 is = new NumberOfIslandsII_LC305();
        List<Integer> result = is.numIslands2(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}});
        System.out.println(result.toString());
    }
}
