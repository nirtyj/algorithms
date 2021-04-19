package com.leetcode.medium;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * You are given n​​​​​​ tasks labeled from 0 to n - 1 represented by a 2D integer array tasks, where tasks[i] = [enqueueTimei, processingTimei] means that the i​​​​​​th​​​​ task will be available to process at enqueueTimei and will take processingTimei to finish processing.
 *
 * You have a single-threaded CPU that can process at most one task at a time and will act in the following way:
 *
 * If the CPU is idle and there are no available tasks to process, the CPU remains idle.
 * If the CPU is idle and there are available tasks, the CPU will choose the one with the shortest processing time. If multiple tasks have the same shortest processing time, it will choose the task with the smallest index.
 * Once a task is started, the CPU will process the entire task without stopping.
 * The CPU can finish a task then start a new one instantly.
 * Return the order in which the CPU will process the tasks.
 *
 *
 *
 * Example 1:
 *
 * Input: tasks = [[1,2],[2,4],[3,2],[4,1]]
 * Output: [0,2,3,1]
 * Explanation: The events go as follows:
 * - At time = 1, task 0 is available to process. Available tasks = {0}.
 * - Also at time = 1, the idle CPU starts processing task 0. Available tasks = {}.
 * - At time = 2, task 1 is available to process. Available tasks = {1}.
 * - At time = 3, task 2 is available to process. Available tasks = {1, 2}.
 * - Also at time = 3, the CPU finishes task 0 and starts processing task 2 as it is the shortest. Available tasks = {1}.
 * - At time = 4, task 3 is available to process. Available tasks = {1, 3}.
 * - At time = 5, the CPU finishes task 2 and starts processing task 3 as it is the shortest. Available tasks = {1}.
 * - At time = 6, the CPU finishes task 3 and starts processing task 1. Available tasks = {}.
 * - At time = 10, the CPU finishes task 1 and becomes idle.
 * Example 2:
 *
 * Input: tasks = [[7,10],[7,12],[7,5],[7,4],[7,2]]
 * Output: [4,3,2,0,1]
 * Explanation: The events go as follows:
 * - At time = 7, all the tasks become available. Available tasks = {0,1,2,3,4}.
 * - Also at time = 7, the idle CPU starts processing task 4. Available tasks = {0,1,2,3}.
 * - At time = 9, the CPU finishes task 4 and starts processing task 3. Available tasks = {0,1,2}.
 * - At time = 13, the CPU finishes task 3 and starts processing task 2. Available tasks = {0,1}.
 * - At time = 18, the CPU finishes task 2 and starts processing task 0. Available tasks = {1}.
 * - At time = 28, the CPU finishes task 0 and starts processing task 1. Available tasks = {}.
 * - At time = 40, the CPU finishes task 1 and becomes idle.
 *
 *
 * Constraints:
 *
 * tasks.length == n
 * 1 <= n <= 105
 * 1 <= enqueueTimei, processingTimei <= 109
 */
public class SingleThreadedCPU_LC1834 {

    public int[] getOrder(int[][] tasks) {
        // sort on the processing time first. if they are equal sort on the index
        // { processing time, index of the task}
        Comparator<Integer[]> comparator = (a, b) -> Integer.compare(a[0], b[0]) == 0 ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]);

        // TreeMap key - arrival time - used for Finding tasks in the range of time
        // PriorityQueue (sort by processing time + index)
        TreeMap<Double, PriorityQueue<Integer[]>> map = new TreeMap<>();
        int index = 0;
        for(int[] task : tasks){
            PriorityQueue<Integer[]> taskAtTime = map.getOrDefault((double)task[0], new PriorityQueue<>(comparator));
            Integer[] t = {task[1], index++}; // { processing time, index}
            taskAtTime.add(t);
            map.put((double)task[0], taskAtTime);
        }

        int pos = 0; // used to set the result
        int[] result = new int[tasks.length];


        PriorityQueue<Integer[]> q = new PriorityQueue<>(comparator); // ordering to process the tasks
        q.add(map.get(map.firstKey()).poll()); // add the first task
        double time = map.firstKey();  // set the start time as the first task's time

        while(!q.isEmpty()){
            Integer[] task = q.poll();
            result[pos++] = task[1]; // set the task as processed

            // now, find all the tasks that would have been received while it takes to process this task. i.e current time + processing time of task.
            // and add them to the queue
            SortedMap<Double, PriorityQueue<Integer[]>> tasksAccumulated = map.subMap(time, true, time + task[0], true);
            for(Map.Entry<Double, PriorityQueue<Integer[]>> e : tasksAccumulated.entrySet()){
                while (!e.getValue().isEmpty()){
                    Integer[] k = e.getValue().poll();
                    q.offer(k);
                }
            }
            time = time + task[0]; // move to the time at which the task would have been completed.
            if (q.isEmpty() && map.ceilingKey(time) != null){ // handling corner case, when the next task arrives well beyond the time taken to finish the current task
                q.add(map.get(map.ceilingKey(time)).poll()); // find the next highest time there is a task and add it to the queue.
            }
        }
        return result;
    }
}
