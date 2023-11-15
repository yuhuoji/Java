package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 55 Jump Game
public class LC55JumpGame {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 55);
        Solution solution = new LC55JumpGame().new Solution();

        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(solution.canJump(nums));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // nums[i]是最大能跳的步数
        // 1|任何=1
        // 0|任何=任何
        public boolean canJump(int[] nums) {
            int n = nums.length;
            int max = 0;
            for (int i = 0; i < n; ++i) {
                if (i > max) {
                    return false;
                }
                max = Math.max(max, i + nums[i]);
            }
            return true; //max >= n - 1
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}