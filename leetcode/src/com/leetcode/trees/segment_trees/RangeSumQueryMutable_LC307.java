package com.leetcode.trees.segment_trees;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * The update(i, val) function modifies nums by updating the element at index i to val.
 *
 * Example:
 *
 * Given nums = [1, 3, 5]
 *
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 *
 *
 * Constraints:
 *
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 * 0 <= i <= j <= nums.length - 1
 *
 *
 * https://stackoverflow.com/questions/28470692/how-is-the-memory-of-the-array-of-segment-tree-2-2-ceillogn-1
 *
 * https://leetcode.com/articles/a-recursive-approach-to-segment-trees-range-sum-queries-lazy-propagation/
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/SegmentTree.java
 */
public class RangeSumQueryMutable_LC307 {

    int segmentTree[];
    int nums[];

    public RangeSumQueryMutable_LC307(int[] nums) {
        this.nums = nums;
        if (nums.length == 0){
            return;
        }
        // Thus, we have (n) leaf nodes, and also (n-1) internal nodes
        // Total number of nodes = n + (n-1) = 2n-1 Now, we know its a full binary tree and thus the height is: ceil(Log2(n)) +1
        // finding the levels of the tree
        // log2 N = log10 N / log10 2
        // height of the tree is
        // ceil(Log2(n)) + 1
        int levels = (int) Math.ceil(Math.log(nums.length) / Math.log(2)); // or next power of 2.
        int height = levels + 1;
        // If binary tree has height h, minimum number of nodes is h;  maximum number of nodes: 2^(h)-1
        // OR Just use 4 * N
        segmentTree = new int[(int) (Math.pow(2, height) -1)];
        constructTree(0, nums.length - 1, 0);
    }

    /**
     * Preferred - Bottom up
     * @param i
     * @param val
     */
    public void update(int i, int val) {
        updateValSegTreeBottomUp(0, 0, nums.length-1, i, val);
    }

    void updateValSegTreeBottomUp(int treeIndex, int lo, int hi, int arrIndex, int val)
    {
        if (lo == hi) {// leaf node. update element.
            segmentTree[treeIndex] = val;
            return;
        }
        int mid = lo + (hi - lo) / 2;   // recurse deeper for appropriate child

        // first go update the left node's value.
        if (arrIndex > mid)
            updateValSegTreeBottomUp(2 * treeIndex + 2, mid + 1, hi, arrIndex, val);
        else if (arrIndex <= mid)
            updateValSegTreeBottomUp(2 * treeIndex + 1, lo, mid, arrIndex, val);

        // update sum later.
        segmentTree[treeIndex] = segmentTree[2 * treeIndex + 1] + segmentTree[2 * treeIndex + 2];
    }

    public int sumRange(int i, int j) {
        return rangeQuery(0, nums.length - 1, i, j, 0);
    }

    private int rangeQuery(int low, int high, int qlow, int qhigh, int pos) {
        if (high < qlow || qhigh < low) { // no overlap : [low <= high] < [qlow <= qhigh] (or)  [qlow <= qhigh] < [low <= high]
            return 0;
        }
        if (qlow <= low && high <= qhigh) { // full overlap : qlow <= low <= high <= qhigh
            return segmentTree[pos];
        }
        int mid = (low + high) / 2;
        return rangeQuery(low, mid, qlow, qhigh, 2 * pos + 1) + rangeQuery(mid + 1, high, qlow, qhigh, 2 * pos + 2);
    }

    private void constructTree(int low, int high, int pos) {
        if (low == high) {
            segmentTree[pos] = nums[low];
            return;
        }
        int mid = (low + high) / 2;
        constructTree(low, mid, 2 * pos + 1);
        constructTree(mid + 1, high, 2 * pos + 2);
        segmentTree[pos] = segmentTree[2 * pos + 1] + segmentTree[2 * pos + 2];
    }

    static class LazyPropagation {

        int segmentTree[];
        int nums[];
        int lazy[];


        public LazyPropagation(int[] nums) {
            this.nums = nums;
            if (nums.length == 0){
                return;
            }
            // Thus, we have (n) leaf nodes, and also (n-1) internal nodes
            // Total number of nodes = n + (n-1) = 2n-1 Now, we know its a full binary tree and thus the height is: ceil(Log2(n)) +1
            // finding the levels of the tree
            // log2 N = log10 N / log10 2
            // height of the tree is
            // ceil(Log2(n)) + 1
            int levels = (int) Math.ceil(Math.log(nums.length) / Math.log(2)); // or next power of 2.
            int height = levels + 1;
            // If binary tree has height h, minimum number of nodes is h;  maximum number of nodes: 2^(h)-1
            // OR Just use 4 * N
            segmentTree = new int[(int) (Math.pow(2, height) -1)];
            lazy = new int[segmentTree.length];
            constructTree(0, nums.length - 1, 0);
        }

        private void constructTree(int low, int high, int pos) {
            if (low == high) {
                segmentTree[pos] = nums[low];
                return;
            }
            int mid = (low + high) / 2;
            constructTree(low, mid, 2 * pos + 1);
            constructTree(mid + 1, high, 2 * pos + 2);
            segmentTree[pos] = segmentTree[2 * pos + 1] + segmentTree[2 * pos + 2];
        }

        public void update(int i, int val) {
           // TODO
        }

        void updateLazySegTree(int treeIndex, int lo, int hi, int i, int j, int val)
        {
            if (lazy[treeIndex] != 0) {                             // this node is lazy
                segmentTree[treeIndex] += (hi - lo + 1) * lazy[treeIndex]; // normalize current node by removing laziness

                if (lo != hi) {                                     // update lazy[] for children nodes
                    lazy[2 * treeIndex + 1] += lazy[treeIndex];
                    lazy[2 * treeIndex + 2] += lazy[treeIndex];
                }

                lazy[treeIndex] = 0;                                // current node processed. No longer lazy
            }

            if (lo > hi || lo > j || hi < i)
                return;                                             // out of range. escape.

            if (i <= lo && hi <= j) {                               // segment is fully within update range
                segmentTree[treeIndex] += (hi - lo + 1) * val;             // update segment

                if (lo != hi) {                                     // update lazy[] for children
                    lazy[2 * treeIndex + 1] += val;
                    lazy[2 * treeIndex + 2] += val;
                }

                return;
            }

            int mid = lo + (hi - lo) / 2;                             // recurse deeper for appropriate child

            updateLazySegTree(2 * treeIndex + 1, lo, mid, i, j, val);
            updateLazySegTree(2 * treeIndex + 2, mid + 1, hi, i, j, val);

            // merge updates
            segmentTree[treeIndex] = segmentTree[2 * treeIndex + 1] + segmentTree[2 * treeIndex + 2];
        }

        public int sumRange(int i, int j) {
            return queryLazySegTree(0, 0,nums.length - 1, i, j);
        }

        int queryLazySegTree(int treeIndex, int lo, int hi, int i, int j)
        {
            // query for arr[i..j]

            if (lo > j || hi < i)                                   // segment completely outside range
                return 0;                                           // represents a null node

            if (lazy[treeIndex] != 0) {                             // this node is lazy
                segmentTree[treeIndex] += (hi - lo + 1) * lazy[treeIndex]; // normalize current node by removing laziness

                if (lo != hi) {                                     // update lazy[] for children nodes
                    lazy[2 * treeIndex + 1] += lazy[treeIndex];
                    lazy[2 * treeIndex + 2] += lazy[treeIndex];
                }

                lazy[treeIndex] = 0;                                // current node processed. No longer lazy
            }

            if (i <= lo && j >= hi)                                 // segment completely inside range
                return segmentTree[treeIndex];

            int mid = lo + (hi - lo) / 2;                           // partial overlap of current segment and queried range. Recurse deeper.

            if (i > mid)
                return queryLazySegTree(2 * treeIndex + 2, mid + 1, hi, i, j);
            else if (j <= mid)
                return queryLazySegTree(2 * treeIndex + 1, lo, mid, i, j);

            int leftQuery = queryLazySegTree(2 * treeIndex + 1, lo, mid, i, mid);
            int rightQuery = queryLazySegTree(2 * treeIndex + 2, mid + 1, hi, mid + 1, j);

            // merge query results
            return leftQuery + rightQuery;
        }
    }

}
