package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;
import java.util.PriorityQueue;

// 2462 雇佣 K 位工人的总代价
public class LC2462TotalCostToHireKWorkers {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2462);
        Solution solution = new LC2462TotalCostToHireKWorkers().new Solution();

    }

    // 两个最小堆
    // 2*candidates + k <= n不会重叠， >会重叠
    // k * cost 10^10
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long totalCost(int[] costs, int k, int candidates) {
            int n = costs.length;
            if (2 * candidates + k > n) { // 会重叠
                Arrays.sort(costs);
                long ans = 0;
                for (int i = 0; i < k; ++i) {
                    ans += costs[i];
                }
                return ans;
            }
            // 不会重叠
            PriorityQueue<Integer> pre = new PriorityQueue<>();
            PriorityQueue<Integer> suf = new PriorityQueue<>();
            int i, j;
            for (i = 0, j = n - 1; i < candidates; ) { // 初始化两个小根堆
                pre.offer(costs[i++]);
                suf.offer(costs[j--]);
            }
            i = candidates;
            j = n - 1 - candidates;
            long ans = 0;
            while (k-- > 0) { // 更新
                if (pre.peek() <= suf.peek()) {
                    ans += pre.poll();
                    pre.offer(costs[i++]);
                } else {
                    ans += suf.poll();
                    suf.offer(costs[j--]);
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}