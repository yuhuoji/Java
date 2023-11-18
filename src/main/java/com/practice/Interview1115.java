package com.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Interview1115 {
    // @date 2023-11-15
    // 最长不重复的子串
    // abcdaa abc
    // aaabcdab
    // cabcdaa
    public static void main(String[] args) {
        String s = "cabcdaa";
        System.out.println(maxString(s));
        System.out.println(maxString1(s));

        // System.out.println(Integer.toBinaryString(7));
        // System.out.println(Integer.toBinaryString(4));
    }

    // 用26位长的数组记录最后出现的位置，可以直接跳转左端点
    // int[] last = new int[26];
    public static String maxString(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int map = 0; // 0..25位记录26个字母是否出现过
        int maxLen = 1;
        int maxStart = 0;
        int l = 0;
        for (int r = 0; r < n; ++r) {
            int cur = chars[r] - 'a';
            while ((map & (1 << cur)) == (1 << cur)) { // 存在，左端点右移
                map &= ~(1 << (chars[l] - 'a')); // 删除
                l++;
            }

            map |= (1 << cur); // 加入集合

            if (r - l + 1 > maxLen) {
                maxLen = r - l + 1;
                maxStart = l;
            }
        }
        return s.substring(maxStart, maxStart + maxLen);
    }

    // 滑动窗口 窗口内一种字符只能出现一次
    public static String maxString1(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        Map<Character, Integer> mp = new HashMap<>();
        int maxLen = 1;
        int maxStart = 0;
        int l = 0;
        //[]
        for (int r = 0; r < n; ++r) { // 枚举右端点
            while (mp.containsKey(chars[r])) {
                mp.remove(chars[l]);
                l++;
            }

            mp.put(chars[r], 1);

            if (r - l + 1 > maxLen) {
                maxLen = r - l + 1;
                maxStart = l;
            }
        }
        return s.substring(maxStart, maxStart + maxLen);
    }
}
