package com.leetcode.contest;

import java.util.*;

//TODO @date 2023-11-25 Q4
public class WeeklyContest372 {
    public static void main(String[] args) {
        WeeklyContest372 solution = new WeeklyContest372();

        String s1 = "abc", s2 = "abb", s3 = "ab";
        // System.out.println(solution.findMinimumOperations(s1, s2, s3));

        // String s = "00001";
        // System.out.println(solution.minimumSteps(s));
        // System.out.println(Math.pow(2,50));

        // a = 6, b = 7 , n = 5
        long a = 1, b = 6;
        int n = 3;
        int ans = 12;
        // System.out.println(solution.maximumXorProduct(a, b, n));
        // System.out.println(Integer.toBinaryString(ans));
        System.out.println(Long.toBinaryString(a) + " " + Long.toBinaryString(b));
        System.out.println(Long.toBinaryString((long) Math.pow(2, n) - 1));
        System.out.println(Integer.toBinaryString(ans));
        System.out.println(Long.toBinaryString(a ^ ans) + " " + Long.toBinaryString(b ^ ans));

        System.out.println();
    }

    //2939. 最大异或乘积

    // 尽量填高位1, 让两个数尽量相近
    //(a XOR x) * (b XOR x)
    // x 需要满足 0 <= x < 2^n
    public int maximumXorProduct(long a, long b, int n) {
        int MOD = 1_000_000_007;
        long max = Math.max(a, b);
        int ans = 0;

        return (int) (((long) (ans ^ a) % MOD * (ans ^ b) % MOD) % MOD);
    }

    // 把0和1排序。0的视角或1的视角
    // https://codeforces.com/problemset/problem/804/B
    public long minimumSteps(String s) {
        long ans = 0;
        int cnt1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                cnt1++;
            } else {
                ans += cnt1;
            }
        }
        return ans;
    }

    public long minimumSteps1(String s) {
        int n = s.length();
        long cnt = 0;
        int l = 0, r = n - 1;
        char[] chars = s.toCharArray();
        while (l < r) {
            if (chars[l] == '1' && chars[r] == '1') {
                r--;
            } else if (chars[l] == '0' && chars[r] == '0') {
                l++;
            } else if (chars[l] == '0' && chars[r] == '1') {
                l++;
                r--;
            } else if (chars[l] == '1' && chars[r] == '0') {
                cnt += r - l;
                l++;
                r--;
            }
        }
        return cnt;
    }

    // 100131. 使三个字符串相等
    // 最长公共前缀
    public int findMinimumOperations(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        int n = Math.min(Math.min(n1, n2), n3);
        int i = 0;
        while (i < n && s2.charAt(i) == s1.charAt(i) && s3.charAt(i) == s1.charAt(i)) {
            i++;
        }
        // 否则，返回删除字符的总次数
        return i == 0 ? -1 : n1 + n2 + n3 - 3 * i;
    }
}
