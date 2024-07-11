package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 1191 K 次串联后最大子数组之和
public class LC1191KConcatenationMaximumSum {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1191);
        Solution solution = new LC1191KConcatenationMaximumSum().new Solution();
        String s = "[-9,13,4,-16,-12,-16,3,-7,5,-16,16,8,-1,-13,15,3]";
        System.out.println(Arrays.stream(LeetCodeHelper.stringToIntegerArray(s)).sum());
    }

    // 分类讨论
    // k=1 (都是负数)
    // k个全部和 (都是正数)
    // 后缀+前缀
    // k>=2时，后缀 + k-2个和 + 前缀
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int MOD = (int) (1e9 + 7);

        public int kConcatenationMaxSum(int[] arr, int k) {
            int n = arr.length;
            long ans = 0;
            ans = Math.max(ans, maxSubArray(arr));
            int sum = Arrays.stream(arr).sum();
            ans = Math.max(ans, (long) k * sum);
            if (k >= 2) {
                int maxPrefix = 0, maxSuffix = 0, prefix = 0, suffix = 0;
                for (int i = 0; i < n; ++i) {
                    prefix += arr[i];
                    maxPrefix = Math.max(maxPrefix, prefix);
                }
                for (int i = n - 1; i >= 0; --i) {
                    suffix += arr[i];
                    maxSuffix = Math.max(maxSuffix, suffix);
                }
                ans = Math.max(ans, maxPrefix + maxSuffix);
                ans = Math.max(ans, (long) maxPrefix + (long) (k - 2) * sum + maxSuffix);
            }
            return (int) (ans % MOD);
        }

        private int maxSubArray(int[] nums) {
            int n = nums.length;
            int[] f = new int[n + 1];
            int ans = nums[0];
            for (int i = 0; i < n; ++i) {
                f[i + 1] = Math.max(nums[i], f[i] + nums[i]);
                ans = Math.max(ans, f[i + 1]);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}