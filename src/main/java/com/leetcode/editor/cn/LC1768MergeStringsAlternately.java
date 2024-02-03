package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 1768 Merge Strings Alternately
public class LC1768MergeStringsAlternately {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1768);
        Solution solution = new LC1768MergeStringsAlternately().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String mergeAlternately(String word1, String word2) {
            StringBuilder sb = new StringBuilder();
            int len1 = word1.length();
            int len2 = word2.length();
            int i = 0, j = 0;
            while (i < len1 || j < len2) {
                if (i < len1) {
                    sb.append(word1.charAt(i++));
                }
                if (j < len2) {
                    sb.append(word2.charAt(j++));
                }
            }
            return sb.toString();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}