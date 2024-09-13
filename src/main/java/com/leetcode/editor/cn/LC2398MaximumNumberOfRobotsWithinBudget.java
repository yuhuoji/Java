package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 2398 预算内的最多机器人数目
public class LC2398MaximumNumberOfRobotsWithinBudget {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2398);
        Solution solution = new LC2398MaximumNumberOfRobotsWithinBudget().new Solution();

    }
    // 需要max[i,j] sum[i,j]
    // 滑动窗口+单调栈维护最大值+前缀和

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
            int n = chargeTimes.length;
            int ans = 0;
            long sum = 0; // 前缀和
            Deque<Integer> q = new ArrayDeque<>(); // 单调队列维护i..j最大值
            for (int l = 0, r = 0; r < n; ++r) {
                sum += runningCosts[r];
                // 入
                while (!q.isEmpty() && chargeTimes[q.peekLast()] <=  chargeTimes[r]) {
                    q.pollLast();
                }
                q.offerLast(r);
                // 出
                while (!q.isEmpty() && chargeTimes[q.peekFirst()] + (r - l + 1) * sum > budget) { // 移动l，期间维护单调栈
                    if (q.peekFirst() == l) {
                        q.pollFirst();
                    }
                    sum -= runningCosts[l++];
                }
                // cost<=budget or 没有合法答案 l = r + 1
                ans = Math.max(ans, r - l + 1);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}