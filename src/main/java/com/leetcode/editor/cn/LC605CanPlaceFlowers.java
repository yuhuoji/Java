package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 605 Can Place Flowers
public class LC605CanPlaceFlowers {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 605);
        Solution solution = new LC605CanPlaceFlowers().new Solution();
        String s = "[1,0,0,0,1,0,0]";
        int n = 2;
        // int[] flowerbed = LeetCodeHelper.stringToIntegerArray(s);
        // int len = flowerbed.length;
        // int[] flower = new int[len + 2];
        // System.arraycopy(flowerbed, 0, flower, 1, len);
        // System.out.println(Arrays.toString(flower));
        System.out.println(solution.canPlaceFlowers(LeetCodeHelper.stringToIntegerArray(s), n));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 跳格子 碰到1就跳2格，只需要考虑后一位是不是1即可
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int len = flowerbed.length;
            for (int i = 0; i < len && n > 0; ) {
                if (flowerbed[i] == 1) {
                    i += 2;
                } else if (i == len - 1 || flowerbed[i + 1] == 0) {
                    n--;
                    i += 2;
                } else { // 1 0 0 1 0
                    i += 3;
                }
            }
            return n <= 0;
        }

        // 统计0的个数
        public boolean canPlaceFlowers1(int[] flowerbed, int n) {
            int len = flowerbed.length;
            int[] newArray = new int[len + 3];
            System.arraycopy(flowerbed, 0, newArray, 1, len);
            flowerbed = newArray;
            flowerbed[flowerbed.length - 1] = 1;
            int cnt0 = 0, cnt = 0;
            for (int x : flowerbed) {
                if (x == 0) {
                    cnt0++;
                } else {
                    cnt += (cnt0 - 1) / 2;
                    cnt0 = 0;
                }
            }
            return cnt >= n;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}