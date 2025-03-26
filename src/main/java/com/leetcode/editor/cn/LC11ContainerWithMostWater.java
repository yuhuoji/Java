package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 11 盛最多水的容器
public class LC11ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 11);
        Solution solution = new LC11ContainerWithMostWater().new Solution();

    }

    // 秒了 贪心 双指针

    // leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public int maxArea(int[] height) {
            int n = height.length;
            int l = 0, r = n - 1;
            int mx = 0;
            while (l < r) {
                int h = Math.min(height[l], height[r]);
                mx = Math.max(mx, (r - l) * h);
                if (height[l] <= height[r]) {
                    l++;
                } else {
                    r--;
                }
            }
            return mx;
        }
    }

    class Solution1 {
        public int maxArea(int[] height) {
            int n = height.length;
            int ans = 0;
            for (int l = 0, r = n - 1; l < r; ) {
                int h = Math.min(height[l], height[r]);
                ans = Math.max(ans, h * (r - l));
                if (height[l] <= height[r]) {
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