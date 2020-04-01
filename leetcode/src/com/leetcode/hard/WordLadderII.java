package com.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * all shortest transformation sequence(s) from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time Each transformed word must exist in
 * the word list. Note that beginWord is not a transformed word. For example,
 * <p>
 * Given: beginWord = "hit" endWord = "cog" wordList =
 * ["hot","dot","dog","lot","log","cog"]
 */
public class WordLadderII {

    /**
     * DFS - Time limit exceeded
     */
    private static int minSteps = Integer.MAX_VALUE;

    /**
     * Breadth first search. optimal - Not optimal enough -- 30/39 cases passed .
     * time limit exceeded
     */
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordDict = new HashSet<>(wordList);

        if (beginWord.equals(endWord))
            return Collections.emptyList();

        Map<Integer, HashSet<Character>> characterMap = new HashMap<>();
        wordList.add(beginWord);
        wordList.add(endWord);
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                HashSet<Character> chars = characterMap.get(i);
                if (chars == null) {
                    chars = new HashSet<Character>();
                    characterMap.put(i, chars);
                }
                chars.add(word.charAt(i));
            }
        }

        List<List<String>> finalllResult = new ArrayList<>();

        LinkedList<WordNode> result = new LinkedList<WordNode>();
        result.add(new WordNode(beginWord, 1, null));
        HashSet<String> wordsSeen = new HashSet<String>();
        int minSteps = Integer.MAX_VALUE;

        while (!result.isEmpty()) {

            WordNode top = result.remove();
            wordsSeen.add(top.word);

            if (top.word.equals(endWord) && top.noOfSteps <= minSteps) {
                printLinkedList(result);
                minSteps = top.noOfSteps;
                ArrayList<String> results = new ArrayList<>();
                results.addAll(top.wordsVisited);
                results.add(top.word);
                finalllResult.add(results);
                System.out.println("<------");

                continue;
            }

            // to loop through all the nodes present in the queue
            if (top.noOfSteps + 1 > minSteps)
                continue;

            // we dont need to go further. we can break out.
            if (top.noOfSteps + 2 > minSteps)
                break;

            System.out.println("-------------------------");
            System.out.println("top - " + top.word + " at " + top.noOfSteps);

            char[] arr = top.word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                HashSet<Character> chars = characterMap.get(i);
                // or iterate from the available chars - a to z
                for (char c : chars) {

                    // swap the characters to form a new word at each position
                    char temp = arr[i];
                    arr[i] = c;

                    String newWord = new String(arr);
                    if (
                        // is not the same word
                            !newWord.equals(top.word)
                                    // if the word is valid
                                    && wordDict.contains(newWord)
                                    // if its not visited previously for this path
                                    && !top.wordsVisited.contains(newWord)
                                    // if this node is not processed before
                                    && !wordsSeen.contains(newWord)) {
                        WordNode node = new WordNode(newWord, top.noOfSteps + 1, top);
                        node.wordsVisited.addAll(top.wordsVisited);
                        node.wordsVisited.add(top.word);
                        result.add(node);
                        System.out.println(" adding - " + newWord);
                    }

                    arr[i] = temp;
                }
            }

        }

        return finalllResult;
    }

    public static void printLinkedList(LinkedList<WordNode> words) {
        System.out.println();
        for (WordNode word : words) {
            System.out.print(word.word + " : " + word.noOfSteps + " -> ");
        }
        System.out.println();

    }

    public static List<List<String>> findLaddersDFS(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<>(wordList);
        minSteps = Integer.MAX_VALUE;

        if (beginWord.equals(endWord))
            return Collections.emptyList();

        wordList.add(beginWord);
        wordList.add(endWord);
        Map<Integer, HashSet<Character>> characterMap = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                HashSet<Character> chars = characterMap.get(i);
                if (chars == null) {
                    chars = new HashSet<Character>();
                    characterMap.put(i, chars);
                }
                chars.add(word.charAt(i));
            }
        }

        LinkedList<String> list = new LinkedList<String>();
        list.add(beginWord);

        List<List<String>> result = new ArrayList<>();
        ladderInner(list, endWord, wordDict, characterMap, result);
        return result;
    }

    public static void ladderInner(LinkedList<String> list, String endWord, Set<String> wordDict,
                                   Map<Integer, HashSet<Character>> characterMap, List<List<String>> result) {
        String last = list.getLast();
        if (list.size() > minSteps) {
            return;
        }
        if (last.equals(endWord)) {
            if (list.size() <= minSteps) {
                if (list.size() < minSteps) {
                    result.clear();
                }
                minSteps = list.size();
                result.add(new ArrayList<>(list));
            }
            return;
        }

        char[] arr = last.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            HashSet<Character> chars = characterMap.get(i);
            for (char c : chars) {
                char temp = arr[i];

                arr[i] = c;
                String newWord = new String(arr);
                if (!newWord.equals(last) && wordDict.contains(newWord)) {
                    list.add(newWord);
                    wordDict.remove(newWord);

                    ladderInner(list, endWord, wordDict, characterMap, result);

                    list.removeLast();
                    wordDict.add(newWord);
                }

                arr[i] = temp;
            }
        }
    }

    /**
     * Leetcode verified
     *
     * @param start
     * @param end
     * @param wordList
     * @return
     */
    public List<List<String>> findLaddersDfsBfs(String start, String end, List<String> wordList) {
        HashSet<String> dict = new HashSet<String>(wordList);
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>();// Neighbors for
        // every node
        HashMap<String, Integer> distance = new HashMap<String, Integer>();// Distance of every node from the start node
        ArrayList<String> solution = new ArrayList<String>();

        dict.add(start);
        bfs(start, end, dict, nodeNeighbors, distance);
        dfs(start, end, dict, nodeNeighbors, distance, solution, res);
        return res;
    }

    // BFS: Trace every node's distance from the start node (level by level).
    private void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors,
                     HashMap<String, Integer> distance) {
        for (String str : dict)
            nodeNeighbors.put(str, new ArrayList<String>());

        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                ArrayList<String> neighbors = getNeighbors(cur, dict);

                for (String neighbor : neighbors) {
                    nodeNeighbors.get(cur).add(neighbor);
                    if (!distance.containsKey(neighbor)) {// Check if visited
                        distance.put(neighbor, curDistance + 1);
                        if (end.equals(neighbor))// Found the shortest path
                            foundEnd = true;
                        else
                            queue.offer(neighbor);
                    }
                }
            }

            if (foundEnd)
                break;
        }
    }

    // Find all next level nodes.
    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        char[] chs = node.toCharArray();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch)
                    continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }

    // DFS: output all paths with the shortest distance.
    private void dfs(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors,
                     HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
        solution.add(cur);
        if (end.equals(cur)) {
            res.add(new ArrayList<String>(solution));
        } else {
            for (String next : nodeNeighbors.get(cur)) {
                if (distance.get(next) == distance.get(cur) + 1) {
                    dfs(next, end, dict, nodeNeighbors, distance, solution, res);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }

    private static class WordNode {
        String word;
        int noOfSteps;
        WordNode pre;
        LinkedHashSet<String> wordsVisited = new LinkedHashSet<String>();

        public WordNode(String word, int noOfSteps, WordNode pre) {
            this.word = word;
            this.noOfSteps = noOfSteps;
            this.pre = pre;
        }
    }
}
