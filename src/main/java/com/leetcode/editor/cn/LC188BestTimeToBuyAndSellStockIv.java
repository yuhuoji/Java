package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 188 Best Time to Buy and Sell Stock IV
public class LC188BestTimeToBuyAndSellStockIv {
    public static void main(String[] args) {
        System.out.println("LC " + 188);
        Solution solution = new LC188BestTimeToBuyAndSellStockIv().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // REVIEW @date 2023-11-08
        // TODO @date 2023-11-08 空间优化
        int INF = Integer.MIN_VALUE / 2;

        // 最多k笔交易, 买入买入卖出算一次
        // 到第i天至多完成j笔交易
        // 没股票dfs(i,j,0) = max{dfs(i-1,j,0), dfs(i-1,j-1,1)+price[i]} //卖出
        // 有股票dfs(i,j,1) = max{dfs(i-1,j,1), dfs(i-1,j,0)-price[i]} //买入
        // 边界
        // dfs(i,-1,) 交易次数为负，不合法 f[i][0][] = -inf
        // dfs(-1,j,0)=0 开始前无股票，0  f[0][j][0] = 0
        // dfs(-1,j,1) 开始前持有股票，不合法 f[0][j][1] = -inf
        // f[0][0][] = -inf
        // 递归入口 dfs(n-1,k,0) dp返回f[n][k+1][0]
        public int maxProfit(int k, int[] prices) {
            int n = prices.length;
            int[][][] f = new int[n + 1][k + 2][2]; // i:-1..n-1, j -1..k, 0..1
            // 边界
            /*for (int i = 0; i <= n; ++i) {
                f[i][0][0] = INF;
                f[i][0][1] = INF;
            }
            for (int j = 0; j <= k + 1; ++j) {
                f[0][j][0] = 0;
                f[0][j][1] = INF;
            }
            f[0][0][0] = INF;
            f[0][0][1] = INF;*/
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= k + 1; j++) {
                    Arrays.fill(f[i][j], Integer.MIN_VALUE / 2); // 防止溢出
                }
            }
            for (int j = 1; j <= k + 1; j++) {
                f[0][j][0] = 0;
            }

            for (int i = 0; i < n; ++i) {
                for (int j = 1; j <= k + 1; ++j) {
                    f[i + 1][j][0] = Math.max(f[i][j][0], f[i][j - 1][1] + prices[i]);
                    f[i + 1][j][1] = Math.max(f[i][j][1], f[i][j][0] - prices[i]);
                }
            }
            return f[n][k + 1][0];
        }

    }
// leetcode submit region end(Prohibit modification and deletion)
}