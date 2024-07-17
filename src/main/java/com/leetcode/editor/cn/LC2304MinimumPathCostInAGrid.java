package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.lang.reflect.Array;
import java.util.Arrays;

// 2304 网格中的最小路径代价
public class LC2304MinimumPathCostInAGrid {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2304);
        Solution solution = new LC2304MinimumPathCostInAGrid().new Solution();

    }

    // f[i][j] i行j列的代价
    // f[i][j]= min（上一行所有位置+移动消耗）+ g[i][j]
    // min{f[i-1][.]+moveCost[grid[i-1][.]][j]} + g[i][j]
    // 初始值 f[0][j]=grid[0][j]
    // 返回 min(f[m-1][j])

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minPathCost1(int[][] grid, int[][] moveCost) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] f = new int[m][n];
            System.arraycopy(grid[0], 0, f[0], 0, n);
            for (int i = 1; i < m; ++i) {
                Arrays.fill(f[i], Integer.MAX_VALUE / 2);
            }
            for (int i = 1; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    for (int c = 0; c < n; ++c) { // 从(i-1,c)转移到(i,j)
                        f[i][j] = Math.min(f[i][j], f[i - 1][c] + moveCost[grid[i - 1][c]][j]);
                    }
                    f[i][j] += grid[i][j];
                }
            }
            int ans = Integer.MAX_VALUE;
            for (int j = 0; j < n; ++j) {
                ans = Math.min(ans, f[m - 1][j]);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}