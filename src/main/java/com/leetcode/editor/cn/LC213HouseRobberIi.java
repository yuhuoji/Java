package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 213 打家劫舍 II
public class LC213HouseRobberIi {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 213);
        Solution solution = new LC213HouseRobberIi().new Solution();

    }

    // 偷最后一个和不偷最后一个
    // 在0..n-2和1..n-1偷！不对
    // f[i,j] i..j偷盗的金额
    // f[i,j]=max(f[i,j-2]+nums[j],f[i,j-1])
    // f[j]=max(f[j-2]+nums[j],f[j-1])
    // f[j+2]=max(f[j]+nums[j],f[j+1])
    // 返回 max(f[1,n-1],f[0,n-2])
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int rob(int[] nums) {
            int n = nums.length;
            return Math.max(nums[n - 1] + robWithinRange(nums, 1, n - 2), robWithinRange(nums, 0, n - 1));
            // return Math.max(nums[0] + robWithinRange(nums, 2, n - 1), robWithinRange(nums, 1, n));
        }

        // 从[s,e)偷
        public int robWithinRange(int[] nums, int start, int end) {
            int n = nums.length;
            int[] f = new int[n + 2];
            for (int i = start; i < end; ++i) {
                f[i + 2] = Math.max(f[i + 1], f[i] + nums[i]);
            }
            return f[end + 1];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}