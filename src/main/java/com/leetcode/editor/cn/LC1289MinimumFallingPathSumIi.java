package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 1289 下降路径最小和  II
public class LC1289MinimumFallingPathSumIi {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1289);
        Solution solution = new LC1289MinimumFallingPathSumIi().new Solution();

    }

    // f[r][c]=min(除了f[r-1][c])+m[r][c]
    // 边界 f[0][c]=m[0][c] f[r][-1]=f[r][n]=inf
    // f最左侧和最右侧增加一列
    // 增加后
    // f[r][c+1]=min(f[r-1][c],f[r-1][c+2])+m[r][c]
    // 边界 f[0][c]=m[0][c] f[r][-1]=f[r][n+1]=inf
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minFallingPathSum(int[][] grid) {
            int n = grid.length;
            int[][] f = new int[n][n];
            System.arraycopy(grid[0], 0, f[0], 0, n); // 复制matrix的第一行
            for (int r = 1; r < n; ++r) {
                for (int c = 0; c < n; ++c) {
                    f[r][c] = Integer.MAX_VALUE;
                    for (int j = 0; j < n; ++j) { // 上一行
                        if (j == c) {
                            continue;
                        }
                        f[r][c] = Math.min(f[r][c], f[r - 1][j] + grid[r][c]);
                    }
                }
            }
            int ans = Integer.MAX_VALUE;
            for (int c = 0; c < n; ++c) {
                ans = Math.min(ans, f[n - 1][c]);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}