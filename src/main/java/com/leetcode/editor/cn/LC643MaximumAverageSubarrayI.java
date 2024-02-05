package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 643 Maximum Average Subarray I
public class LC643MaximumAverageSubarrayI {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 643);
        Solution solution = new LC643MaximumAverageSubarrayI().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            int n = nums.length;
            int sum = 0;
            for (int i = 0; i < k; ++i) {
                sum += nums[i];
            }
            int maxSum = sum;
            for (int i = k; i < n; ++i) {
                sum += nums[i];
                sum -= nums[i - k];
                maxSum = Math.max(maxSum, sum);
            }
            return (double) maxSum / k;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}