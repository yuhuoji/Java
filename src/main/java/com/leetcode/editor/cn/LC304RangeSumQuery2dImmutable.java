package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 304 二维区域和检索 - 矩阵不可变
public class LC304RangeSumQuery2dImmutable {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 304);
        String s = "[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]";
        int[][] matrix = LeetCodeHelper.stringTo2DIntegerArray(s);
        System.out.println(Arrays.deepToString(matrix));
        NumMatrix numMatrix = new LC304RangeSumQuery2dImmutable().new NumMatrix(matrix);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class NumMatrix {
        private int[][] sum;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            sum = new int[m + 1][n + 1];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] - sum[row1][col2 + 1] + sum[row1][col1];
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// leetcode submit region end(Prohibit modification and deletion)

}