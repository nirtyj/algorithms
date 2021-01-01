package com.leetcode.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Sorted list implementation with Binary Search
 * @param <T>
 */
public class SortedList<T extends Comparable<T>> extends ArrayList<T> {

    @Override
    public boolean add(T mt) {
        int index = Collections.binarySearch(this, mt);
        if (index < 0) index = Math.abs(index) - 1;
        super.add(index, mt);
        return true;
    }

    /**
     * Anonymous overriding method
     * @return
     */
    public List<T> getSortedList() {
        return new ArrayList<T>() {
            public boolean add(T mt) {
                int index = Collections.binarySearch(this, mt);
                if (index < 0) index = Math.abs(index) - 1;
                super.add(index, mt);
                return true;
            }
        };
    }
}
