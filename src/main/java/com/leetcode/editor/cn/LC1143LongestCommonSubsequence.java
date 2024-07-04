package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 1143 最长公共子序列
public class LC1143LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1143);
        Solution solution = new LC1143LongestCommonSubsequence().new Solution();

    }

    // TODO @date 2024-07-04
    // f[i][j] 0..i-1 0..j-1
    // 相等f[i+1][j+1] = f[i][j] + 1
    // 不等f[i+1][j+1] = max{f[i][j+1], f[i+1][j]}
    // f[0][0] = 0
    // f[m][0]
    // f[0][n]
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length();
            int n = text2.length();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}