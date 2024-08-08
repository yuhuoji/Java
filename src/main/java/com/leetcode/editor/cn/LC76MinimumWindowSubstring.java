package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

//76 最小覆盖子串
public class LC76MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 76);
        Solution solution = new LC76MinimumWindowSubstring().new Solution();

    }

    //ASCII A 65-90 a 97-122
    //等于 -》 包含
    //s包括t
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            int sLen = s.length();
            int tLen = t.length();
            if (sLen < tLen) {
                return "";
            }
            int minLeft = 0, minLen = sLen + 1; //记录答案
            int less = 0; //记录s和t不同的字符数量
            int[] sCount = new int[128];
            int[] tCount = new int[128];
            for (char c : t.toCharArray()) {
                tCount[c]++;
            }
            for (int i = 0; i < 128; ++i) {
                less += tCount[i] > 0 ? 1 : 0; //初始化less
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

    class Solution1 {
        public String minWindow(String s, String t) {
            int sLen = s.length();
            int tLen = t.length();
            if (sLen < tLen) {
                return "";
            }
            int minLeft = 0, minLen = sLen + 1; //记录答案
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

        //52次
        //检查s是否包括t
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

//leetcode submit region end(Prohibit modification and deletion)

}