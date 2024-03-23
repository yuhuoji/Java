package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 11 Container With Most Water
public class LC11ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 11);
        Solution solution = new LC11ContainerWithMostWater().new Solution();

    }

    // 向内移动短板 可能会更大
    // 向内移动长板 只可能变小
    // 贪心 需要证明能获得最优解
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            int n = height.length;
            int ans = 0;
            int l = 0, r = n - 1;
            while (l < r) {
                ans = Math.max(ans, (r - l) * Math.min(height[l], height[r]));
                if (height[l] < height[r]) {
                    l++;
                } else {
                    r--;
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}