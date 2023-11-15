package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 64 Minimum Path Sum
public class LC64MinimumPathSum {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 64);
        Solution solution = new LC64MinimumPathSum().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 第一行
        // 第一列
        // f[i][j] = min(f[i-1][j], f[i][j-1]) + grid[i][j]
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m][n];
            dp[0][0] = grid[0][0]; //[0][0]
            for (int j = 1; j < n; ++j) { // 第一行
                dp[0][j] += dp[0][j - 1] + grid[0][j];
            }

            for (int i = 1; i < m; ++i) {
                dp[i][0] = dp[i - 1][0] + grid[i][0]; // 第一列
                for (int j = 1; j < n; ++j) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
            return dp[m - 1][n - 1];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}