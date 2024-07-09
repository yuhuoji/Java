package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 2466 统计构造好字符串的方案数
public class LC2466CountWaysToBuildGoodStrings {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2466);
        Solution solution = new LC2466CountWaysToBuildGoodStrings().new Solution();
        int a = 1_000_000;
        int b = 1_000_000;
        int MOD = 1_000_000_007;

        // 错误：直接相乘会导致溢出
        int result = (a * b) % MOD;

        // 正确：使用 long 防止溢出
        // long result = ((long) a * b) % MOD;
        System.out.println(result);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int MOD = (int) (1e9 + 7);

        // f[i]=f[i-zero]+f[i-one]
        public int countGoodStrings(int low, int high, int zero, int one) {
            int[] f = new int[high + 1];
            f[0] = 1;
            for (int i = 1; i <= high; ++i) {
                if (i >= zero) {
                    f[i] = (f[i] + f[i - zero]) % MOD;
                }
                if (i >= one) {
                    f[i] = (f[i] + f[i - one]) % MOD;
                }
            }
            int ans = 0;
            for (int i = low; i <= high; ++i) {
                ans = (ans + f[i]) % MOD;
            }
            return ans;
        }
    }

    class Solution1 {
        int zero;
        int one;
        int[] memo;
        final int MOD = (int) (1e9 + 7);

        public int countGoodStrings(int low, int high, int zero, int one) {
            this.zero = zero;
            this.one = one;
            memo = new int[high + 1];
            Arrays.fill(memo, -1);
            memo[0] = 1;
            int sum = 0;
            for (int i = high; i >= low; --i) {
                sum = (sum + dfs(i)) % MOD;
            }
            return sum;
        }

        // dfs(i)=dfs(i-zero)+dfs(i-one)
        private int dfs(int i) {
            if (i < 0) {
                return 0;
            }
            if (memo[i] != -1) {
                return memo[i];
            }
            int ans = (dfs(i - zero) % MOD + dfs(i - one) % MOD) % MOD;
            memo[i] = ans;
            return memo[i];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}