package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 239 滑动窗口最大值
public class LC239SlidingWindowMaximum {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 239);
        Solution solution = new LC239SlidingWindowMaximum().new Solution();

    }

    // REVIEW @date 2025-09-25 单调栈 滑动窗口的最大值
    // 单调栈 维护内元素递减
    // 右侧且值大的元素，才可能成为滑动窗口最大值

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            Deque<Integer> q = new ArrayDeque<>();
            int[] ans = new int[n - k + 1];
            for (int i = 0; i < n; ++i) {
                int x = nums[i];
                while (!q.isEmpty() && nums[q.peekLast()] < x) {
                    q.pollLast();
                }
                q.offerLast(i);
                while (q.peekFirst() < i - k + 1) {
                    q.pollFirst();
                }
                if (i >= k - 1) { // 滑动窗口长度满足k后
                    ans[i - k + 1] = nums[q.peekFirst()]; // 单调栈中第一个数就是当前滑动窗口的最大值
                }
            }
            return ans;
        }

        public int[] maxSlidingWindow1(int[] nums, int k) {
            int n = nums.length;
            int[] ans = new int[n - k + 1];
            Deque<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < n; ++i) {
                // 入
                int x = nums[i];
                while (!q.isEmpty() && nums[q.peekLast()] <= x) {
                    q.pollLast();
                }
                q.offerLast(i);
                // 出
                if (q.peekFirst() < i - k + 1) {
                    q.pollFirst();
                }
                // 更新答案
                if (i >= k - 1) {
                    ans[i - k + 1] = nums[q.peekFirst()];
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}