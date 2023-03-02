package com.leetcode.algorithm.day3;

import org.junit.Test;

import java.util.Arrays;

/**
 * @date 2023-03-02 16:53
 * 数组有序
 * exactly one solution.
 * 下标从1开始
 */
public class Leetcode167TwoSumIIInputArrayIsSorted {
    //双指针
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        //
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum < target) { //小于，增大sum
                low++;
            } else if (sum > target) { //大于，减小sum
                high--;
            } else {
                return new int[]{low+1, high+1};
            }
        }
        return new int[]{-1,-1};
    }

    //二分查找

    @Test
    public void test() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));

    }
}
