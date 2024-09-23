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


    //lc45

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            int step = 0, end = 0, maxPos = 0;
            for (int i = 0; i < n; ++i) {
                maxPos = Math.max(maxPos, i + nums[i]);
                if (i > end) {
                    return false;
                }
                if (i == end) { // 到达边界，增加跳跃并更新边界
                    end = maxPos;
                    step++;
                }
            }
            System.out.println(step);
            return true;
        }

        // 维护最右可达位置
        public boolean canJump1(int[] nums) {
            int n = nums.length;
            int max = 0;
            for (int i = 0; i < n; ++i) {
                if (i > max) {
                    return false;
                }
                max = Math.max(max, i + nums[i]);
            }
            return true; // max >= n - 1
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}