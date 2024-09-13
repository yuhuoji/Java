package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 62 不同路径
public class LC62UniquePaths {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 62);
        Solution solution = new LC62UniquePaths().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
            int[] f = new int[n];
            Arrays.fill(f, 1);
            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    f[j] = f[j - 1] + f[j];
                }
            }
            return f[n - 1];
        }
        // f[i][j]=f[i][j-1]+f[i-1][j]
        // 初始值f[0][j] f[i][0] = 1
        // 返回f[m-1][n-1]
        public int uniquePaths1(int m, int n) {
            int[][] f = new int[m][n];
            for (int i = 0; i < m; ++i) {
                f[i][0] = 1;
            }
            for (int j = 1; j < n; ++j) {
                f[0][j] = 1;
            }
            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    f[i][j] = f[i][j - 1] + f[i - 1][j];
                }
            }
            return f[m - 1][n - 1];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}