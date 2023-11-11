package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 121 Best Time to Buy and Sell Stock
public class LC121BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println("LC " + 121);
        Solution solution = new LC121BestTimeToBuyAndSellStock().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 限制交易次数最多一次
        private int[] prices;
        private int INF = Integer.MIN_VALUE / 2;

        public int maxProfit(int[] prices) {
            this.prices = prices;
            int n = prices.length;
            return dfs(n - 1, 1, false);
        }

        // f(i,0) = f(i-1,0), f(i-1,1)+price[i]
        // f(i,1) = f(i-1,1), f(i-1,0)-price[i]
        // f(-1,0) = 0
        // f(-1,1) = 不合理
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