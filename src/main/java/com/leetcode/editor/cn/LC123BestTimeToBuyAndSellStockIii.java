package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 123 Best Time to Buy and Sell Stock III
public class LC123BestTimeToBuyAndSellStockIii {
    public static void main(String[] args) {
        System.out.println("LC " + 123);
        Solution solution = new LC123BestTimeToBuyAndSellStockIii().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 限制交易次数最多两次
        private int[] prices;
        private int INF = Integer.MIN_VALUE / 2;

        // 插入f[i][][] f[][j][]
        // 没股票f(i+1,j+1,0) = max{f(i,j+1,0), f(i,j,1)+price[i]}
        // 有股票f(i+1,j+1,1) = max{f(i,j+1,1), f(i,j+1,0)-price[i]}
        // f(,0,) 不合法
        // f(0,,0) = 0
        // f(0,,1) 不合法
        // 入口f(n,2+1,0)
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][][] f = new int[n + 1][2 + 2][2];// -1..n-1 -1,0..2 0..1
            // 边界
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < 4; ++j) {
                    f[i][j][0] = INF;
                    f[i][j][1] = INF;
                }
            }
            for (int j = 0; j < 4; ++j) {
                f[0][j][0] = 0;
            }
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j <= 2; ++j) {
                    f[i + 1][j + 1][0] = Math.max(f[i][j + 1][0], f[i][j][1] + prices[i]);
                    f[i + 1][j + 1][1] = Math.max(f[i][j + 1][1], f[i][j + 1][0] - prices[i]);
                }
            }
            return f[n][2 + 1][0];// 最后一天一定不可能持有股票
        }

        public int maxProfit1(int[] prices) {
            this.prices = prices;
            int n = prices.length;
            return dfs(n - 1, 2, false);// 最后一天一定不可能持有股票
        }

        // 前i天完成最多j次交易
        // 没股票dfs(i,j,0) = max{dfs(i-1,j,0), dfs(i-1,j-1,1)+price[i]}
        // 有股票dfs(i,j,1) = max{dfs(i-1,j,1), dfs(i-1,j,0)-price[i]}
        // dfs(,-1,) 不合法
        // dfs(-1,,0) = 0
        // dfs(-1,,1) 不合法
        // 入口dfs(n-1,2,false)
        // TLE
        private int dfs(int i, int j, boolean hold) {
            if (j < 0) {
                return INF;
            }
            if (i < 0) {
                return hold ? INF : 0;
            }
            if (!hold) {
                return Math.max(dfs(i - 1, j, false), dfs(i - 1, j - 1, true) + prices[i]);
            } else {
                return Math.max(dfs(i - 1, j, true), dfs(i - 1, j, false) - prices[i]);
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}