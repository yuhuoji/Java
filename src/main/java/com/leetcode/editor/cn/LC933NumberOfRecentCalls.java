package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.ArrayDeque;
import java.util.Deque;

// 933 最近的请求次数
public class LC933NumberOfRecentCalls {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 933);
        RecentCounter recentCounter = new LC933NumberOfRecentCalls().new RecentCounter();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class RecentCounter {
        private Deque<Integer> q;

        public RecentCounter() {
            q = new ArrayDeque<>();
        }

        public int ping(int t) {
            q.addLast(t);
            while (!q.isEmpty() && q.peekFirst() < t - 3000) {
                q.pollFirst();
            }
            return q.size();
        }
    }

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
// leetcode submit region end(Prohibit modification and deletion)

}