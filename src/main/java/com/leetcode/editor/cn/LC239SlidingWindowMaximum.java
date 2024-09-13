package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 239 滑动窗口最大值
public class LC239SlidingWindowMaximum {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 239);
        Solution solution = new LC239SlidingWindowMaximum().new Solution();

    }
    // 单调栈 维护内元素递减
    // 右侧且值大的元素，才可能成为滑动窗口最大值

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
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