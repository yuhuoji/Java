package com.leetcode.contest;

import com.leetcode.helper.LeetCodeHelper;

import java.util.*;

// Q3Q4 中位数贪心
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

    // 2967
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

    // 2966. 划分数组并满足最大差限制
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums); // 和顺序没关系
        int n = nums.length;
        int[][] ans = new int[n / 3][3];
        // i-2 i-1 i
        for (int i = 2; i < n; i += 3) { // 枚举最后一个数
            if (nums[i] - nums[i - 2] > k) {
                return new int[][]{}; // 空数组
            }
            ans[i / 3] = new int[]{nums[i - 2], nums[i - 1], nums[i]};
        }
        return ans;
    }

    // 2965. 找出缺失和重复的数字
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] cnt = new int[n * n + 1]; // 1..n^2
        for (int[] row : grid) {
            for (int x : row) {
                cnt[x]++;
            }
        }
        int a = 0, b = 0;
        for (int i = 1; i <= n * n; ++i) {
            if (cnt[i] == 2) {
                a = i;
            } else if (cnt[i] == 0) {
                b = i;
            }
        }
        return new int[]{a, b};
    }

    public int[] findMissingAndRepeatedValues1(int[][] grid) {
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
