package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 309 Best Time to Buy and Sell Stock with Cooldown
public class LC309BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        System.out.println("LC " + 309);
        Solution solution = new LC309BestTimeToBuyAndSellStockWithCooldown().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // cooldown 冷冻期一天, 卖了不能隔天买
        // 两种做法：在122上添加一个状态or直接从f(i-1-k,0)转移过来，表示有k天的冷冻期
        // 有股票f(i,1) = max{f(i-1,1), 购入股票f(i-2,0)-price[i]} //卖了不能隔天买
        // 没股票f(i,0) = max{f(i-1,0), 卖出股票f(i-1,1)+price[i]}
        // f(-2,0)=0
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][] f = new int[n + 2][2];
            // 边界
            f[1][1] = Integer.MIN_VALUE / 2;
            for (int i = 0; i < n; ++i) {
                f[i + 2][1] = Math.max(f[i + 1][1], f[i][0] - prices[i]);
                f[i + 2][0] = Math.max(f[i + 1][0], f[i + 1][1] + prices[i]);
            }
            return f[n + 1][0];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}