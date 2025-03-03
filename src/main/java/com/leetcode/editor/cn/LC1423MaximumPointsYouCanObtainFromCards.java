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

    // 1.逆向思维
    // 长度为n-k的滑动窗口(固定长度的滑动窗口) 求长度为n-k的滑动窗口最小值
    // 最大是10^9
    // REVIEW @date 2025-03-03
    // 2.前缀和
    // 开头一段+结尾一段长度共k的和
    // 初始化前k个数的和
    // i从1到k,s每次增加c[n-i]-c[k-i],维护max(s)

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxScore2(int[] cardPoints, int k) {
            int n = cardPoints.length;
            int s = 0;
            for (int i = 0; i < k; ++i) {
                s += cardPoints[i];
            }
            int maxS = s;
            for (int i = 1; i <= k; ++i) {
                s += cardPoints[n - i] - cardPoints[k - i];
                maxS = Math.max(maxS, s);
            }
            return maxS;
        }

        public int maxScore(int[] cardPoints, int k) {
            int n = cardPoints.length;
            // int total = Arrays.stream(cardPoints).sum();
            int total = 0;
            int sum = 0;
            for (int i = 0; i < n - k; ++i) {
                sum += cardPoints[i];
            }
            total = sum; // 计算total
            int mn = sum;
            for (int i = n - k; i < n; ++i) {
                total += cardPoints[i]; // 计算total
                sum += cardPoints[i] - cardPoints[i - n + k];
                mn = Math.min(sum, mn);
            }
            return total - mn;
        }

    }
// leetcode submit region end(Prohibit modification and deletion)

}