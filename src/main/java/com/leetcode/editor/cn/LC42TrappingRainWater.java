package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 42 Trapping Rain Water
public class LC42TrappingRainWater {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 42);
        Solution solution = new LC42TrappingRainWater().new Solution();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(height));
    }

    // 横着 双指针
    // TODO @date 2024-03-20
    //  竖着 单调栈
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 相向双指针
        // 当前位置接多少水与左侧最高、右侧最高和高度有关
        public int trap(int[] height) {
            int ans = 0;
            int l = 0, r = height.length - 1;
            int lMax = 0, rMax = 0;
            while (l < r) {
                lMax = Math.max(lMax, height[l]);
                rMax = Math.max(rMax, height[r]);
                ans += lMax < rMax ? lMax - height[l++] : rMax - height[r--];
            }
            return ans;
        }

        // 横着计算 双指针 LC11
        public int trap1(int[] height) {
            int n = height.length;
            int ans = 0;
            int l = 0, r = n - 1;
            int base = 0;
            while (l < r) {
                ans += (r - l + 1) * (Math.min(height[l], height[r]) - base);
                base = Math.min(height[l], height[r]); // 当前已经计算到的高度
                // 移动短边
                if (height[l] <= height[r]) {
                    int lastL = height[l];
                    while (l < r && height[l] <= lastL) {
                        l++;
                    }
                } else {
                    int lastR = height[r];
                    while (l < r && height[r] <= lastR) {
                        r--;
                    }
                }
            }
            final int finalBase = base;
            return ans - Arrays.stream(height)
                    .map(h -> Math.min(h, finalBase)) // 将大于 base 的元素替换为 base
                    .sum();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}