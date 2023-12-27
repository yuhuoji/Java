package com.leetcode.contest;

import com.leetcode.helper.LeetCodeHelper;

import java.util.*;

public class WeeklyContest377 {
    public static void main(String[] args) {
        WeeklyContest377 solution = new WeeklyContest377();
        int m = 4;
        int n = 3;
        String h = "[2,3]";
        String v = "[2]";
        // Set<Integer> s = solution.getGap(LeetCodeHelper.stringToIntegerArray(v), n);
        // System.out.println(s);
        System.out.println(solution.maximizeSquareArea(m, n, LeetCodeHelper.stringToIntegerArray(h), LeetCodeHelper.stringToIntegerArray(v)));
    }

    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        return 0;
    }

    // 图
    // 全源最短路 floyd
    //TODO @date 2023-12-27 双周赛LC2959 每日一题1334
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int ans = -1;
        List<int[]>[] g = new ArrayList[26];
        Arrays.setAll(g, i -> new ArrayList<>());
        int n = original.length;
        for (int i = 0; i < n; ++i) {
            g[original[i] - 'a'].add(new int[]{changed[i] - 'a', cost[i]}); // 有一条权为cost的边，进行转换
        }

        return ans;
    }

    // wa 注意取模和转型
    // LC 2943
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int MOD = 1_000_000_007;
        int ans = -1;
        Set<Integer> hGap = getGap(hFences, m);
        Set<Integer> vGap = getGap(vFences, n);
        for (int x : hGap) {
            if (vGap.contains(x)) {
                ans = Math.max(ans, x);
            }
        }
        return ans == -1 ? -1 : (int) ((long) ans * ans % MOD); // 注意顺序
    }

    // 返回所有可能的间隔组合
    private Set<Integer> getGap(int[] f, int size) {
        int n = f.length;
        f = Arrays.copyOf(f, n + 2);
        f[n] = 1;
        f[n + 1] = size;
        Arrays.sort(f);
        Set<Integer> ans = new HashSet<>(); // 有序
        for (int i = 0; i < f.length; ++i) {
            for (int j = i + 1; j < f.length; ++j) {
                ans.add(f[j] - f[i]);
            }
        }
        return ans;
    }


    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 1; i < n; i += 2) {
            int tmp = nums[i];
            nums[i] = nums[i - 1];
            nums[i - 1] = tmp;
        }
        return nums;
    }
}
