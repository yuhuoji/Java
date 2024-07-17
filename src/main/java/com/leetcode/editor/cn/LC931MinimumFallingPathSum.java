package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 931 下降路径最小和
public class LC931MinimumFallingPathSum {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 931);
        Solution solution = new LC931MinimumFallingPathSum().new Solution();

    }


    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // pre=f[r - 1][c]
        public int minFallingPathSum22(int[][] matrix) {
            int n = matrix.length;
            int[] f = new int[n + 2];
            System.arraycopy(matrix[0], 0, f, 1, n); // 复制matrix的第一行
            f[0] = f[n + 1] = Integer.MAX_VALUE;
            for (int r = 1; r < n; ++r) {
                int pre = f[0];
                for (int c = 0; c < n; ++c) {
                    int tmp = f[c + 1]; //先保存当前格
                    f[c + 1] = Math.min(Math.min(pre, f[c + 1]), f[c + 2]) + matrix[r][c];
                    pre = tmp;
                }
            }
            int ans = Integer.MAX_VALUE;
            for (int c = 0; c < n; ++c) {
                ans = Math.min(ans, f[c + 1]);
            }
            return ans;
        }

        // f[r][c]=min(f[r-1][c-1],f[r-1][c],f[r-1][c+1])+m[r][c]
        // 边界 f[0][c]=m[0][c] f[r][-1]=f[r][n]=inf
        // f最左侧和最右侧增加一列
        // 增加后
        // f[r][c+1]=min(f[r-1][c],f[r-1][c+1],f[r-1][c+2])+m[r][c]
        // 边界 f[0][c]=m[0][c] f[r][-1]=f[r][n+1]=inf
        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            int[][] f = new int[n][n + 2];
            System.arraycopy(matrix[0], 0, f[0], 1, n); // 复制matrix的第一行
            for (int r = 1; r < n; ++r) {
                f[r - 1][0] = f[r - 1][n + 1] = Integer.MAX_VALUE;
                for (int c = 0; c < n; ++c) {
                    f[r][c + 1] = Math.min(Math.min(f[r - 1][c], f[r - 1][c + 1]), f[r - 1][c + 2]) + matrix[r][c];
                }
            }
            int ans = Integer.MAX_VALUE;
            for (int c = 0; c < n; ++c) {
                ans = Math.min(ans, f[n - 1][c + 1]);
            }
            return ans;
        }

        public int minFallingPathSum12(int[][] matrix) {
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

        // f[i][j]到达i位置的路径和
        // f[i][j]=min(f[i-1][j-1],f[i-1][j],f[i-1][j+1])+m[i][j]
        // 返回min(f[m-1][j])
        public int minFallingPathSum11(int[][] matrix) {
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