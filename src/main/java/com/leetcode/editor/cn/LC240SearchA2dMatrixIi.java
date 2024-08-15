package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 240 搜索二维矩阵 II
public class LC240SearchA2dMatrixIi {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "240");
        Solution solution = new LC240SearchA2dMatrixIi().new Solution();

    }
    // REVIEW @date 2024-08-15 排除法

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 事件O(M+N)
        // 左下角
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;
            int i = m - 1, j = 0;
            while (i >= 0 && j < n) {
                if (matrix[i][j] == target) {
                    return true;
                }
                if (matrix[i][j] < target) {
                    j++; // 列剩余元素都小于target
                } else {
                    i--; // 行剩余元素都大于target
                }
            }
            return false;
        }

        // 右上角开始，排除一行或者一列
        public boolean searchMatrix2(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;
            int i = 0, j = n - 1;
            while (i < m && j >= 0) {
                if (matrix[i][j] == target) {
                    return true;
                }
                if (matrix[i][j] < target) {
                    i++; // 行剩余元素都小于target，排除
                } else {
                    j--; // 列剩余元素都大于target，排除
                }
            }
            return false;
        }

        // 二分 时间O(M*logN)
        public boolean searchMatrix1(int[][] matrix, int target) {
            int n = matrix[0].length;
            for (int[] row : matrix) {
                int idx = Arrays.binarySearch(row, target);
                if (idx >= 0 && idx < n && row[idx] == target) {
                    return true;
                }
            }
            return false;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}