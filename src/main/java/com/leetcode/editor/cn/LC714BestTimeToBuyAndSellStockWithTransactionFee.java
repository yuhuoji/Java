package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 714 买卖股票的最佳时机含手续费
public class LC714BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 714);
        Solution solution = new LC714BestTimeToBuyAndSellStockWithTransactionFee().new Solution();

    }

    // 股票122 状态机dp
    // 有股票f(i+1,1) = max{f(i,1), 购入股票f(i,0)-price[i] - fee}
    // 没股票f(i+1,0) = max{f(i,0), 卖出股票f(i,1)+price[i]}
    // f[0][1] = -inf
    // f[0][0] = 0
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int[] pre = new int[2];
            int[] cur = new int[2];
            pre[0] = 0;
            pre[1] = Integer.MIN_VALUE / 2;
            for (int i = 0; i < n; ++i) {
                cur[1] = Math.max(pre[1], pre[0] - prices[i] - fee);
                cur[0] = Math.max(pre[0], pre[1] + prices[i]);
                var tmp = pre;
                pre = cur;
                cur = tmp;
            }
            return pre[0];
        }

        public int maxProfit1(int[] prices, int fee) {
            int n = prices.length;
            int[][] f = new int[n + 1][2];
            f[0][0] = 0;
            f[0][1] = Integer.MIN_VALUE / 2;
            for (int i = 0; i < n; ++i) {
                f[i + 1][1] = Math.max(f[i][1], f[i][0] - prices[i] - fee);
                f[i + 1][0] = Math.max(f[i][0], f[i][1] + prices[i]);
            }
            return f[n][0];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}