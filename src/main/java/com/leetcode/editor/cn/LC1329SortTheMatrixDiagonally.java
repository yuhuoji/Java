package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 1329 将矩阵按对角线排序
public class LC1329SortTheMatrixDiagonally {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "1329");
        Solution solution = new LC1329SortTheMatrixDiagonally().new Solution();

    }


    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] diagonalSort(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            // 计算j的最大和最小值
            for (int k = 1; k < m + n; ++k) {
                int minJ = Math.max(0, n - k);
                int maxJ = Math.min(m + n - k - 1, n - 1);
                List<Integer> list = new ArrayList<>(maxJ - minJ + 1);
                for (int j = minJ; j <= maxJ; ++j) {
                    list.add(mat[k + j - n][j]);
                }
                list.sort((a, b) -> a - b);
                for (int j = minJ; j <= maxJ; ++j) {
                    mat[k + j - n][j] = list.get(j - minJ);
                }
            }
            return mat;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}