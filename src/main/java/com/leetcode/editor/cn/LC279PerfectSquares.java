package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 279 完全平方数
public class LC279PerfectSquares {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 279);
        Solution solution = new LC279PerfectSquares().new Solution();
        System.out.println(Math.sqrt(10));
    }
    // 完全背包 每个数可以重复选择，求和恰好为n的最少数量
    // lc2787 01背包
    // f[i][n] 表示从1..i中选数，当前选或不选i，和为n
    // f[i][c]=min(f[i-1][c],f[i][c-x]+1)
    // 初始值 f[.][0]=0 f[0][+]=inf 容量还剩余不合理

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares(int n) {
            //Math.sqrt
            int limit = (int) (Math.pow(n, 0.5) + 0.5); // 从1..limit选数
            int[][] f = new int[limit + 1][n + 1];
            Arrays.fill(f[0], Integer.MAX_VALUE / 2);
            f[0][0] = 0;
            for (int i = 1; i <= limit; ++i) {
                for (int c = 0; c <= n; ++c) {
                    int x = (int) Math.pow(i, 2);
                    if (c < x) {
                        f[i][c] = f[i - 1][c];
                    } else {
                        f[i][c] = Math.min(f[i - 1][c], f[i][c - x] + 1);
                    }
                }
            }
            return f[limit][n];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}