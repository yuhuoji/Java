package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 209 Minimum Size Subarray Sum
public class LC209MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println("LC " + 209);
        Solution solution = new LC209MinimumSizeSubarraySum().new Solution();

        int target = 11;
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(solution.minSubArrayLen(target, nums));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 滑动窗口
        public int minSubArrayLen(int target, int[] nums) {
            int n = nums.length;
            int l = 0;
            int ans = n + 1;
            int sum = 0;
            for (int r = 0; r < n; ++r) {
                sum += nums[r];
                while (sum >= target) {
                    ans = Math.min(ans, r - l + 1);
                    sum -= nums[l++];
                }
            }
            return ans == n + 1 ? 0 : ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}