package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 122 Best Time to Buy and Sell Stock II
public class LC122BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        System.out.println("LC " + 122);
        Solution solution = new LC122BestTimeToBuyAndSellStockIi().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 状态机dp
        private int INF = Integer.MIN_VALUE / 2;
        private int[] prices;

        // 空间压缩O(1)
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int f0 = 0;
            int f1 = Integer.MIN_VALUE / 2;
            for (int i = 0; i < n; ++i) {
                int newF1 = Math.max(f1, f0 - prices[i]);
                f0 = Math.max(f0, f1 + prices[i]);
                f1 = newF1;
            }
            return f0;
        }

        // 递推 时间O(N) 空间O(N)
        // 有股票f(i+1,1) = max{f(i,1), 购入股票f(i,0)-price[i]}
        // 没股票f(i+1,0) = max{f(i,0), 卖出股票f(i,1)+price[i]}
        public int maxProfit2(int[] prices) {
            int n = prices.length;
            int[][] f = new int[n + 1][2];
            // 边界
            f[0][0] = 0;
            f[0][1] = Integer.MIN_VALUE / 2;
            for (int i = 0; i < n; ++i) {
                f[i + 1][1] = Math.max(f[i][1], f[i][0] - prices[i]);
                f[i + 1][0] = Math.max(f[i][0], f[i][1] + prices[i]);
            }
            return f[n][0];
        }

        public int maxProfit1(int[] prices) {
            int n = prices.length;
            this.prices = prices;
            return dfs(n - 1, false); // Math.max(dfs(n-1,false),dfs(n-1,true));
        }

        // 第几天，是否持有股票
        // 有股票f(i,1) = max{f(i-1,1), 购入股票f(i-1,0)-price[i]}
        // 没股票f(i,0) = max{f(i-1,0), 卖出股票f(i-1,1)+price[i]}
        private int dfs(int i, boolean hold) {
            if (i < 0) {
                return hold ? INF : 0;
            }
            if (hold) {
                return Math.max(dfs(i - 1, true), dfs(i - 1, false) - prices[i]);
            } else {
                return Math.max(dfs(i - 1, false), dfs(i - 1, true) + prices[i]);
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}