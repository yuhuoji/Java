package com.practice;

public class Solution {
    public static void main(String[] args) {
        String s1 = "aacqabc";
        String patten1 = "abc";
        System.out.println("ans:" + Solution.maxString(s1, patten1));
    }

    // 测试用例
    // 1. s = "abb" pattern = "abc" -> "null"
    // 2. s = "abbc" pattern = "abc" -> "abb"
    // 3. s = "abbcqabbbcc" pattern = "abc" -> "abbbcc"
    // 4. s = "aabbccqabc" pattern = "abc" -> "aabbcc"

    // 滑动窗口 时间O(N) 空间O(1)
    public static String maxString(String s, String pattern) {
        int sLen = s.length();
        int pLen = pattern.length();
        if (sLen < pLen) {
            return "";
        }

        int maxLen = 0;
        int maxStart = 0;
        int start = 0, end = 0, p = 0;
        while (start < sLen && s.charAt(start) != pattern.charAt(0)) { // 初始化滑动窗口,找到起点
            start++;
        }
        for (end = start; end < sLen; ++end) { // 枚举右端点
            if (s.charAt(end) == pattern.charAt(p)) { // 相等
                continue;
            }
            if (p + 1 < pLen && s.charAt(end) == pattern.charAt(p + 1)) { // 等于下一个字符
                ++p;
                continue;
            }
            if (p == pLen - 1 && s.charAt(end) != pattern.charAt(p)) { // p最后一个字符
                int curLen = end - start;
                if (curLen > maxLen) {
                    maxLen = curLen;
                    maxStart = start;
                }
            }

            // 不相等
            start = end;
            p = 0;
            while (start < sLen && s.charAt(start) != pattern.charAt(0)) { // 找到下一个起点
                start++;
            }
            end = start;
        }

        if (p == pLen - 1 && end == sLen) { // s最后一个字符
            int curLen = end - start;
            if (curLen > maxLen) {
                maxLen = curLen;
                maxStart = start;
            }
        }
        return maxLen == 0 ? "" : s.substring(maxStart, maxStart + maxLen);
    }

    // dp
    public static String maxString3(String s, String pattern) {
        int sLen = s.length();
        int pLen = pattern.length();
        if (sLen < pLen) {
            return "";
        }
        for (int i = sLen - 1; i >= 0; --i) {
            while (i >= 0 && s.charAt(i) == pattern.charAt(pLen - 1)) {
                --i;
            }
            if (i < 0) {
                return "";
            }

        }
        return null;
    }
}
