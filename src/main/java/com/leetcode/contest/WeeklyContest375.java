package com.leetcode.contest;

import com.leetcode.helper.LeetCodeHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 第一次ac了三题 >^<
public class WeeklyContest375 {
    public static void main(String[] args) {
        WeeklyContest375 solution = new WeeklyContest375();
        String s = "[21,11,13,15,16,21,8,9,6,21]";
        int k = 2;
        System.out.println(solution.countSubarrays(LeetCodeHelper.stringToIntegerArray(s), k));

    }

    // 56. 合并区间
    public int numberOfGoodPartitions(int[] nums) {
        int MOD = 1_000_000_009;
        return 0;
    }

    // 滑动窗口 left-1合法左端点的最大值
    // 子数组 前缀和
    // O(N^2) TLE
    // LC713
    // LC560
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max = nums[0];
        for (int x : nums) {
            max = Math.max(max, x);
        }
        int cntMax = 0;
        long ans = 0;
        for (int l = 0, r = 0; r < n; ++r) {
            if (nums[r] == max) {
                cntMax++;
            }
            while (cntMax >= k) { // left右移
                if (nums[l] == max) {
                    cntMax--;
                }
                l++;
            }
            // left-1找到合法左端点的最大值
            ans += l; //[0,l-1]
        }
        return ans;
    }

    // 周赛答案 wa2
    public long countSubarrays1(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        int max = nums[0];
        for (int x : nums) { // 找出最大值
            max = Math.max(max, x);
        }
        //[i,j]
        int cnt = 0; // 当前次数
        Map<Integer, Integer> mp = new HashMap<>(); // 统计max次数-次数
        Map<Integer, Integer> idxMp = new HashMap<>(); // 统计 cnt 的最后一个下标
        mp.put(0, 1);
        idxMp.put(0, -1);
        for (int i = 0; i < n; ++i) { // 遍历所有位置
            if (nums[i] == max) {
                cnt++;
            }
            // cnt-k + k = cnt
            // 统计 cnt - k >= 0 的次数
            if (mp.containsKey(cnt - k)) {
                int idx = idxMp.get(cnt - k);
                ans += idx + 2;
            }
            mp.put(cnt, mp.getOrDefault(cnt, 0) + 1);
            idxMp.put(cnt, i); // 最后一个cnt的下标
        }
        return ans;
    }

    // 数学 快速幂
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        int n = variables.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int a = variables[i][0] % 10, b = variables[i][1], c = variables[i][2], m = variables[i][3];
            int res = pow(a, b, 10); //(ai^bi % 10)
            res = pow(res, c, m); //
            if (res == target) {
                ans.add(i);
            }
        }
        return ans;
    }

    // LC50
    private int pow(int x, int n, int mod) {
        int ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans *= x;
            }
            x *= x;
            n >>= 1;
        }
        return ans;
    }

    // REVIEW @date 2023-12-10
    // 快速幂 递归
    // private int pow(int base, int exponent, int modulus) {
    //     if (exponent == 0) {
    //         return 1;
    //     }
    //     int half = pow(base, exponent / 2, modulus);
    //     return exponent % 2 == 0 ? (int) ((long) half * half % modulus) : (int) ((long) half * half % modulus * base % modulus);
    // }

    // 模拟
    public int countTestedDevices(int[] batteryPercentages) {
        int n = batteryPercentages.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (batteryPercentages[i] - ans > 0) { // 测试
                ans++;
            }
            // 移动
        }
        return ans;
    }

}
