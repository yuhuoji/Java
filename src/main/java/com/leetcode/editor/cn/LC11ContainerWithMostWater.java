package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 11 盛最多水的容器
public class LC11ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 11);
        Solution solution = new LC11ContainerWithMostWater().new Solution();

    }

    // REVIEW @date 2025-08-26
    // !!!错误：没用height[i]的值比较

    // leetcode submit region begin(Prohibit modification and deletion)

    // 贪心
    // 如何证明保证遍历了最大值 分类讨论：移动长板或移动短板
    class Solution {
        // are =min(l,r)*(r-l)
        public int maxArea(int[] height) {
            int n = height.length;
            int left = 0, right = n - 1;
            int mx = 0;
            while (left < right) {
                mx = Math.max(mx, Math.min(height[left], height[right]) * (right - left));
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return mx;
        }

        // area=min(l,r)*(r-l)
        // 只有比curL更大的才可能取得更大值
    }

    class Solution2 {
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