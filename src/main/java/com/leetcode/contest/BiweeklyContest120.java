package com.leetcode.contest;

import java.util.Arrays;

public class BiweeklyContest120 {
    public static void main(String[] args) {
        BiweeklyContest120 solution = new BiweeklyContest120();
        int m = 6;
    }

    // 2971. 找到最大周长的多边形
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        for (int x : nums) {
            sum += x;
        }
        // sum = Arrays.stream(nums).sum(); // 求数组元素和
        int n = nums.length;
        for (int i = n - 1; i >= 1; --i) {
            int x = nums[i];
            // sum-x左侧的元素和 x最大的边
            if (sum - x > x) {
                return sum;
            }
            sum -= x;
        }
        return -1;
    }

    public int incremovableSubarrayCount(int[] nums) {
        int cnt = 0;


        return cnt;
    }
}
