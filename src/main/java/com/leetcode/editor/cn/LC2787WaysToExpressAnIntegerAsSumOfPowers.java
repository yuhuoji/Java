package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 2787 将一个数字表示成幂的和的方案数
public class LC2787WaysToExpressAnIntegerAsSumOfPowers {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2787);
        Solution solution = new LC2787WaysToExpressAnIntegerAsSumOfPowers().new Solution();
        System.out.println(solution.pow(2, 3));
    }

    // REVIEW @date 2024-07-19 避免浮点数误差，四舍五入加0.5
    // 互不相同 01背包 求组合数
    // f[i][n] 表示从1..i中选数，当前选或不选i，和为n
    // f[i][c]=f[i-1][c]+f[i-1][c-]
    // 返回 f[⌊n^(1/2)⌋][n]
    // 初始值  f[0][0]=1 容量选完了 f[0][+]=0 没数选了但是容量没选完
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int MOD = (int) (1e9 + 7);

        // 300^(1/2)=17...
        public int numberOfWays(int n, int x) {
            int limit = (int) (Math.pow(n, 1.0 / x) + 0.5); // 避免浮点数误差，四舍五入加0.5
            int[][] f = new int[n + 1][n + 1];
            f[0][0] = 1;
            for (int i = 1; i <= limit; ++i) {
                for (int c = 0; c <= n; ++c) {
                    int tmp = (int) Math.pow(i, x);
                    if (c < tmp) {
                        f[i][c] = f[i - 1][c];
                    } else {
                        f[i][c] = (int) (((long) f[i - 1][c] + f[i - 1][c - tmp]) % MOD);
                    }
                }
            }
            return f[limit][n];
        }

        // 快速幂
        private int pow(int x, int n) {
            int ans = 1;
            while (n > 0) {
                if ((n & 1) == 1) {
                    ans *= x;
                }
                x *= x;
                n /= 2;
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}