package com.leetcode.editor.cn;

import java.util.Arrays;

// 2919 Minimum Increment Operations to Make Array Beautiful
public class LC2919MinimumIncrementOperationsToMakeArrayBeautiful {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2919);
        Solution solution = new LC2919MinimumIncrementOperationsToMakeArrayBeautiful().new Solution();

        int[] nums = {1, 1, 2};
        int k = 1;
        System.out.println(solution.minIncrementOperations(nums, k));
    }

    // TODO @date 2023-11-14 空间压缩
    // 子序列dp
    // 选或不选
    // 枚举选哪个 LIS
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 类似打家劫舍
        // 距离为3
        // 子数组最大元素>=k
        // 求最小递增数
        private int[] nums;
        private int k;

        // dp
        // 插入f[i]
        // 选 f(i+1,j) = f(i,j) + max(k-nums[i],0)
        // j<2 不选 f(i+1,j) = f(i,j+1)
        // 边界 i=0 f[0][]=0
        // 入口 f[n][0]
        public long minIncrementOperations2(int[] nums, int k) {
            int n = nums.length;
            long[][] f = new long[n + 1][3];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < 3; ++j) {
                    // 选
                    long res = f[i][0] + Math.max(k - nums[i], 0);
                    if (j < 2) {// 不选
                        res = Math.min(res, f[i][j + 1]);
                    }
                    f[i + 1][j] = res;
                }
            }
            return f[n][0];
        }

        // 记忆化搜索
        public long minIncrementOperations(int[] nums, int k) {
            int n = nums.length;
            this.nums = nums;
            this.k = k;
            long[][] memo = new long[n][3];
            // 设为-1
            for (long[] row : memo) {
                Arrays.fill(row, -1);
            }
            return dfs2(n - 1, 0, memo);
        }

        private long dfs2(int i, int j, long[][] memo) {
            if (i < 0) {// base case
                return 0;
            }
            if (memo[i][j] != -1) { // 计算过，直接返回结果
                return memo[i][j];
            }
            long res = dfs2(i - 1, 0, memo) + Math.max(k - nums[i], 0);// 选
            if (j < 2) {// 不选
                res = Math.min(res, dfs2(i - 1, j + 1, memo));
            }
            return memo[i][j] = res;
        }


        // 递归
        // 选dfs(i,j) = dfs(i-1,j) + max(k-nums[i],0)
        // j<2 不选 dfs(i,j) = dfs(i-1,j+1)
        // 边界 i<0 dfs=0
        public long minIncrementOperations1(int[] nums, int k) {
            int n = nums.length;
            this.nums = nums;
            this.k = k;
            return dfs1(n - 1, 0);
        }

        // 右侧有几个数没选
        private long dfs1(int i, int j) {
            if (i < 0) {
                return 0;
            }
            long res = dfs1(i - 1, 0) + Math.max(k - nums[i], 0);// 选
            if (j < 2) {// 不选
                res = Math.min(res, dfs1(i - 1, j + 1));
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}