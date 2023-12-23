package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.ArrayDeque;
import java.util.Deque;

// 739 Daily Temperatures
public class LC739DailyTemperatures {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 739);
        Solution solution = new LC739DailyTemperatures().new Solution();

    }

    // 单调栈 模板
    // 找后边第一个大于t是哪天
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            Deque<Integer> stk = new ArrayDeque<>();
            int[] ans = new int[n];
            for (int i = n - 1; i >= 0; --i) {
                while (!stk.isEmpty() && temperatures[i] >= temperatures[stk.peek()]) { // 温度低且靠后，不可能为更高气温了
                    stk.pop();
                }
                if (!stk.isEmpty()) {
                    ans[i] = stk.peek() - i;
                }
                stk.push(i);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}