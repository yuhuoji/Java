package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.ArrayList;
import java.util.List;

// 54 Spiral Matrix
public class LC54SpiralMatrix {
    public static void main(String[] args) {
        System.out.println("LC " + 54);
        Solution solution = new LC54SpiralMatrix().new Solution();
        //[[1,2,3],[4,5,6],[7,8,9]]
        // 			[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> ans = solution.spiralOrder(matrix);
        System.out.println(ans);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            List<Integer> ans = new ArrayList<>(m * n); //
            int u = 0, d = m - 1, l = 0, r = n - 1;
            while (true) {
                // 上
                for (int j = l; j <= r; ++j) {
                    ans.add(matrix[u][j]);
                }
                if (++u > d) {
                    break;
                }
                // 右
                for (int i = u; i <= d; ++i) {
                    ans.add(matrix[i][r]);
                }
                if (--r < l) {
                    break;
                }
                // 下
                for (int j = r; j >= l; --j) {
                    ans.add(matrix[d][j]);
                }
                if (--d < u) {
                    break;
                }
                // 左
                for (int i = d; i >= u; --i) {
                    ans.add(matrix[i][l]);
                }
                if (++l > r) {
                    break;
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}