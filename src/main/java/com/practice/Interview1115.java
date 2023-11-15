package com.practice;

import java.util.Arrays;
import java.util.HashMap;

public class Interview1115 {
    // @date 2023-11-15
    // 最长不重复的子串
    // abcdaa abc
    // aaabcdab
    // cabcdaa
    public static void main(String[] args) {
        String s = "cabcdaa";
        System.out.println(maxString(s));
    }

    public static String maxString(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] lastIndex = new int[128];
        Arrays.fill(lastIndex, -1);

        int maxLen = 1;
        int maxStart = 0;
        int l = 0;

        for (int r = 0; r < n; ++r) {
            char currentChar = chars[r];
            // 如果字符已经出现过，更新左指针位置
            if (lastIndex[currentChar] != -1) {
                l = Math.max(lastIndex[currentChar] + 1, l);
            }

            lastIndex[currentChar] = r;

            if (r - l + 1 > maxLen) {
                maxLen = r - l + 1;
                maxStart = l;
            }
        }
        return s.substring(maxStart, maxStart + maxLen);
    }

    public static String maxString1(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> mp = new HashMap<>();
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
