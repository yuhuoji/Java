package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 42 接雨水
public class LC42TrappingRainWater {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 42);
        Solution solution = new LC42TrappingRainWater().new Solution();

    }

    // REVIEW @date 2024-07-23 单调栈
    // TODO @date 2025-08-22
    // 双指针 竖着算
    // 单调栈 横着算

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int n = height.length;
            int[] lMax = new int[n], rMax = new int[n];
            return 0;
        }
    }

    class Solution1 {
        // ！！！单调栈
        public int trap(int[] height) {
            int n = height.length;
            int ans = 0;
            Deque<Integer> st = new ArrayDeque<>();
            for (int i = 0; i < n; ++i) {
                while (!st.isEmpty() && height[i] >= height[st.peek()]) {
                    int bottom = st.pop(); // 根据三个位置计算，bottom left right
                    if (st.isEmpty()) {
                        break;
                    }
                    int left = st.peek();
                    int dh = Math.min(height[left], height[i]) - height[bottom];
                    ans += dh * (i - left - 1);
                }
                st.push(i);
            }
            return ans;
        }

        // 双指针
        public int trap2(int[] height) {
            int n = height.length;
            int lMax = 0, rMax = 0; // lMax[i] 0..i位置最高的高度
            int ans = 0;
            for (int left = 0, right = n - 1; left < right; ) {
                lMax = Math.max(lMax, height[left]);
                rMax = Math.max(rMax, height[right]);
                if (height[left] <= height[right]) {
                    ans += lMax - height[left];
                    left++;
                } else {
                    ans += rMax - height[right];
                    right--;
                }
            }
            return ans;
        }

        // 合并后两个for
        public int trap11(int[] height) {
            int n = height.length;
            int[] lMax = new int[n], rMax = new int[n]; // lMax[i] 0..i位置最高的高度
            lMax[0] = height[0];
            for (int i = 1; i < n; ++i) {
                lMax[i] = Math.max(lMax[i - 1], height[i]);
            }
            rMax[n - 1] = height[n - 1];
            int ans = 0;
            for (int i = n - 2; i >= 0; --i) {
                rMax[i] = Math.max(rMax[i + 1], height[i]);
                ans += Math.max(0, Math.min(lMax[i], rMax[i]) - height[i]);
            }
            return ans;
        }

        public int trap1(int[] height) {
            int n = height.length;
            int[] lMax = new int[n], rMax = new int[n]; // lMax[i] 0..i位置最高的高度
            lMax[0] = height[0];
            for (int i = 1; i < n; ++i) {
                lMax[i] = Math.max(lMax[i - 1], height[i]);
            }
            rMax[n - 1] = height[n - 1];
            for (int i = n - 2; i >= 0; --i) {
                rMax[i] = Math.max(rMax[i + 1], height[i]);
            }
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                ans += Math.max(0, Math.min(lMax[i], rMax[i]) - height[i]);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}