package com.leetcode.hard;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 *
 * For example,
 * [2,3,4], the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 *
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 *
 *
 * Example:
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 *
 * Follow up:
 *
 * If all integer numbers from the stream are between 0 and 100, how would you optimize it?
 * If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 */
public class MedianFinder_LC295 {


    PriorityQueue<Integer> maxHeapForLeft;
    PriorityQueue<Integer> minHeapForRight;

    /** initialize your data structure here. */
    public MedianFinder_LC295() {
        this.maxHeapForLeft = new PriorityQueue<>(Collections.reverseOrder());
        this.minHeapForRight = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeapForLeft.size() == 0) {
            maxHeapForLeft.offer(num);
        } else if (num <= maxHeapForLeft.peek()){
            maxHeapForLeft.offer(num);
        } else {
            minHeapForRight.offer(num);
        }
        if (maxHeapForLeft.size() - minHeapForRight.size() > 1){ // rebalance the max heap. always okay to maintain one extra on the maxHeap for odd case
            int prevTop = maxHeapForLeft.poll();
            minHeapForRight.offer(prevTop);
        }
        if (minHeapForRight.size() - maxHeapForLeft.size() > 0){ // rebalance the min heap. move the odd one to the max heap.
            int prevTop = minHeapForRight.poll();
            maxHeapForLeft.offer(prevTop);
        }
    }

    public double findMedian() {
        if ((maxHeapForLeft.size() + minHeapForRight.size()) % 2 == 0){
            int one = maxHeapForLeft.peek();
            int two = minHeapForRight.peek();
            return (double) (one + two) / 2;
        } else {
            int one = maxHeapForLeft.peek();
            return one;
        }
    }
}
// Other Solutions
/**
 * Buckets!
 *  Keep buckets sorted. find the right bucket and pick the median.
 *
 *  Buckets can be distributed if needed. and hashing can yield right range.
 *
 * If the numbers in the stream are statistically distributed, then it is easier to keep track of buckets
 * where the median would land, than the entire array. Once you know the correct bucket, simply sort it find the median.
 * If the bucket size is significantly smaller than the size of input processed,
 * this results in huge time saving. @mitbbs8080 has an interesting implementation here.
 */