package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 48 旋转图像
public class LC48RotateImage {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "48");
        Solution solution = new LC48RotateImage().new Solution();

    }
    // 右旋

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            int a = 0, b = n - 1;
            while (a < b) {
                rotate(matrix, a++, b--);
            }
        }

        //(a,a)(b,b)
        public void rotate(int[][] matrix, int a, int b) {
            for (int i = 0; i < b - a; ++i) {
                int tmp = matrix[a][a + i];
                matrix[a][a + i] = matrix[b - i][a];
                matrix[b - i][a] = matrix[b][b - i];
                matrix[b][b - i] = matrix[a + i][b];
                matrix[a + i][b] = tmp;
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}