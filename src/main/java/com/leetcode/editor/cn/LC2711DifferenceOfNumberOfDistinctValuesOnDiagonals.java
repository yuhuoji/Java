package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 2711 对角线上不同值的数量差
public class LC2711DifferenceOfNumberOfDistinctValuesOnDiagonals {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "2711");
        Solution solution = new LC2711DifferenceOfNumberOfDistinctValuesOnDiagonals().new Solution();

    }
    // 对角线遍历
    // todo 前后缀分解

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // O(50^3)
        public int[][] differenceOfDistinctValues(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] ans = new int[m][n];
            // 从右上向左下计算
            for (int k = 1; k < m + n; ++k) {
                int minJ = Math.max(n - k, 0);
                int maxJ = Math.min(m + n - k - 1, n - 1);
                for (int j = minJ; j <= maxJ; ++j) { // 计算(k+j-n,j)的答案
                    Set<Integer> s1 = new HashSet<>();
                    Set<Integer> s2 = new HashSet<>();
                    // 左上
                    for (int c = minJ; c < j; ++c) {
                        s1.add(grid[k + c - n][c]);
                    }
                    int topLeft = s1.size();
                    // 右下
                    for (int c = j + 1; c <= maxJ; ++c) {
                        s2.add(grid[k + c - n][c]);
                    }
                    int bottomRight = s2.size();
                    // 计算答案
                    ans[k + j - n][j] = Math.abs(topLeft - bottomRight);
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}