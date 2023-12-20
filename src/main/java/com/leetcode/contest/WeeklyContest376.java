package com.leetcode.contest;

import com.leetcode.helper.LeetCodeHelper;

import java.util.*;

public class WeeklyContest376 {
    public static void main(String[] args) {
        WeeklyContest376 solution = new WeeklyContest376();
        String s = "[1,3,4,8,7,9,3,5,1]";
        int k = 2;
        int[][] ans = solution.divideArray(LeetCodeHelper.stringToIntegerArray(s), k);
    }

    // dp
    public int maxFrequencyScore(int[] nums, long k) {
        Arrays.sort(nums);
        int n = nums.length;


        return 0;
    }

    //|nums[i] - x|尽量小
    // x尽量靠中间，离中位数最近的一个回文数
    // dp? 前n个
    // y<10^9
    public long minimumCost(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n + 1];

        long cost = 0;
        return cost;
    }

    private boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // 100161. 划分数组并满足最大差限制
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums); // 和顺序没关系
        int n = nums.length;
        int[][] ans = new int[n / 3][3];

        // i i+1 i+2
        for (int i = 0; i < n; i += 3) {
            int x = nums[i], y = nums[i + 1], z = nums[i + 2];
            if (z - x > k) {
                return new int[0][]; // 空数组
            }
            ans[i / 3][i % 3] = x;
            ans[i / 3][i % 3 + 1] = y;
            ans[i / 3][i % 3 + 2] = z;
        }
        return ans;
    }

    // 100149. 找出缺失和重复的数字
    // 和
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        Set<Integer> seen = new HashSet<>();
        int sum = 0;
        int duplicate = -1;

        for (int[] g : grid) {
            for (int x : g) {
                if (seen.contains(x)) {
                    duplicate = x;
                } else {
                    seen.add(x);
                }
                sum += x;
            }
        }
        int targetSum = n * n * (n * n + 1) / 2;
        int missing = targetSum - sum + duplicate;
        return new int[]{duplicate, missing};
    }
}
