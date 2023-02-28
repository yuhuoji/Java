package com.leetcode.solution;

import org.junit.Test;

/*1. 两数之和*/
public class Solution1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        /*抛出异常 也可以不用*/
        throw new IllegalArgumentException("Now two sum solution");
    }

    @Test
    public void test() {
        System.out.println("test");
    }
}