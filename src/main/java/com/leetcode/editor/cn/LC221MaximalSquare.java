package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 221 Maximal Square
public class LC221MaximalSquare {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 221);
        Solution solution = new LC221MaximalSquare().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 1. bfs + 记录搜索过的点 复杂度高


        // 依赖位置 dp[i+1][j+1] = min{dp[i][j], dp[i][j+1], dp[i+1][j]} +1
        // 循环顺序不变 左上leftUp可以优化空间
        public int maximalSquare(char[][] matrix) {
            int max = 0;
            int m = matrix.length;
            int n = matrix[0].length;
            int[] dp = new int[n + 1];
            int leftUp = 0; // 记录左上角的值，防止更新掉
            for (int i = 0; i < m; ++i) {
                leftUp = 0;
                for (int j = 0; j < n; ++j) { // dp[i+1][j+1]
                    int nextLeftUp = dp[j + 1];
                    if (matrix[i][j] == '1') {
                        dp[j + 1] = Math.min(Math.min(leftUp, dp[j + 1]), dp[j]) + 1;
                        max = Math.max(max, dp[j + 1]);
                        leftUp = nextLeftUp;
                    } else {
                        dp[j + 1] = 0; // 置为0
                    }
                }
            }
            return max * max;
        }

        // 插入一行一列0
        // 状态定义: dp[i+1][j+1]是以(i,j)为右下角的最大的正方形
        // dp[i+1][j+1] = min{dp[i][j], dp[i][j+1], dp[i+1][j]} +1
        public int maximalSquare1(char[][] matrix) {
            int max = 0;
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (matrix[i][j] == '1') {
                        dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j], dp[i][j + 1]), dp[i + 1][j]) + 1;
                        max = Math.max(max, dp[i + 1][j + 1]);
                    }
                }
            }
            return max * max; // 返回边长^2
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}