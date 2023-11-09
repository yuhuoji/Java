package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 516 Longest Palindromic Subsequence
public class Leetcode516LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 516);
        Solution solution = new Leetcode516LongestPalindromicSubsequence().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private String s;

        //dp
        // s[i]=s[j], dfs(i,j) = dfs(i+1,j-1)+2 都选
        //!= dfs(i,j) = max{dfs(i+1,j),dfs(i,j-1)}
        // 边界
        // i=j 1; i>j 0
        // 递推 f[0][n-1]
        public int longestPalindromeSubseq(String s) {
            int n = s.length();
            int[][] f = new int[n][n];
            for (int i = n - 1; i >= 0; --i) {
                f[i][i] = 1;
                for (int j = i + 1; j < n; ++j) {
                    if (s.charAt(i) == s.charAt(j)) {
                        f[i][j] = f[i + 1][j - 1] + 2;
                    } else {
                        f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                    }
                }
            }
            return f[0][n - 1];
        }

        public int longestPalindromeSubseq1(String s) {
            this.s = s;
            return dfs(0, s.length() - 1);
        }

        // 从i到j的最长回文子序列的长度
        // s[i]=s[j], dfs(i,j) = dfs(i+1,j-1)+2 都选
        //!= dfs(i,j) = max{dfs(i+1,j),dfs(i,j-1)}
        // 边界
        // 递归入口dfs(0,n-1)
        // TLE 时间O(N^2) 空间O(N^2)
        private int dfs(int i, int j) {
            if (i == j) {
                return 1;
            }
            if (i > j) {
                return 0;
            }
            if (s.charAt(i) == s.charAt(j)) {
                return dfs(i + 1, j - 1) + 2;
            } else {
                return Math.max(dfs(i + 1, j), dfs(i, j - 1));
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}