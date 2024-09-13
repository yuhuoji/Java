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

    //[[0],[1]]
    //[[0,0],[1,0]]
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length, n = obstacleGrid[0].length;
            if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
                return 0;
            }
            int[] f = new int[n];
            for (int j = 0; j < n && obstacleGrid[0][j] != 1; ++j) {
                f[j] = 1;
            }
            for (int i = 1; i < m; ++i) {
                f[0] = obstacleGrid[i][0] != 1 && f[0] == 1 ? 1 : 0;
                for (int j = 1; j < n; ++j) {
                    if (obstacleGrid[i][j] != 1) {
                        f[j] = f[j - 1] + f[j];
                    } else {
                        f[j] = 0; // 需要重新更新为0
                    }
                }
            }
            return f[n - 1];
        }

        // 到达（i,j）位置的方法数 f[i][j]
        // f[i][j]=f[i][j-1]+f[i-1][j]
        public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
            int m = obstacleGrid.length, n = obstacleGrid[0].length;
            if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
                return 0;
            }
            int[][] f = new int[m][n];
            for (int i = 0; i < m && obstacleGrid[i][0] != 1; ++i) {
                f[i][0] = 1;
            }
            for (int j = 1; j < n && obstacleGrid[0][j] != 1; ++j) {
                f[0][j] = 1;
            }
            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    if (obstacleGrid[i][j] != 1) {
                        f[i][j] = f[i][j - 1] + f[i - 1][j];
                    }
                }
            }
            return f[m - 1][n - 1];
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}