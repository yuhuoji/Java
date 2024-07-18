package com.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Map;

// 322. 零钱兑换
public class LC322CoinChange {
    public static void main(String[] args) {
        System.out.println("LC " + 322);
        Solution solution = new LC322CoinChange().new Solution();

    }

    // REVIEW @date 2024-07-18 完全背包 选了之后递归到i，与01背包不同
    // dfs(i,c) = max(dfs(i-1,c),dfs(i,c-w[i])+v[i])
    // 本题恰好选容量为c的方法数，物品value=1，

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int n = coins.length;
            int[] f = new int[amount + 1];
            Arrays.fill(f, Integer.MAX_VALUE / 2);
            f[0] = 0;
            for (int x : coins) {
                for (int c = x; c <= amount; ++c) {
                    f[c] = Math.min(f[c], f[c - x] + 1);
                }
            }
            int ans = f[amount];
            return ans < Integer.MAX_VALUE / 2 ? ans : -1;
        }

        // 两个数组
        public int coinChange2(int[] coins, int amount) {
            int n = coins.length;
            int[][] f = new int[2][amount + 1];
            Arrays.fill(f[0], Integer.MAX_VALUE / 2);
            f[0][0] = 0;
            for (int i = 0; i < n; ++i) {
                for (int c = 0; c <= amount; ++c) {
                    if (c < coins[i]) {
                        f[(i + 1) % 2][c] = f[i % 2][c];
                    } else {
                        f[(i + 1) % 2][c] = Math.min(f[i % 2][c], f[(i + 1) % 2][c - coins[i]] + 1);
                    }
                }
            }
            int ans = f[n % 2][amount];
            return ans < Integer.MAX_VALUE / 2 ? ans : -1;
        }

        // f[i+1][c]= min(f[i][c],f[i+1][c-coins[i]] + 1)
        // 初始值f[0][0]=0 f[0][+]=inf
        // 返回f[n][amount]
        public int coinChange1(int[] coins, int amount) {
            int n = coins.length;
            int[][] f = new int[n + 1][amount + 1];
            Arrays.fill(f[0], Integer.MAX_VALUE / 2);
            f[0][0] = 0;
            for (int i = 0; i < n; ++i) {
                for (int c = 0; c <= amount; ++c) {
                    if (c < coins[i]) {
                        f[i + 1][c] = f[i][c];
                    } else {
                        f[i + 1][c] = Math.min(f[i][c], f[i + 1][c - coins[i]] + 1);
                    }
                }
            }
            int ans = f[n][amount];
            return ans < Integer.MAX_VALUE / 2 ? ans : -1;
        }
    }

    class Solution2 {

        // f[i][c]= min(f[i-1][c],f[i][c-coins[i]] + 1)
        // 初始值f[-][0]=0 选完了 f[-][+]=inf 还剩余容量
        // 返回f[n-1][amount]
        // 记忆化搜索
        // Integer.MAX_VALUE/2 防止+1溢出
        public int coinChange(int[] coins, int amount) {
            this.coins = coins;
            int n = coins.length;
            memo = new int[n][amount + 1];
            for (var row : memo) {
                Arrays.fill(row, -1); //-1表示没访问过
            }
            int ans = dfs(n - 1, amount);
            return ans < Integer.MAX_VALUE / 2 ? ans : -1;
        }

        private int[] coins;
        private int[][] memo;

        private int dfs(int i, int c) {
            if (i < 0) {
                return c == 0 ? 0 : Integer.MAX_VALUE / 2;
            }
            if (memo[i][c] != -1) { // 已经计算过
                return memo[i][c];
            }
            if (c < coins[i]) {
                return memo[i][c] = dfs(i - 1, c);
            }
            return memo[i][c] = Math.min(dfs(i - 1, c), dfs(i, c - coins[i]) + 1);
        }
    }

    class Solution1 {
        // 选不选当前位置
        // f[i][remain] = min{f[i][remain-coins[j]]} + 1

        private int[] coins;
        private int[][] cache;

        // 递推
        public int coinChange(int[] coins, int amount) {
            int n = coins.length;
            // i:-1~n-1, c:0~amount
            int[][] cache = new int[n + 1][amount + 1];
            Arrays.fill(cache[0], Integer.MAX_VALUE / 2); // i<0&&c!=0 不合法
            cache[0][0] = 0;
            for (int i = 0; i < n; ++i) { // 枚举硬币
                for (int c = 0; c <= amount; ++c) { // 枚举金额
                    if (coins[i] > c) { // 不能选当前硬币
                        cache[i + 1][c] = cache[i][c];
                    } else {
                        cache[i + 1][c] = Math.min(cache[i][c], cache[i + 1][c - coins[i]] + 1);
                    }
                }
            }
            int ans = cache[n][amount];
            return ans < Integer.MAX_VALUE / 2 ? ans : -1;
        }

        // dfs TLE
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
                    return Integer.MAX_VALUE / 2; // 不合法
                }
            }
            if (c < coins[i]) { // 不能选当前数
                return dfs1(i - 1, c);
            }
            return Math.min(dfs1(i - 1, c), dfs1(i, c - coins[i]) + 1); // 选或不选
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}