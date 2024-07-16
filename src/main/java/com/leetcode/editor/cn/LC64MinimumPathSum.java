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
        public int minPathSum(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[] f = new int[n];
            f[0] = grid[0][0];
            for (int j = 1; j < n; ++j) {
                f[j] = f[j - 1] + grid[0][j];
            }
            for (int i = 1; i < m; ++i) {
                f[0] = f[0] + grid[i][0];
                for (int j = 1; j < n; ++j) {
                    f[j] = Math.min(f[j], f[j - 1]) + grid[i][j];
                }
            }
            return f[n - 1];
        }
        //初始值 第一行 第一列
        //返回f[m - 1][n - 1]
        public int minPathSum1(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] f = new int[m][n];
            f[0][0] = grid[0][0];
            for (int j = 1; j < n; ++j) {
                f[0][j] = f[0][j - 1] + grid[0][j];
            }
            for (int i = 1; i < m; ++i) {
                f[i][0] = f[i - 1][0] + grid[i][0];
                for (int j = 1; j < n; ++j) {
                    f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
                }
            }
            return f[m - 1][n - 1];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}