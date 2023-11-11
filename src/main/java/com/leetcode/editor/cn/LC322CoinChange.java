package com.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Map;

public class LC322CoinChange {
    public static void main(String[] args) {
        System.out.println("LC " + 322);
        Solution solution = new LC322CoinChange().new Solution();

        int[] coins = {411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422};
        int amount = 9864;
        System.out.println(solution.coinChange(coins, amount));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //完全背包
        //选不选当前位置
        //f[i][remain] = min{f[i][remain-coin[j]]} + 1


        private int[] coins;
        private int[][] cache;

        //递推
        public int coinChange(int[] coins, int amount) {
            int n = coins.length;
            //i:-1~n-1, c:0~amount
            int[][] cache = new int[n + 1][amount + 1];
            Arrays.fill(cache[0], Integer.MAX_VALUE / 2); //i<0&&c!=0 不合法
            cache[0][0] = 0;
            for (int i = 0; i < n; ++i) { //枚举硬币
                for (int c = 0; c <= amount; ++c) { //枚举金额
                    if (coins[i] > c) { //不能选当前硬币
                        cache[i + 1][c] = cache[i][c];
                    } else {
                        cache[i + 1][c] = Math.min(cache[i][c], cache[i + 1][c - coins[i]] + 1);
                    }
                }
            }
            int ans = cache[n][amount];
            return ans < Integer.MAX_VALUE / 2 ? ans : -1;
        }


        //dfs TLE
        public int coinChange1(int[] coins, int amount) {
            this.coins = coins;
            int ans = dfs1(coins.length - 1, amount);

            return ans < Integer.MAX_VALUE / 2 ? ans : -1;
        }

        private int dfs1(int i, int c) {
            if (i < 0) {
                if (c == 0) {
                    return 0;
                } else {
                    return Integer.MAX_VALUE / 2; //不合法
                }
            }
            if (c < coins[i]) { //不能选当前数
                return dfs1(i - 1, c);
            }
            return Math.min(dfs1(i - 1, c), dfs1(i, c - coins[i]) + 1); //选或不选
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}