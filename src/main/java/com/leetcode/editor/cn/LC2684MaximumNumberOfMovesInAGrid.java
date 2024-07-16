package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 2684 矩阵中移动的最大次数
public class LC2684MaximumNumberOfMovesInAGrid {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2684);
        Solution solution = new LC2684MaximumNumberOfMovesInAGrid().new Solution();
        String s = "[[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]";
        System.out.println(solution.maxMoves(LeetCodeHelper.stringTo2DIntArray(s)));
    }

    // TODO @date 2024-07-16
    // lc931
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxMoves(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] f = new int[m + 2][n];
            System.arraycopy(grid[0], 0, f[0], 1, n);
            System.out.print(Arrays.deepToString(grid));
            return 0;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}