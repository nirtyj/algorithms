package com.leetcode.graph.topologicalsort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * <p>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * <p>
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 * <p>
 * For example:
 * <p>
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]
 * <p>
 * 4, [[1,0],[2,0],[3,1],[3,2]]
 * There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
 * <p>
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 */
public class CourseScheduleII_LC210 {

    /**
     * Uses topological Sort
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if (prerequisites.length <= 0) {
            return IntStream.range(0, numCourses).toArray();
        }

        int[] result = new int[numCourses];

        HashMap<Integer, HashSet<Integer>> indegree = new HashMap<>();
        // build reverse index or indegree.
        for (int i = 0; i < prerequisites.length; i++) {
            int startV = prerequisites[i][0];
            int endV = prerequisites[i][1];
            HashSet<Integer> edges = indegree.getOrDefault(endV, new HashSet<>());
            edges.add(startV);
            indegree.put(endV, edges);
        }

        // one element for each course for tracking visiting
        int[] seen = new int[numCourses];

        // stack to hold the visited nodes
        Stack<Integer> stack = new Stack<>();

        // for each course, find the visited
        for (int i = 0; i < numCourses; i++) {
            if (!topologicalSort(seen, indegree, i, stack)) {
                return new int[0];
            }
        }

        int i = 0;
        // convert stack to result
        while (stack.empty() == false)
            result[i++] = stack.pop();

        return result;
    }

    private boolean topologicalSort(int[] seen, HashMap<Integer, HashSet<Integer>> reverseIndex, int i,
                                    Stack<Integer> stack) {

        // -1 means loop
        if (seen[i] == -1)
            return false;

        // already visited - so truncates the tree and returns
        if (seen[i] == 1)
            return true;

        // currently visiting
        seen[i] = -1;

        if (reverseIndex.containsKey(i)) {
            HashSet<Integer> vals = reverseIndex.get(i);
            for (Integer val : vals) {
                if (!topologicalSort(seen, reverseIndex, val, stack))
                    return false;
            }
        }

        // mark as visited
        seen[i] = 1;

        stack.push(i);
        return true;
    }

    /**
     * BFS - slower
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrderBFS(int numCourses, int[][] prerequisites) {

        int len = prerequisites.length;
        if (len == 0) {
            int[] res = new int[numCourses];
            for (int m = 0; m < numCourses; m++) {
                res[m] = m;
            }
            return res;
        }

        // one element for each course.
        int[] pCounter = new int[numCourses];

        // for each entry, count the prereqs needed for each course
        for (int i = 0; i < prerequisites.length; i++) {
            pCounter[prerequisites[i][0]]++;
        }

        Queue<Integer> noPreReqs = new LinkedList<Integer>();

        // go through the array to find out the course that has no pre-req
        for (int i = 0; i < numCourses; i++) {
            if (pCounter[i] == 0) {
                noPreReqs.add(i);
            }
        }
        // no preReq courses are already satisfied to finish
        int noOfSatisfiedCourses = noPreReqs.size();

        int[] result = new int[numCourses];
        int m = 0;
        while (noPreReqs.size() != 0) {
            Integer preReqCourse = noPreReqs.remove();
            result[m++] = preReqCourse;
            // for each No Pre req course, find all the courses that needs it as
            // a pre-req.
            for (int i = 0; i < len; i++) {
                if (prerequisites[i][1] == preReqCourse) {
                    // reduce the count of prereq course for i
                    pCounter[prerequisites[i][0]]--;

                    // if there are no more pre-reqs needed, add it to the queue
                    // of satisfied courses
                    if (pCounter[prerequisites[i][0]] == 0) {
                        noOfSatisfiedCourses++;
                        noPreReqs.add(prerequisites[i][0]);
                    }

                }
            }
        }

        if (noOfSatisfiedCourses == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(IntStream.range(1, 10).toArray()));
    }
}
