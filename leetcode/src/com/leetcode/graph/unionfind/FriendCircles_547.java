package com.leetcode.graph.unionfind;

import com.leetcode.common.DisjointSetUnion;

/**
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature.
 * For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C.
 * And we defined a friend circle is a group of students who are direct or indirect friends.
 * <p>
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1,
 * then the ith and jth students are direct friends with each other, otherwise not.
 * And you have to output the total number of friend circles among all the students.
 * <p>
 * Example 1:
 * Input:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 * The 2nd student himself is in a friend circle. So return 2.
 * Example 2:
 * Input:
 * [[1,1,0],
 * [1,1,1],
 * [0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
 * so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 * Note:
 * N is in range [1,200].
 * M[i][i] = 1 for all students.
 * If M[i][j] = 1, then M[j][i] = 1.
 */
public class FriendCircles_547 {

    int[] parent;
    int find(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            return find(parent[x]);
        }
    }

    public int findCircleNumUnionFind(int[][] isConnected) {
        parent = new int[isConnected.length];
        // init union find
        for (int i = 0; i < isConnected.length; i++) {
            parent[i] = i;
        }

        // connect them if they are directly or indirectly
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    int groupi = find(i);
                    int groupj = find(j);
                    parent[groupj] = groupi;
                }
            }
        }

        int size = 0;
        for (int i = 0; i < parent.length; i++) {
            if (find(i) == i) size++; // find how many groups - if they have parent as themselves.
        }
        return size;
    }

    /**
     * Leetcode verified
     * @param M
     * @return
     */
    public int findCircleNumDFS(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for(int i=0;i<M.length;i++){
            for(int j=0;j<M[0].length;j++){
                if (M[i][j] == 1 && visited[j] == false){
                    visited[i] = true;
                    dfs(j, M, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i, int[][] M, boolean[] visited){
        for(int j=0;j<M[0].length;j++){
            if ( M[i][j] == 1 && visited[j] == false){
                visited[j] = true;
                dfs(j, M, visited);
            }
        }
    }

    /**
     * Leetcode verified with Union-Find
     *
     * @param M
     * @return
     */
    public static int findCircleNum(int[][] M) {
        DisjointSetUnion u = new DisjointSetUnion(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if (i != j && M[i][j] == 1) {
                    u.union(i, j);
                }
            }
        }
        int size = 0;
        for(int i=0;i<M.length;i++){
            if (u.find(i) == i) size++;
        }
        return size;
    }
}
