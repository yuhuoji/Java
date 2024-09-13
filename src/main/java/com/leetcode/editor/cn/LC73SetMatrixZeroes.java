package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 73 矩阵置零
public class LC73SetMatrixZeroes {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "73");
        Solution solution = new LC73SetMatrixZeroes().new Solution();

    }


    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            boolean row0 = false, col0 = false;
            for (int i = 0; i < m; ++i) {
                if (matrix[i][0] == 0) {
                    row0 = true;
                    break;
                }
            }
            for (int j = 0; j < n; ++j) {
                if (matrix[0][j] == 0) {
                    col0 = true;
                    break;
                }
            }
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
            System.out.println(row0 + " " + col0);
            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
            if (row0) {
                for (int i = 0; i < m; ++i) {
                    matrix[i][0] = 0;
                }
            }
            if (col0) {
                Arrays.fill(matrix[0], 0);
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}