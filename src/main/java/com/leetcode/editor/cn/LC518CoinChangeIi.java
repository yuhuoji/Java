package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 518 零钱兑换 II
public class LC518CoinChangeIi {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 518);
        Solution solution = new LC518CoinChangeIi().new Solution();

    }

    // 完全背包 容量恰好为capacity，求方案数
    // f[i][c]=f[i-1][c]+f[i][c-coins[i]]
    // 初始化 f[-][0]=1 容量用完了也是一种方案 f[-][+]=0 不合理
    // 返回f[n-1][amount]

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int change(int amount, int[] coins) {
            int n = coins.length;
            int[][] f = new int[n + 1][amount + 1];
            f[0][0] = 1;
            for (int i = 0; i < n; ++i) {
                for (int c = 0; c <= amount; ++c) {
                    if (c < coins[i]) {
                        f[i + 1][c] = f[i][c];
                    } else {
                        f[i + 1][c] = f[i][c] + f[i + 1][c - coins[i]];
                    }
                }
            }
            return f[n][amount];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}