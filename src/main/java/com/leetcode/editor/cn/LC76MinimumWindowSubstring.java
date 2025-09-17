package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 76 最小覆盖子串
public class LC76MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 76);
        Solution solution = new LC76MinimumWindowSubstring().new Solution();

    }

    // REVIEW @date 2025-09-17

    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public String minWindow(String S, String T) {
            char[] s = S.toCharArray();
            char[] t = T.toCharArray();
            int[] sCnt = new int[128];
            int[] tCnt = new int[128];
            int sLen = S.length();
            int tLen = T.length();
            int minStart = -1, minLen = sLen + 1;
            for (int i = 0; i < tLen; ++i) {
                tCnt[t[i]]++;
            }
            int less = 0;
            for (int i = 0; i < 128; ++i) {
                less += tCnt[i] > 0 ? 1 : 0;
            }
            int left = 0;
            for (int right = 0; right < sLen; ++right) {
                sCnt[s[right]]++;
                if (sCnt[s[right]] == tCnt[s[right]]) {
                    less--;
                }
                while (less == 0) {
                    if (right - left + 1 < minLen) {
                        minStart = left;
                        minLen = right - left + 1;
                    }
                    if (sCnt[s[left]] == tCnt[s[left]]) {
                        less++;
                    }
                    sCnt[s[left]]--;
                    left++;
                }
            }
            return minLen == sLen + 1 ? "" : S.substring(minStart, minStart + minLen);
        }
    }

    class Solution1 {
        // ASCII A 65-90 a 97-122
        // 返回 起点和最小长度
        // 滑动窗口 长度大于等于tLen
        public String minWindow(String S, String T) {
            char[] s = S.toCharArray();
            char[] t = T.toCharArray();
            int[] sCnt = new int[128];
            int[] tCnt = new int[128];
            int sLen = s.length;
            int tLen = t.length;
            int minStart = 0, minLen = sLen + 1;
            for (int i = 0; i < tLen; ++i) {
                tCnt[t[i]]++;
            }
            int left = 0;
            for (int right = 0; right < sLen; ++right) {
                sCnt[s[right]]++;
                while (isCovered(sCnt, tCnt)) {
                    if (right - left + 1 < minLen) {
                        minStart = left;
                        minLen = right - left + 1;
                    }
                    sCnt[s[left]]--;
                    left++;
                }
            }
            return minLen == sLen + 1 ? "" : S.substring(minStart, minStart + minLen);
        }

        // O(52)
        private boolean isCovered(int[] sCnt, int[] tCnt) {
            for (int i = 'A'; i <= 'Z'; ++i) {
                if (sCnt[i] < tCnt[i]) {
                    return false;
                }
            }
            for (int i = 'a'; i <= 'z'; ++i) {
                if (sCnt[i] < tCnt[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    class Solution20 {
        // 时间复杂度O(m+n)
        public String minWindow(String s, String t) {
            int sLen = s.length();
            int tLen = t.length();
            if (sLen < tLen) {
                return "";
            }
            int minLeft = 0, minLen = sLen + 1; // 记录答案
            int less = 0; // 记录s和t不同的字符数量
            int[] sCount = new int[128];
            int[] tCount = new int[128];
            for (char c : t.toCharArray()) {
                tCount[c]++;
            }
            for (int i = 0; i < 128; ++i) {
                less += tCount[i] > 0 ? 1 : 0; // 初始化less
            }
            for (int left = 0, right = 0; right < sLen; ++right) {
                char cRight = s.charAt(right);
                sCount[cRight]++;
                if (sCount[cRight] == tCount[cRight]) {
                    less--;
                }
                while (less == 0) {
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        minLeft = left;
                    }
                    char cLeft = s.charAt(left);
                    if (sCount[cLeft] == tCount[cLeft]) {
                        less++;
                    }
                    sCount[cLeft]--;
                    left++;
                }
            }
            return minLen == sLen + 1 ? "" : s.substring(minLeft, minLeft + minLen);
        }
    }


    class Solution10 {
        // 时间复杂度O(∑m+n)
        public String minWindow(String s, String t) {
            int sLen = s.length();
            int tLen = t.length();
            if (sLen < tLen) {
                return "";
            }
            int minLeft = 0, minLen = sLen + 1; // 记录答案
            int[] sCount = new int[128];
            int[] tCount = new int[128];
            for (char c : t.toCharArray()) {
                tCount[c]++;
            }
            for (int left = 0, right = 0; right < sLen; ++right) {
                char cRight = s.charAt(right);
                sCount[cRight]++;
                while (isCover(sCount, tCount)) {
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        minLeft = left;
                    }
                    char cLeft = s.charAt(left);
                    sCount[cLeft]--;
                    left++;
                }
            }
            return minLen == sLen + 1 ? "" : s.substring(minLeft, minLeft + minLen);
        }

        // 52次
        // 检查s是否包括t
        private boolean isCover(int[] sCount, int[] tCount) {
            for (int i = 'A'; i <= 'Z'; ++i) {
                if (sCount[i] < tCount[i]) {
                    return false;
                }
            }
            for (int i = 'a'; i <= 'z'; ++i) {
                if (sCount[i] < tCount[i]) {
                    return false;
                }
            }
            return true;
        }
    }

// leetcode submit region end(Prohibit modification and deletion)

}