package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 74 搜索二维矩阵
public class LC74SearchA2dMatrix {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "74");
        Solution solution = new LC74SearchA2dMatrix().new Solution();

    }


    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;
            int low = 0, high = m * n - 1;
            while (low <= high) {
                int mid = ((high - low) >> 1) + low;
                // mid/n mid%n
                if (matrix[mid / n][mid % n] < target) {
                    low = mid + 1;
                } else if (matrix[mid / n][mid % n] > target) {
                    high = mid - 1;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}