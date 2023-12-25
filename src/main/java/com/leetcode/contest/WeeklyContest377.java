package com.leetcode.contest;

import com.leetcode.helper.LeetCodeHelper;

import java.util.*;

public class WeeklyContest377 {
    public static void main(String[] args) {
        WeeklyContest377 solution = new WeeklyContest377();
        int m = 6;
        int n = 7;
        String h = "[2]";
        String v = "[4]";
        Set<Integer> s = solution.getGap(LeetCodeHelper.stringToIntegerArray(v), n);
        // System.out.println(s);
        System.out.println(solution.maximizeSquareArea(m, n, LeetCodeHelper.stringToIntegerArray(h), LeetCodeHelper.stringToIntegerArray(v)));
    }

    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        return 0;
    }

    // 图？
    // 有向带权图最短路 松弛
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

    // wa
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int MOD = 1_000_000_007;
        int ans = -1;
        Arrays.sort(hFences);
        Arrays.sort(vFences);
        Set<Integer> hGap = getGap(hFences, m);
        Set<Integer> vGap = getGap(vFences, n);
        System.out.println(hGap);
        System.out.println(vGap);
        for (int gap : hGap) {
            if (vGap.contains(gap)) {
                ans = Math.max(ans, gap);
            }
        }
        return ans == -1 ? -1 : ((ans % MOD) * (ans % MOD)) % MOD;
    }

    // 返回所有可能的间隔组合
    private Set<Integer> getGap(int[] f, int size) {
        Set<Integer> ans = new TreeSet<>(); // 有序
        int n = f.length + 2;
        int[] fences = new int[n];
        fences[0] = 1;
        fences[n - 1] = size;
        for (int i = 1; i < n - 1; ++i) {
            fences[i] = f[i - 1];
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                ans.add(fences[i] - fences[j]);
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
