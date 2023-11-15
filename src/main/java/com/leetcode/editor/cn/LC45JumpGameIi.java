package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 45 Jump Game II
public class LC45JumpGameIi {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 45);
        Solution solution = new LC45JumpGameIi().new Solution();

    }
    //REVIEW @date 2023-11-15

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // It's guaranteed that you can reach nums[n - 1]
        // 求最小
        public int jump(int[] nums) {
            int n = nums.length;
            int cnt = 0; // 到达当前位置的跳跃次数
            int start = 0, end = 1; //[)
            while (end < n) {
                int max = 0;
                for (int i = start; i < end; ++i) {
                    max = Math.max(max, i + nums[i]);
                }
                start = end;
                end = max + 1;
                ++cnt;
            }
            return cnt;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}