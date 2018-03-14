package com.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
*/
public class CourseSchedule {

	/**
	 * BFS- leetcode verified
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {

		int len = prerequisites.length;
		if (numCourses == 0 || len == 0)
			return true;

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

		while (noPreReqs.size() != 0) {
			Integer preReqCourse = noPreReqs.remove();
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
		return noOfSatisfiedCourses == numCourses;
	}

	/**
	 * DFS
	 * 
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public boolean canFinishDFS(int numCourses, int[][] prerequisites) {

		int len = prerequisites.length;
		if (numCourses == 0 || len == 0)
			return true;

		HashMap<Integer, HashSet<Integer>> reverseIndex = new HashMap<>();
		// build reverse index
		for (int i = 0; i < prerequisites.length; i++) {
			if (reverseIndex.containsKey(prerequisites[i][1])) {
				reverseIndex.get(prerequisites[i][1]).add(prerequisites[i][0]);
			} else {
				HashSet<Integer> set = new HashSet<Integer>();
				set.add(prerequisites[i][0]);
				reverseIndex.put(prerequisites[i][1], set);
			}
		}
		// one element for each course.
		int[] pCounter = new int[numCourses];

		// for each course, see if they are finishable
		for (int i = 0; i < numCourses; i++) {
			if (!canFinish(pCounter, reverseIndex, i))
				return false;
		}
		return true;
	}

	private boolean canFinish(int[] pCounter, HashMap<Integer, HashSet<Integer>> reverseIndex, int i) {

		// -1 means loop
		if (pCounter[i] == -1)
			return false;

		// already visited - so truncates the tree and returns
		if (pCounter[i] == 1)
			return true;

		// currently visiting
		pCounter[i] = -1;
		if (reverseIndex.containsKey(i)) {
			HashSet<Integer> vals = reverseIndex.get(i);
			// for each course dependencies find if they are finishable
			for (Integer val : vals) {
				if (!canFinish(pCounter, reverseIndex, val))
					return false;
			}
		}

		// mark as visited
		pCounter[i] = 1;

		return true;
	}
}
