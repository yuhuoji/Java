package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// 84 Largest Rectangle in Histogram
public class LC84LargestRectangleInHistogram {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 84);
        Solution solution = new LC84LargestRectangleInHistogram().new Solution();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(solution.largestRectangleArea(heights));
    }

    // 栈
    // 单调栈
    // 找到每个位置左右严格小于等于的位置
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int[] newHeights = new int[n + 2]; // 引入哨兵 [1,2,3]->[0,1,2,3,0]
            System.arraycopy(heights, 0, newHeights, 1, n);
            newHeights[0] = 0;
            newHeights[n + 1] = 0;
            int ans = 0;
            Deque<Integer> stk = new ArrayDeque<>(n); // 递增栈
            for (int i = 0; i < n + 2; ++i) {
                while (!stk.isEmpty() && newHeights[i] < newHeights[stk.peek()]) { // 小于栈顶元素
                    int cur = stk.pop();
                    int left = stk.peek() + 1; // 左侧是栈下面的元素
                    int right = i - 1; // 右侧是当前元素左侧的元素
                    ans = Math.max(ans, (right - left + 1) * newHeights[cur]);
                }
                stk.push(i);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}