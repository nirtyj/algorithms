package com.leetcode.medium;

/**
 * 277. https://leetcode.com/problems/find-the-celebrity/
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity.
 * The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
 * <p>
 * Now you want to find out who the celebrity is or verify that there is not one.
 * The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B.
 * You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
 * <p>
 * You are given a helper function bool knows(a, b) which tells you whether A knows B.
 * Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
 * <p>
 * Note: There will be exactly one celebrity if he/she is in the party.
 * Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.
 */
public class FindCelebrity_277 {
    // dummy implementation
    boolean knows(int a, int b) {
        return false;
    }

    /**
     * Leetcode verifed
     *
     * @param n
     * @return
     */
    public int findCelebrity(int n) {
        int candidate = 0;
        // find the candidate.
        // if someone doesnt know a candidate, they are not a candidate. but someone could be a candidate
        // so switch for the candidate
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i))
                candidate = i;
        }
        // validate if the candidate is real
        // if !(that candidate should not know i, or others should know candidate) - there is no candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate && (knows(candidate, i) || !knows(i, candidate)))
                return -1;
        }
        return candidate;
    }
}
