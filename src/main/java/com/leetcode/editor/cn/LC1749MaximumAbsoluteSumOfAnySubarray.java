package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 1749 任意子数组和的绝对值的最大值
public class LC1749MaximumAbsoluteSumOfAnySubarray {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1749);
        Solution solution = new LC1749MaximumAbsoluteSumOfAnySubarray().new Solution();

    }

    // REVIEW @date 2024-07-11
    // 最大子段和（允许子数组为空）
    // f[i] 以nums[i]结尾的最大和
    // g[i] 最小
    // f[i]=max(nums[i],f[i-1]+nums[i])
    // g[i]=min(nums[i],g[i-1]+nums[i])
    // 返回max(abs(mx),abs(mn))
    // ans>=0
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxAbsoluteSum(int[] nums) {
            int sum = 0, mx = 0, mn = 0;
            for (int x : nums) {
                sum += x;
                if (sum > mx) {
                    mx = sum;
                } else if (sum < mn) {
                    mn = sum;
                }
            }
            return mx - mn;
        }

        public int maxAbsoluteSum1(int[] nums) {
            int n = nums.length;
            int[] f = new int[n + 1];
            int[] g = new int[n + 1];
            int mx = nums[0];
            int mn = nums[0];
            for (int i = 0; i < n; ++i) {
                f[i + 1] = Math.max(nums[i], f[i] + nums[i]);
                g[i + 1] = Math.min(nums[i], g[i] + nums[i]);
                mx = Math.max(mx, f[i + 1]);
                mn = Math.min(mn, g[i + 1]);
            }
            return Math.max(Math.abs(mx), Math.abs(mn));
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}