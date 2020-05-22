package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, return a sorted array of only the integers that appeared in all three arrays.
 *
 *
 *
 * Example 1:
 *
 * Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
 * Output: [1,5]
 * Explanation: Only 1 and 5 appeared in the three arrays.
 *
 *
 * Constraints:
 *
 * 1 <= arr1.length, arr2.length, arr3.length <= 1000
 * 1 <= arr1[i], arr2[i], arr3[i] <= 2000
 */
public class IntersectionOfThreeSortedArrays {

    /**
     * 2ms
     * @param arr1
     * @param arr2
     * @param arr3
     * @return
     */
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        int index1 = 0, index2 = 0, index3 = 0;
        int[] array1 = (arr1.length <= arr2.length && arr1.length <= arr3.length) ? arr1 : (arr2.length <= arr1.length && arr2.length <= arr3.length) ? arr2 : arr3;
        int[] array2 = arr2;
        int[] array3 = arr3;
        if (array1 == arr2) {
            array2 = arr1;
        } else if (array1 == arr3) {
            array3 = arr1;
        }
        while (index1 < array1.length) {
            while (index2 < array2.length - 1 && array2[index2] < array1[index1]) {
                index2++;
            }
            while (index3 < array3.length - 1 && array3[index3] < array1[index1]) {
                index3++;
            }
            if (array1[index1] == array2[index2] && array1[index1] == array3[index3]) {
                result.add(array1[index1]);
            }
            index1++;
        }
        return result;
    }

    public List<Integer> arraysIntersectionSmall(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<Integer>();
        int p1 = 0, p2 = 0, p3 = 0;
        while (p1 < arr1.length && p2 < arr2.length && p3 < arr3.length) {
            if (arr1[p1] == arr2[p2] && arr1[p1] == arr3[p3]) {
                result.add(arr1[p1]);
                p1++;
                p2++;
                p3++;
            } else if (arr1[p1] < arr2[p2]) {
                p1++;
            } else if (arr2[p2] < arr3[p3]) {
                p2++;
            } else {
                p3++;
            }
        }
        return result;
    }
}
