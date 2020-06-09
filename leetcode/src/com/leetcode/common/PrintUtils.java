package com.leetcode.common;

import java.util.Arrays;

public class PrintUtils {

    public static void print(int[][] dp){
        System.out.println(Arrays.deepToString(dp).replace("], ", "]\n")
                .replace("[[", "[").replace("]]", "]"));
    }

    public static void print(Object[][] dp){
        System.out.println(Arrays.deepToString(dp).replace("], ", "]\n")
                .replace("[[", "[")
                .replace("null", " ")
                .replace("]]", "]"));
    }
}
