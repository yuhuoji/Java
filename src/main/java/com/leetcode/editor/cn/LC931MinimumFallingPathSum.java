package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 931 下降路径最小和
public class LC931MinimumFallingPathSum {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 931);
        Solution solution = new LC931MinimumFallingPathSum().new Solution();

    }

    // f[i][j]到达i位置的路径和
    // f[i][j]=min(f[i-1][j-1],f[i-1][j],f[i-1][j+1])+m[i][j]
    // 返回min(f[m-1][j])
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            int[] f = new int[n];
            for (int j = 0; j < n; ++j) {
                f[j] = matrix[0][j];
            }
            for (int i = 1; i < n; ++i) {
                int pre = Integer.MAX_VALUE;
                for (int j = 0; j < n; ++j) {
                    int tmp = f[j];
                    if (j > 0) {
                        f[j] = Math.min(f[j], pre);
                    }
                    if (j < n - 1) {
                        f[j] = Math.min(f[j], f[j + 1]);
                    }
                    f[j] += matrix[i][j];
                    pre = tmp;
                }
            }
            return Arrays.stream(f).min().getAsInt();
        }

        public int minFallingPathSum1(int[][] matrix) {
            int n = matrix.length;
            int[][] f = new int[n][n];
            for (int j = 0; j < n; ++j) {
                f[0][j] = matrix[0][j];
            }
            for (int i = 1; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    f[i][j] = f[i - 1][j];
                    if (j > 0) {
                        f[i][j] = Math.min(f[i][j], f[i - 1][j - 1]);
                    }
                    if (j < n - 1) {
                        f[i][j] = Math.min(f[i][j], f[i - 1][j + 1]);
                    }
                    f[i][j] += matrix[i][j];
                }
            }
            int ans = Integer.MAX_VALUE;
            for (int j = 0; j < n; ++j) {
                ans = Math.min(ans, f[n - 1][j]);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}