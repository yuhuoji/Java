package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 1594 矩阵的最大非负积
public class LC1594MaximumNonNegativeProductInAMatrix {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1594);
        Solution solution = new LC1594MaximumNonNegativeProductInAMatrix().new Solution();

    }

    // lc152
    // 可以从左侧或上侧移动过来
    // f[i][j]!=从f[i-1][j],f[i][j-1]移动过来
    // maxF[i][j]=max(maxF[i-1][j]*x,minF[i-1][j]*x,maxF[i][j-1]*x,minF[i][j-1]*x)
    // minF[i][j]=min(maxF[i-1][j]*x,minF[i-1][j]*x,maxF[i][j-1]*x,minF[i][j-1]*x)
    // 返回maxF[m-1][n-1] 必须是非负
    // 初始值 第一行(只能从左侧转移)和第一列
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int MOD = (int) (1e9 + 7);

        public int maxProductPath(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            var maxF = new long[m][n];
            var minF = new long[m][n];
            maxF[0][0] = minF[0][0] = grid[0][0];
            for (int i = 1; i < m; ++i) {
                int x = grid[i][0];
                maxF[i][0] = minF[i][0] = maxF[i - 1][0] * x;
            }
            for (int j = 1; j < n; ++j) {
                int x = grid[0][j];
                maxF[0][j] = minF[0][j] = maxF[0][j - 1] * x;
            }
            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    int x = grid[i][j];
                    maxF[i][j] = Math.max(Math.max(maxF[i - 1][j] * x, minF[i - 1][j] * x), Math.max(maxF[i][j - 1] * x, minF[i][j - 1] * x));
                    minF[i][j] = Math.min(Math.min(maxF[i - 1][j] * x, minF[i - 1][j] * x), Math.min(maxF[i][j - 1] * x, minF[i][j - 1] * x));
                }
            }
            return maxF[m - 1][n - 1] >= 0 ? (int) (maxF[m - 1][n - 1] % MOD) : -1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}