package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 63 Unique Paths II
public class LC63UniquePathsIi {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 63);
        Solution solution = new LC63UniquePathsIi().new Solution();
        //[[0,0,0],[0,1,0],[0,0,0]]
        int[][] nums = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        // System.out.println(solution.uniquePathsWithObstacles(nums));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // dp = 0 表示无法到达, 从无法到达的位置出发到达的位置，也是无法到达的
        public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            int[] dp = new int[n]; // 初始化为0，默认所有位置都不能到达
            dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1; // 起点有障碍物则其余位置都不能到达
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[j] = 0;
                        continue;
                    }
                    if (j - 1 >= 0) {
                        dp[j] += dp[j - 1];
                    }
                }
            }
            return dp[n - 1];
        }

        // 到达的方法数
        // f[i][j] 表示无法到达
        // f[i][j] = f[i-1][j] + f[i][j-1]
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
                return 0;
            }
            int[][] dp = new int[m][n]; // 初始化为0

            dp[0][0] = 1;
            for (int i = 1; i < m && obstacleGrid[i][0] == 0; ++i) {  // 第一列
                dp[i][0] = 1;
            }

            for (int j = 1; j < n && obstacleGrid[0][j] == 0; ++j) { // 第一行
                dp[0][j] = 1;
            }

            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0; // 0种方法到达，表示无法到达
                        continue;
                    }
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // 左+上
                }
            }
            return dp[m - 1][n - 1];
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}