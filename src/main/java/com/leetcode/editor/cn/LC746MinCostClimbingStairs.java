package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 746 Min Cost Climbing Stairs
public class LC746MinCostClimbingStairs {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 746);
        Solution solution = new LC746MinCostClimbingStairs().new Solution();
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(solution.minCostClimbingStairs(cost));
    }

    // 前k个位置花费为0，一次跳k个位置
    // 求跳到n位置的花费最小
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] cost;
        int k = 2;

        // f[i+2] = min f[i+1]+cost[i+1], f[i]+cost[i]
        // 返回f[n+2]
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            // 0 1位置不需要花费就可以到达
            int f0 = 0, f1 = 0; // 0 1
            for (int i = 0; i < n - 1; ++i) {
                int f2 = Math.min(f1 + cost[i + 1], f0 + cost[i]);
                f0 = f1;
                f1 = f2;
            }
            return f1; // 返回到达n位置的花费
        }

        public int minCostClimbingStairs1(int[] cost) {
            int n = cost.length;
            this.cost = cost;
            // 0 1位置不需要花费就可以到达
            int res = Integer.MAX_VALUE;
            for (int i = 1; i <= k; ++i) {
                res = Math.min(res, dfs(n - i) + cost[n - i]);
            }
            return res;
        }

        // 当前位置i 到达i位置的花费dfs(i)
        // dfs(i) = min 之前所有的能到达距离
        // 边界
        // 入口
        int dfs(int i) {
            if (i <= 1) {
                return 0;
            }
            int res = Integer.MAX_VALUE;
            for (int j = 1; j <= k && i - j >= 0; ++j) {
                res = Math.min(res, dfs(i - j) + cost[i - j]);
            }
            return res == Integer.MAX_VALUE ? 0 : res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}