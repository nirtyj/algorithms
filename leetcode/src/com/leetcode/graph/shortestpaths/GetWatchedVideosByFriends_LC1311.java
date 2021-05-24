package com.leetcode.graph.shortestpaths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There are n people, each person has a unique id between 0 and n-1. Given the arrays watchedVideos and friends, where watchedVideos[i] and friends[i] contain the list of watched videos and the list of friends respectively for the person with id = i.
 *
 * Level 1 of videos are all watched videos by your friends, level 2 of videos are all watched videos by the friends of your friends and so on. In general, the level k of videos are all watched videos by people with the shortest path exactly equal to k with you. Given your id and the level of videos, return the list of videos ordered by their frequencies (increasing). For videos with the same frequency order them alphabetically from least to greatest.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 1
 * Output: ["B","C"]
 * Explanation:
 * You have id = 0 (green color in the figure) and your friends are (yellow color in the figure):
 * Person with id = 1 -> watchedVideos = ["C"]
 * Person with id = 2 -> watchedVideos = ["B","C"]
 * The frequencies of watchedVideos by your friends are:
 * B -> 1
 * C -> 2
 * Example 2:
 *
 *
 *
 * Input: watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 2
 * Output: ["D"]
 * Explanation:
 * You have id = 0 (green color in the figure) and the only friend of your friends is the person with id = 3 (yellow color in the figure).
 *
 *
 * Constraints:
 *
 * n == watchedVideos.length == friends.length
 * 2 <= n <= 100
 * 1 <= watchedVideos[i].length <= 100
 * 1 <= watchedVideos[i][j].length <= 8
 * 0 <= friends[i].length < n
 * 0 <= friends[i][j] < n
 * 0 <= id < n
 * 1 <= level < n
 * if friends[i] contains j, then friends[j] contains i
 */
public class GetWatchedVideosByFriends_LC1311 {

    /**
     * Bellman ford algorithm!
     * @param watchedVideos
     * @param friends
     * @param id
     * @param level
     * @return
     */
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        double[] distance = new double[friends.length];
        Arrays.fill(distance, Double.POSITIVE_INFINITY); // Do Not use MAX value as it might cause overflow.
        distance[id] = 0;
        for(int m = 0;m<level;m++){ // propagate only as far as level needed. not all nodes.
            for(int i=0; i<friends.length;i++){
                for(int neighbor : friends[i]){
                    distance[i] = Math.min(distance[i], distance[neighbor] + 1);
                }
            }
        }

        HashMap<String, Integer> freq = new HashMap<>();
        for(int i=0; i<distance.length;i++){
            if (distance[i] == level){
                List<String> vids = watchedVideos.get(i);
                for (String vid : vids){
                    int fre = freq.getOrDefault(vid, 0);
                    freq.put(vid, fre + 1);
                }
            }
        }
        List<String> ans = new ArrayList<>(freq.keySet());
        ans.sort((s1,s2) -> {
            if(freq.get(s1) != freq.get(s2)) {
                return freq.get(s1) - freq.get(s2);
            } else {
                return s1.compareTo(s2);
            }
        });
        return ans;
    }

    /**
     * Shortest Path faster algorithm - SPFA
     * https://www.geeksforgeeks.org/shortest-path-faster-algorithm/
     */
    public List<String> watchedVideosByFriendsSPFA(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        double[] distance = new double[friends.length];
        Arrays.fill(distance, Double.POSITIVE_INFINITY); // Do Not use MAX value as it might cause overflow.
        distance[id] = 0;
        boolean []inQueue = new boolean[friends.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        inQueue[id] = true;
        int l = 0;
        while (!q.isEmpty())
        {
            int size = q.size();
            for (int s =0 ; s<size;s++){
                int u = q.peek();
                q.remove();
                inQueue[u] = false;
                for(int neighbor : friends[u]){
                    if (distance[neighbor] > distance[u] + 1)
                    {
                        distance[neighbor] = distance[u] + 1;
                        if (!inQueue[neighbor])
                        {
                            q.add(neighbor);
                            inQueue[neighbor] = true;
                        }
                    }
                }
            }
            l++;
            if (l >= level){
                break;
            }
        }

        HashMap<String, Integer> freq = new HashMap<>();
        for(int i=0; i<distance.length;i++){
            if (distance[i] == level){
                List<String> vids = watchedVideos.get(i);
                for (String vid : vids){
                    int fre = freq.getOrDefault(vid, 0);
                    freq.put(vid, fre + 1);
                }
            }
        }
        List<String> ans = new ArrayList<>(freq.keySet());
        ans.sort((s1,s2) -> {
            if(freq.get(s1) != freq.get(s2)) {
                return freq.get(s1) - freq.get(s2);
            } else {
                return s1.compareTo(s2);
            }
        });
        return ans;
    }
}
