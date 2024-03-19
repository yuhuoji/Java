package com.leetcode.contest;

import java.util.Arrays;


public class WeeklyContest388 {

    public static void main(String[] args) {
        WeeklyContest388 solution = new WeeklyContest388();
        // happiness = [1,2,3], k = 2
        int[] happiness = {12, 1, 42};
        int k = 3;
        System.out.println(solution.maximumHappinessSum(happiness, k));
    }

    // 3077. K 个不相交子数组的最大能量值
    // 划分型dp
    public long maximumStrength(int[] nums, int k) {
        return 0;
    }

    // 暴力
    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        String[] ans = new String[n];
        for (int i = 0; i < n; ++i) { // 每个位置计算答案
            int len = arr[i].length();
            String res = "";
            for (int size = 1; size <= len && res.isEmpty(); ++size) { // 枚举子字符串的长度
                for (int j = size; j <= len; ++j) { // 子字符串的结尾
                    String t = arr[i].substring(j - size, j);
                    if ((res.isEmpty() || t.compareTo(res) < 0) && check(arr, i, t)) {
                        res = t;
                    }
                }
            }
            ans[i] = res;
        }
        return ans;
    }

    private boolean check(String[] arr, int cur, String sub) {
        for (int i = 0; i < arr.length; ++i) {
            if (i != cur && arr[i].contains(sub)) {
                return false;
            }
        }
        return true;
    }

    public long maximumHappinessSum(int[] happiness, int k) {
        long ans = 0;
        int n = happiness.length;
        Arrays.sort(happiness);
        // n - 1 - i
        for (int i = n - 1; i >= n - k && happiness[i] > n - 1 - i; --i) {
            ans += happiness[i] - (n - 1 - i);
        }
        return ans;
    }

    public int minimumBoxes(int[] apple, int[] capacity) {
        int n = apple.length;
        int m = capacity.length;
        Arrays.sort(capacity);
        int sum = 0;
        for (int x : apple) {
            sum += x;
        }
        int i = m - 1;
        for (; i >= 0 && sum > 0; --i) {
            sum -= capacity[i];
        }
        return m - i - 1;
    }
}
