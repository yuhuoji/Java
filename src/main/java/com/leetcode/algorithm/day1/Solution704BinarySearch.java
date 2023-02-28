package com.leetcode.algorithm.day1;

import org.junit.Test;

/**
 * 左闭右闭即[left, right] -> middle排除
 * 或者左闭右开即[left, right) -> middle还有
 */
public class Solution704BinarySearch {

    //[]
    public int search(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) { //[]会出现left==right，只有一个元素
            int middle = ((right - left) / 2) + left; //防止溢出
            if (nums[middle] > target) { //
                right = middle - 1;
            } else if (nums[middle] < target) { //
                left = middle + 1;
            } else { // ==
                return middle;
            }
        }
        //no result
        return -1;
    }

    //[)
    public int search2(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) { //[)不会出现left==right
            int middle = ((right - left) / 2) + left; //防止溢出
            if (nums[middle] > target) { //
                right = middle;
            } else if (nums[middle] < target) { //
                left = middle + 1;
            } else { // ==
                return middle;
            }
        }
        //no result
        return -1;
    }

    // []
    private int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
        int middle = left + ((right - left) / 2);
            if (nums[middle] > target) { //
                right = middle - 1;
            } else if (nums[middle] < target) { //
                left = middle + 1;
            } else { // ==
                return middle;
            }
        }
        //no result
        return -1;
    }

    // []
    private int binarySearch1(int[] nums, int target, int left, int right) {
        int middle = left + ((right - left) / 2);
        while (left <= right) {
            if (nums[middle] > target) { //
                right = middle - 1;
            } else if (nums[middle] < target) { //
                left = middle + 1;
            } else { // ==
                return middle;
            }
        }
        //no result
        return -1;
    }


    @Test
    public void Solution704BinarySearchTest() {

    }
}
