package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 53 最大子数组和
public class LC53MaximumSubarray {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 53);
        Solution solution = new LC53MaximumSubarray().new Solution();

    }

    // REVIEW @date 2024-07-11 Kadane算法
    // 不允许空数组
    // !!dp定义f[i]以nums[i]"结尾"的最大子数组的和
    // f[i] 以nums[i]结尾的最大子数组的和 !!!
    // f[i]
    // =nums[i] 只选nums[i]
    // =f[i-1]+nums[i] 以nums[i-1]结尾加上nums[i]的子数组
    // f[i]=max(nums[i],f[i-1]+nums[i])
    // 返回max(f)
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 不接受空数组
        public int maxSubArray(int[] nums) {
            int maxOfEnd = 0, maxSum = Integer.MIN_VALUE;
            for (int x : nums) {
                maxOfEnd = Math.max(x, maxOfEnd + x);
                maxSum = Math.max(maxSum, maxOfEnd);
            }
            return maxSum;
        }

        public int maxSubArray2(int[] nums) {
            int n = nums.length;
            int[] f = new int[n + 1];
            int ans = nums[0];
            for (int i = 0; i < n; ++i) {
                f[i + 1] = Math.max(nums[i], f[i] + nums[i]);
                ans = Math.max(ans, f[i + 1]);
            }
            return ans;
        }

        // sum[i+1] 0..i 的前缀和
        // 前缀和-最小前缀和
        public int maxSubArray1(int[] nums) {
            int n = nums.length;
            int minPrefix = 0;
            int prefix = 0;
            int ans = Integer.MIN_VALUE;
            for (int i = 0; i < n; ++i) {
                prefix += nums[i];
                ans = Math.max(ans, prefix - minPrefix);
                minPrefix = Math.min(minPrefix, prefix);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}