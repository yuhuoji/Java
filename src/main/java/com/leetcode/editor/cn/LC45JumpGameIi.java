package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 45 Jump Game II
public class LC45JumpGameIi {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 45);
        Solution solution = new LC45JumpGameIi().new Solution();

    }
    // 保证可以到n-1
    // REVIEW @date 2023-11-15

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 维护最右可达位置
        public int jump(int[] nums) {
            int n = nums.length;
            int step = 0, end = 0, maxPos = 0;
            for (int i = 0; i < n - 1; ++i) {
                maxPos = Math.max(maxPos, i + nums[i]);
                if (i == end) { // 到达边界，增加跳跃并更新边界
                    end = maxPos;
                    step++;
                }
            }
            return step;
        }

        // 合并区间
        public int jump1(int[] nums) {
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