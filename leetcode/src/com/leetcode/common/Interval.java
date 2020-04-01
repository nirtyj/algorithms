package com.leetcode.common;

public class Interval {
    public int start;
    public int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public Interval() {
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}