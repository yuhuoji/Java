package com.leetcode.contest;

import com.leetcode.helper.LeetCodeHelper;

import java.util.*;

// TODO @date 2023-12-03
public class WeeklyContest374 {
    public static void main(String[] args) {
        WeeklyContest374 solution = new WeeklyContest374();
        String s = "[1,1,1]";
        int target = 19;
        System.out.println(solution.minimumAddedCoins(LeetCodeHelper.stringToIntegerArray(s), target));
    }

    // 洪水填充？
    // dp
    public int numberOfSequence(int n, int[] sick) {
        int MOD = 1_000_000_009;
        int k = sick.length;
        // n-k轮后全部感染
        int ans = 0;
        int[] dp = new int[n];
        boolean[] sickable = new boolean[n];
        Set<Integer> st = new HashSet<>();
        for (int x : sick) {
            st.add(x);
        }
        for (int i = 0; i < n; ++i) {
            if (st.contains(i)) { // 已经被感染了
                sickable[i] = false;
            } else if (i != 0 && st.contains(i - 1) || i != n - 1 && st.contains(i + 1)) { // 当前可以被感染
                sickable[i] = true;
            } else { // 接触不到

            }
        }


        return ans;
    }


    // 2953. 统计完全子字符串
    // 子字符串长度为k的倍数
    // 滑动窗口 k倍数
    public int countCompleteSubstrings(String word, int k) {
        return 0;
    }

    // [1, max] 看max增长的快还是coin增长的快
    // 贪心
    // 最少的组合 1 2 4 8 16 ... 等比数列
    // n*log n + log t
    public int minimumAddedCoins(int[] coins, int target) {
        int n = coins.length;
        Arrays.sort(coins);
        int cnt = 0;
        int max = 1;
        int idx = 0; // 遍历所有硬币
        // 当前能组成的范围[0,max-1] 直到能组成target
        while (max <= target) {
            // 当前找max;
            if (idx < n && coins[idx] <= max) { // 直接用当前硬币 [0,max-1] + coin
                max += coins[idx];
                idx++;
            } else { // 增加(max)的硬币 or 所有硬币用完了
                cnt++;
                max *= 2;
            }
        }
        return cnt;
    }

    public List<Integer> findPeaks(int[] mountain) {
        int n = mountain.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < n - 1; ++i) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                ans.add(i);
            }
        }
        return ans;
    }
}
