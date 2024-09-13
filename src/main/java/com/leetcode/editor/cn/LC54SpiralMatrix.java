package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 54 Spiral Matrix
public class LC54SpiralMatrix {
    public static void main(String[] args) {
        System.out.println("LC " + 54);
        Solution solution = new LC54SpiralMatrix().new Solution();

    }
    // REVIEW @date 2024-08-14
    // 设置边界 顺序 上 右 下 左

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int u = 0, d = m - 1, l = 0, r = n - 1;
            List<Integer> ans = new ArrayList<>(m * n);
            while (true) {
                for (int j = l; j <= r; ++j) {
                    ans.add(matrix[u][j]);
                }
                if (++u > d) {
                    break;
                }
                for (int i = u; i <= d; ++i) {
                    ans.add(matrix[i][r]);
                }
                if (--r < l) {
                    break;
                }
                for (int j = r; j >= l; --j) {
                    ans.add(matrix[d][j]);
                }
                if (--d < u) {
                    break;
                }
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