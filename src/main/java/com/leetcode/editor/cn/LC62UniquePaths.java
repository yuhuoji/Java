package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 62 不同路径
public class LC62UniquePaths {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 62);
        Solution solution = new LC62UniquePaths().new Solution();

    }

    // f[m][n] = f[m-1][n] + f[m][n-1]
    // f[1][n] = 0 + f[1][n-1]
    // f[m][1] = f[m-1][1] + 0
    // f[1][1] = 1
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
            int[] cur = new int[n];
            cur[0] = 1;
            int[] pre = new int[n];
            Arrays.fill(pre, 1);
            for (int i = 1; i < m; ++i) { // 滚动数组，cur是上一行，每次更新cur，最后交换pre和cur
                for (int j = 1; j < n; ++j) {
                    cur[j] = cur[j - 1] + pre[j];
                }
                var tmp = cur;
                cur = pre;
                pre = tmp;
            }
            return pre[n - 1];
        }

        public int uniquePaths1(int m, int n) {
            int[][] f = new int[m][n];
            f[0][0] = 1;
            for (int i = 1; i < m; ++i) {
                f[i][0] = 1;
            }
            for (int j = 1; j < n; ++j) {
                f[0][j] = 1;
            }
            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
            return f[m - 1][n - 1];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}