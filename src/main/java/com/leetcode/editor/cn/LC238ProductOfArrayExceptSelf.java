package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 238 Product of Array Except Self
public class LC238ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 238);
        Solution solution = new LC238ProductOfArrayExceptSelf().new Solution();

    }

    // 前缀+后缀
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] answer = new int[n];
            answer[n - 1] = 1;

            // ans = suf
            for (int i = n - 2; i >= 0; --i) {
                answer[i] = answer[i + 1] * nums[i + 1];
            }

            // ans = pre * suf
            int pre = 1;
            for (int i = 0; i < n; ++i) {
                answer[i] *= pre;
                pre *= nums[i];
            }

            return answer;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}