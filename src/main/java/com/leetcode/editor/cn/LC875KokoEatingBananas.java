package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 875 爱吃香蕉的珂珂
public class LC875KokoEatingBananas {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 875);
        Solution solution = new LC875KokoEatingBananas().new Solution();

    }
    // REVIEW @date 2024-07-04 整数溢出
    // 单调性 二分吃的速度

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] piles;
        private int h;

        public int minEatingSpeed(int[] piles, int h) {
            int n = piles.length;
            this.piles = piles;
            this.h = h;
            // n <= ans <= max
            int left = 1, right = Arrays.stream(piles).max().getAsInt();
            while (left <= right) {
                int mid = ((right - left) >> 1) + left;
                if (check(mid)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        // 能不能在h小时内吃完
        private boolean check(int speed) {
            int time = 0;
            for (int pile : piles) {
                time += (pile - 1) / speed + 1;
                if (time > h) { //！整数溢出
                    return false;
                }
            }
            return time <= h;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}