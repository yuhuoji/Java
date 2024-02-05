package com.leetcode.contest;

import com.leetcode.helper.LeetCodeHelper;

import java.util.*;

public class WeeklyContest383 {
    public static void main(String[] args) {
        WeeklyContest383 solution = new WeeklyContest383();
        String word = "abacaba";
        int k = 3;
        System.out.println(solution.minimumTimeToInitialState(word, k));
    }

    public int[][] resultGrid(int[][] image, int threshold) {
        return null;
    }

    //？dp
    // Q2 Q4
    public int minimumTimeToInitialState(String word, int k) {
        int n = word.length();
        int ans = lcm(n, k) / k;
        for (int i = n - 1; i > 0; --i) { // 检查[i,n-1]是否是前缀
            String s = word.substring(i);
            if (isPrefix(word, s)) {
                if (i % k == 0) {
                    ans = Math.min(ans, i / k);
                } else {
                    ans = Math.min(ans, lcm(i, k));
                }
            }
        }
        return ans;
    }

    private boolean isPrefix(String word, String s) {
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (word.charAt(i) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private int gcd(int a, int b) {
        int remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    // Q1
    public int returnToBoundaryCount(int[] nums) {
        int n = nums.length;
        int sum = 0, ans = 0;
        for (int x : nums) {
            sum += x;
            if (sum == 0) {
                ans++;
            }
        }
        return ans;
    }
}
