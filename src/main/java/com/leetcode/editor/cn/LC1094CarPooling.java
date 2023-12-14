package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;
import java.util.Comparator;

// 1094 Car Pooling
public class LC1094CarPooling {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1094);
        Solution solution = new LC1094CarPooling().new Solution();

    }

    // 差分数组
    // 把[from,to]的每一位加上一个数

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int N = 1001; // 保证from to不越界

        public boolean carPooling(int[][] trips, int capacity) {
            Arrays.sort(trips, Comparator.comparingInt(v -> v[0])); //按照第一个排序
            int[] diff = new int[N];
            for (int[] trip : trips) {
                int num = trip[0], from = trip[1], to = trip[2];
                diff[from] += num;
                diff[to] -= num;
            }
            int cap = 0; // 由差分数组恢复出的原数组
            for (int x : diff) {
                cap += x;
                if (cap > capacity) {
                    return false;
                }
            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}