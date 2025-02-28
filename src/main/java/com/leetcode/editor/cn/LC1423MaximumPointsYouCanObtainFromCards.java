package com.leetcode.editor.cn;

import java.util.Arrays;

// 1423 可获得的最大点数
public class LC1423MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "1423");
        Solution solution = new LC1423MaximumPointsYouCanObtainFromCards().new Solution();
        //[9,7,7,9,7,7,9]
        // 			7
        int[] cardPoints = {9, 7, 7, 9, 7, 7, 9};
        int k = 7;
        System.out.println(solution.maxScore(cardPoints, k));
    }

    // TODO @date 2025-02-28
    // 前缀和？
    // 长度为n-k的滑动窗口 求长度为n-k的滑动窗口最小值
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            int n = cardPoints.length;
            int totalSum = Arrays.stream(cardPoints).sum();
            if (k == n) {
                return totalSum;
            }
            int minSum = totalSum, sum = 0;
            for (int i = 0; i < n; ++i) {
                int in = cardPoints[i];
                sum += in;
                if (i < n - k - 1) {
                    continue;
                }
                minSum = Math.min(minSum, sum);
                int out = cardPoints[i - k + 1];
                sum -= out;
            }
            return totalSum - minSum;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}