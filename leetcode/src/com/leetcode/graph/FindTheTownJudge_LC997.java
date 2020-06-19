package com.leetcode.graph;

/**
 * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
 *
 * If the town judge exists, then:
 *
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 *
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: N = 2, trust = [[1,2]]
 * Output: 2
 * Example 2:
 *
 * Input: N = 3, trust = [[1,3],[2,3]]
 * Output: 3
 * Example 3:
 *
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 * Example 4:
 *
 * Input: N = 3, trust = [[1,2],[2,3]]
 * Output: -1
 * Example 5:
 *
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 */
public class FindTheTownJudge_LC997 {

    /**
     * Leetocde verified
     * @param N
     * @param trust
     * @return
     */
    public int findJudgeSimpler(int N, int[][] trust) {
        int[][] result = new int[N + 1][2];// 0th index - do you trust anyone yes - -1, else 0,
        // 1st index how many trust you count
        for(int[] t: trust){
            result[t[0]][0] = -1;
            result[t[1]][1] =  result[t[1]][1] + 1;
        }
        for(int i=1;i<=N;i++){
            // you shouldn't trust anyone and no of people that trusts you should be 1 less than total people in town
            if (result[i][1] == N-1 && result[i][0] == 0){
                return i;
            }
        }
        return -1;
    }
}
