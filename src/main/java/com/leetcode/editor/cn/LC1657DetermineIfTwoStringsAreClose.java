package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 1657 Determine if Two Strings Are Close
public class LC1657DetermineIfTwoStringsAreClose {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1657);
        Solution solution = new LC1657DetermineIfTwoStringsAreClose().new Solution();
        String s1 = "uau";
        String s2 = "ssx";
        System.out.println(solution.closeStrings(s1, s2));
    }

    // O1 位置无关
    // O2 频率次数一样
    // REVIEW @date 2024-02-05 位运算记录字符集
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean closeStrings(String word1, String word2) {
            if (word1.length() != word2.length()) {
                return false;
            }
            int n = word1.length();
            int[] freq1 = new int[26];
            int[] freq2 = new int[26];
            for (int i = 0; i < n; ++i) {
                freq1[word1.charAt(i) - 'a']++;
                freq2[word2.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; ++i) {
                if ((freq1[i] == 0) != (freq2[i] == 0)) { // 字符集是否相同
                    return false;
                }
            }
            Arrays.sort(freq1);
            Arrays.sort(freq2);
            return Arrays.equals(freq1, freq2); //
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}