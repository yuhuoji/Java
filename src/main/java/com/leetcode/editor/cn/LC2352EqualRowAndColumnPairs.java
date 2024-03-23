package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 2352 Equal Row and Column Pairs
public class LC2352EqualRowAndColumnPairs {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2352);
        Solution solution = new LC2352EqualRowAndColumnPairs().new Solution();
        String s = "[[3,2,1],[1,7,6],[2,7,7]]";
        System.out.println(solution.equalPairs(LeetCodeHelper.stringTo2DIntArray(s)));
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(arr));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int equalPairs(int[][] grid) {
            int n = grid.length;

            int[][] transGrid = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    transGrid[j][i] = grid[i][j];
                }
            }

            Map<String, Integer> rowMap = new HashMap<>();
            for (int[] row : grid) {
                rowMap.put(Arrays.toString(row), rowMap.getOrDefault(Arrays.toString(row), 0) + 1);
            }

            int ans = 0;
            for (int[] col : transGrid) {
                ans += rowMap.getOrDefault(Arrays.toString(col), 0);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}