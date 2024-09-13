package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 121 Best Time to Buy and Sell Stock
public class LC121BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println("LC " + 121);
        Solution solution = new LC121BestTimeToBuyAndSellStock().new Solution();

    }
    // 限制交易次数1
    // f[i][0] 0..i 获得的利润
    // f[i][1] 持有为1
    // f(i,0) = max f(i-1,0), f(i-1,1)+price[i]
    // f(i,1) = max f(i-1,1), f(i-1,0)-price[i]
    // 返回 f[n-1][0]
    // f(-1,0) = 0
    // f(-1,1) = 不合理

    // f[i + 1][0] = Math.max(f[i][0], f[i][1] + prices[i]);
    // f[i + 1][1] = Math.max(f[i][1], f[i][0] - prices[i]);

    // f[i] 0..i 天获得的利润，minprice 0..i-1天的最低价格(买入)
    // f[i]=max(f[i−1],prices[i]−minprice)
    // 返回f[n-1]
    // f[i+1]=max(f[i],prices[i]−minprice)
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[] f = new int[n + 1];
            int minPrice = prices[0];
            for (int i = 0; i < n; ++i) {
                f[i + 1] = Math.max(f[i], prices[i] - minPrice);
                minPrice = Math.min(minPrice, prices[i]);
            }
            return f[n];
        }
    }

    class Solution1 {
        // 限制交易次数最多一次
        private int[] prices;
        private int INF = Integer.MIN_VALUE / 2;

        public int maxProfit(int[] prices) {
            this.prices = prices;
            int n = prices.length;
            return dfs(n - 1, 1, false);
        }

        // dfs TLE
        private int dfs(int i, int j, boolean hold) {
            if (j < 0) {
                return INF;
            }
            if (i < 0) {
                return hold ? INF : 0;
            }
            if (hold) {
                return Math.max(dfs(i - 1, j, true), dfs(i - 1, j, false) - prices[i]);
            } else {
                return Math.max(dfs(i - 1, j, false), dfs(i - 1, j - 1, true) + prices[i]);
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}