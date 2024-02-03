package com.leetcode.contest;

import com.leetcode.helper.LeetCodeHelper;

import java.util.*;

public class WeeklyContest382 {
    public static void main(String[] args) {
        WeeklyContest382 solution = new WeeklyContest382();

    }

    // 位运算 最多k次，贪心？
    // 按位 OR 结果的 最小值
    // &
    public int minOrAfterOperations(int[] nums, int k) {
        return 0;
    }

    // x+y是奇数
    public long flowerGame(int n, int m) {
        return (long) n * m / 2;
    }

    public long flowerGame1(int n, int m) {
        long ans = 0;
        int evenN = n / 2;
        int oddN = n - evenN;
        int evenM = m / 2;
        int oddM = m - evenM;
        ans += (long) evenN * oddM;
        ans += (long) oddN * evenM;
        return ans;
    }

    // 数据是指数增长，枚举x
    public int maximumLength(int[] nums) {
        Map<Long, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            // cnt.merge((long) x, 1, Integer::sum);
            cnt.put((long) x, cnt.getOrDefault((long) x, 0) + 1);
        }
        Integer cnt1 = cnt.remove(1L);
        int ans = cnt1 != null ? cnt1 - 1 | 1 : 0; // 结果一定是奇数
        for (long x : cnt.keySet()) { // 枚举
            int res = 0;
            for (; cnt.getOrDefault(x, 0) > 1; x *= x) {
                res += 2;
            }
            ans = Math.max(ans, res + (cnt.containsKey(x) ? 1 : -1)); // 有最后一个就加1，没有则减去1，保证 res 是奇数
        }
        return ans;
    }

    // 位运算
    // 1 3 5 ...
    public int maximumLength1(int[] nums) {
        Arrays.sort(nums);
        int mx = 1;
        Map<Integer, Integer> freg = new HashMap<>();  // 计数
        for (int num : nums) {
            freg.put(num, freg.getOrDefault(num, 0) + 1);
        }
        int cnt = 0;
        for (int num : nums) {
            int x = num;
            cnt = 0;
            while (freg.containsKey(x) && freg.get(x) >= 1) {
                if (freg.get(x) >= 2) {
                    freg.put(x, freg.get(x) - 2);
                    cnt += 2;
                    x *= x;
                } else if (freg.get(x) == 1) { // 退出
                    freg.put(x, freg.get(x) - 1);
                    cnt += 1;
                    break;
                }
            }
            if (cnt % 2 == 0) {
                cnt--;
            }
            mx = Math.max(mx, cnt);
        }
        return mx;
    }

    public int countKeyChanges(String s) {
        int cnt = 0;
        for (int i = 1; i < s.length(); ++i) {
            if ((s.charAt(i) & 31) != (s.charAt(i - 1) & 31)) {
                cnt++;
            }
        }
        return cnt;
    }

    public int countKeyChanges1(String s) {
        String s1 = s.toLowerCase();
        int cnt = 0;
        for (int i = 1; i < s1.length(); i++) {
            if (s1.charAt(i) != s1.charAt(i - 1)) {
                cnt++;
            }
        }
        return cnt;
    }
}
