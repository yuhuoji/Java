package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 1438 绝对差不超过限制的最长连续子数组
public class LC1438LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1438);
        Solution solution = new LC1438LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit().new Solution();

    }
    // 靠右且大的值更可能成为滑动窗口最大值

    // leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int ans = 0;
        Deque<Integer> qMax = new ArrayDeque<>(); // 单调递减维护滑动窗口最大值
        Deque<Integer> qMin = new ArrayDeque<>(); // 单调递增维护滑动窗口最小值
        for (int l = 0, r = 0; r < n; ++r) {
            int x = nums[r];
            // 入
            while (!qMax.isEmpty() && nums[qMax.peekLast()] <= x) {
                qMax.pollLast();
            }
            qMax.offerLast(r);
            while (!qMin.isEmpty() && nums[qMin.peekLast()] >= x) {
                qMin.pollLast();
            }
            qMin.offerLast(r);
            // 出 max-min>limit
            while (nums[qMax.peekFirst()] - nums[qMin.peekFirst()] > limit) {
                if (qMax.peekFirst() == l) {
                    qMax.pollFirst();
                }
                if (qMin.peekFirst() == l) {
                    qMin.pollFirst();
                }
                l++;
            }
            // 更新答案
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
// leetcode submit region end(Prohibit modification and deletion)

}