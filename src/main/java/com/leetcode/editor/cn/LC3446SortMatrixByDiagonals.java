package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 3446 按对角线进行矩阵排序
public class LC3446SortMatrixByDiagonals {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "3446");
        Solution solution = new LC3446SortMatrixByDiagonals().new Solution();

    }
    // REVIEW @date 2025-02-25
    // 对角线遍历

    // k=i-j+n
    // 右上角 k=1 左上角 k=m+n-1
    // i=k+j-n j=i+n-k
    // minJ>0 则是右上角，按降序排列
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] sortMatrix(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            // 计算j的最大和最小值
            for (int k = 1; k < m + n; ++k) {
                int minJ = Math.max(0, n - k);
                int maxJ = Math.min(m + n - k - 1, n - 1);
                List<Integer> list = new ArrayList<>(maxJ - minJ + 1);
                for (int j = minJ; j <= maxJ; ++j) {
                    list.add(grid[k + j - n][j]);
                }
                list.sort(minJ > 0 ? null : Comparator.reverseOrder());
                for (int j = minJ; j <= maxJ; ++j) {
                    grid[k + j - n][j] = list.get(j - minJ);
                }
            }
            return grid;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}