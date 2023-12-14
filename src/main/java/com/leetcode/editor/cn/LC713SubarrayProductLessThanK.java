package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 713 Subarray Product Less Than K
public class LC713SubarrayProductLessThanK {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 713);
        Solution solution = new LC713SubarrayProductLessThanK().new Solution();

    }
    // 滑动窗口 left合法左端点的最小值

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            if (k <= 1) {
                return 0;
            }
            // k>1
            int n = nums.length;
            int cnt = 0;
            int prod = 1;
            //[l,r]
            for (int l = 0, r = 0; r < n; ++r) {
                prod *= nums[r];
                while (prod >= k) {
                    prod /= nums[l];
                    l++;
                }
                cnt += r - l + 1;
            }
            return cnt;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}