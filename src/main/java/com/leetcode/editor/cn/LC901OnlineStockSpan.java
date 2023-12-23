package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.ArrayDeque;
import java.util.Deque;

// 901 Online Stock Span
public class LC901OnlineStockSpan {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 901);
        StockSpanner stockSpanner = new LC901OnlineStockSpan().new StockSpanner();

    }

    // 单调栈 及时去掉无用数据，保证栈中元素有序。
    // 包括今天
    // 找前面最近的大于price是哪天
    // leetcode submit region begin(Prohibit modification and deletion)
    class StockSpanner {
        private Deque<int[]> stk = new ArrayDeque<>();
        private int curDay = -1;

        public StockSpanner() {
            stk.push(new int[]{-1, Integer.MAX_VALUE}); // 保证栈不会空
        }

        public int next(int price) {
            while (price >= stk.peek()[1]) { // 维护单调栈 比当前价格小且靠前，不可能成为上一个最大元素了
                stk.pop();
            }
            curDay++; // 当前天数加1
            int ans = curDay - stk.peek()[0];
            stk.push(new int[]{curDay, price});
            return ans;
        }
    }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
// leetcode submit region end(Prohibit modification and deletion)

}