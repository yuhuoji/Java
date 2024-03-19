package com.leetcode.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WeeklyContest389 {

    public static void main(String[] args) {
        WeeklyContest389 solution = new WeeklyContest389();
        String word = "aaabaaa";
        int k = 2;
        System.out.println(solution.minimumDeletions(word, k));
    }

    public long minimumMoves(int[] nums, int k, int maxChanges) {
        return 0;
    }

    // [4, 2, 1,
    // [1, 2, 3, 5,
    // [6, 1
    // 求保留最多多少字母
    // 出现最多 - 最少 = maxSave
    // 枚举出现次数最少的字母 base
    public int minimumDeletions(String word, int k) {
        int[] cnt = new int[26];
        for (char c : word.toCharArray()) {
            cnt[c - 'a']++;
        }
        Arrays.sort(cnt);
        int maxSave = 0;
        for (int i = 0; i < 26; ++i) { // 枚举出现次数最少的字母
            int sum = 0;
            for (int j = i; j < 26; ++j) {
                sum += Math.min(cnt[j], cnt[i] + k); // 最多为cnt[i]+k
            }
            maxSave = Math.max(maxSave, sum);

        }
        return word.length() - maxSave;
    }

    // k
    // k + C(2,k)
    public long countSubstrings(String string, char c) {
        // char[] s = string.toCharArray();
        // int k = 0;
        // for (char x : s) {
        //     if (x == c) {
        //         k++;
        //     }
        // }
        long k = string.chars().filter(ch -> ch == c).count();
        return (long) k * (k + 1) / 2;
    }

    public boolean isSubstringPresent(String string) {
        char[] s = string.toCharArray();
        boolean[][] vis = new boolean[26][26];
        int n = string.length();
        for (int i = 1; i < n; ++i) {
            int x = s[i - 1] - 'a';
            int y = s[i] - 'a';
            vis[x][y] = true;
            if (vis[y][x]) {
                return true;
            }
        }
        return false;
    }

    public boolean isSubstringPresent1(String s) {
        StringBuilder sb = new StringBuilder(s).reverse();
        String reversed = sb.toString();
        for (int i = 2; i <= s.length(); ++i) {
            String t = s.substring(i - 2, i);
            if (reversed.contains(t)) {
                return true;
            }
        }
        return false;
    }
}
