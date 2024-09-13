package com.leetcode.editor.cn;

import java.util.Arrays;

public class LC416PartitionEqualSubsetSum {
    public static void main(String[] args) {
        System.out.println("LC " + 416);
        Solution solution = new LC416PartitionEqualSubsetSum().new Solution();

    }
    // lc494
    // 01背包 恰好选容量为c的方法数，物品value=1
    // 数组和s，s1=s2=s/2,则s必须为偶数
    // 定义f[i][c] 0..i选择容量为c的方法数
    // f[i][c] = f[i-1][c] + f[i-1][c-x]
    // 返回f[n-1][capacity]
    // 初始化 f[-][0]=1 容量选完了，也是一种合理方案 f[-][+]=inf/2 容量没选完不合理

    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public boolean canPartition1(int[] nums) {
            int n = nums.length;
            int sum = Arrays.stream(nums).sum();
            if (sum % 2 == 1) {
                return false;
            }
            int capacity = sum / 2;
            boolean[][] f = new boolean[n + 1][capacity + 1];
            Arrays.fill(f[0], false);
            f[0][0] = true;
            for (int i = 0; i < n; ++i) {
                for (int c = 0; c <= capacity; ++c) {
                    if (c < nums[i]) {
                        f[i + 1][c] = f[i][c];
                    } else {
                        f[i + 1][c] = f[i][c] || f[i][c - nums[i]];
                    }
                }
            }
            boolean ans = f[n][capacity];
            return ans;
        }

        // 直接计算方法数，最后判断是否合理
        public boolean canPartition(int[] nums) {
            int n = nums.length;
            int sum = Arrays.stream(nums).sum();
            if (sum % 2 == 1) {
                return false;
            }
            int capacity = sum / 2;
            int[][] f = new int[n + 1][capacity + 1];
            f[0][0] = 1;
            for (int i = 0; i < n; ++i) {
                for (int c = 0; c <= capacity; ++c) {
                    if (c < nums[i]) {
                        f[i + 1][c] = f[i][c];
                    } else {
                        f[i + 1][c] = f[i][c] + f[i][c - nums[i]];
                    }
                }
            }
            int ans = f[n][capacity];
            return ans != 0;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}