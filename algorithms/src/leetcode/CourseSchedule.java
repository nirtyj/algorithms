package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

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
}
