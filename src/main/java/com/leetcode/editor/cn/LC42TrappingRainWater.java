package com.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

// 42 接雨水
public class LC42TrappingRainWater {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 42);
        Solution solution = new LC42TrappingRainWater().new Solution();

    }

    // REVIEW @date 2025-08-29 单调栈及相关题目
    // 双指针 前后缀分解 相向双指针 竖着算
    // 单调栈 横着算
    // 定义 lMax[i] 无论是否包含 i 位置的值，最终结果都是正确的

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 单调栈 和上一个最大元素有关
        // 找上一个更大元素，在找的过程中填坑。
        public int trap(int[] height) {
            int n = height.length;
            int ans = 0;
            Deque<Integer> st = new ArrayDeque<>();
            for (int i = 0; i < n; ++i) {
                int h = height[i];
                while (!st.isEmpty() && h >= height[st.peek()]) {
                    int bottomH = height[st.pop()];
                    if (st.isEmpty()) {
                        break;
                    }
                    int left = st.getFirst();
                    int dh = Math.min(height[left], height[i]) - bottomH;
                    ans += dh * (i - left - 1);
                }
                st.push(i);
            }
            return ans;
        }

        // 相向双指针 由前后缀分解而来
        public int trap3(int[] height) {
            int n = height.length;
            int ans = 0;
            int lMax = 0, rMax = 0; // 初始化不影响
            int left = 0, right = n - 1;
            while (left < right) {
                lMax = Math.max(lMax, height[left]);
                rMax = Math.max(rMax, height[right]);
                if (lMax < rMax) {
                    ans += lMax - height[left]; // 此时lMax一定大于height[left]
                    left++;
                } else {
                    ans += rMax - height[right];
                    right--;
                }
            }
            return ans;
        }

        // 前后缀分解 i位置的水量=max(min(lMax,rMax)-h,0)
        // lMax[i] 0..i位置的最大值，包括i位置
        public int trap2(int[] height) {
            int n = height.length;
            int[] lMax = new int[n], rMax = new int[n];
            lMax[0] = height[0];
            for (int i = 1; i < n; ++i) {
                lMax[i] = Math.max(lMax[i - 1], height[i]);
            }
            rMax[n - 1] = height[n - 1];
            for (int i = n - 2; i >= 0; --i) {
                rMax[i] = Math.max(rMax[i + 1], height[i]);
            }
            int ans = 0;
            for (int i = 1; i < n - 1; ++i) {
                ans += Math.max(Math.min(lMax[i], rMax[i]) - height[i], 0);
            }
            return ans;
        }

        // lMax[i] 0..i-1位置的最大值，严格
        // 因为最后取结果的公式，数学上等价

        // 两种定义的数学等价性
        // 1.当 lMax[i] 包含 i 位置时：
        // lMax[i] = max(左侧所有元素, height[i])，因此 lMax[i] >= height[i]。
        // 同理，rMax[i] = max(右侧所有元素, height[i])，因此 rMax[i] >= height[i]。
        // 此时 Math.min(lMax[i], rMax[i]) >= height[i]，min(lMax[i], rMax[i]) 的结果有两种可能：
        // 若结果等于 height[i]：则 min(...) - height[i] = 0，接水量为 0（正确，当前位置是凸起或与至少一侧高度水平）。
        // 若结果大于 height[i]：则这个 “大于” 的部分必然来自左侧或右侧的外部元素（因为 height[i] 本身无法让 min(...) 超过自己），此时结果等价于 “左右外部的短板”，减去 height[i] 后得到正确接水量。
        // 2.当 lMax[i] 不包含 i 位置时：
        // lMax[i] = max(左侧所有元素)（严格左侧最大值），rMax[i] = max(右侧所有元素)（严格右侧最大值）。
        // 此时 min(lMax[i], rMax[i]) 直接表示 “左右外部的短板”，若这个值大于 height[i]，则接水量为两者差值；否则为 0（正确）。

        public int trap1(int[] height) {
            int n = height.length;
            int[] lMax = new int[n], rMax = new int[n];
            lMax[0] = 0;
            for (int i = 1; i < n; ++i) {
                lMax[i] = Math.max(lMax[i - 1], height[i - 1]);
            }
            rMax[n - 1] = 0;
            for (int i = n - 2; i >= 0; --i) {
                rMax[i] = Math.max(rMax[i + 1], height[i + 1]);
            }
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                ans += Math.max(Math.min(lMax[i], rMax[i]) - height[i], 0);
            }
            return ans;
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