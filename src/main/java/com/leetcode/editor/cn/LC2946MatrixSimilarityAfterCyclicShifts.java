package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 2946 Matrix Similarity After Cyclic Shifts
public class LC2946MatrixSimilarityAfterCyclicShifts {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2946);
        Solution solution = new LC2946MatrixSimilarityAfterCyclicShifts().new Solution();
        String s = "[[2,2],[2,2]]";
        int k = 3;
        System.out.println(solution.areSimilar(LeetCodeHelper.stringTo2DIntArray(s), k));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // k会大于n
        // O(M*N)
        // 右移k和左移k结果相同
        public boolean areSimilar(int[][] mat, int k) {
            int m = mat.length;
            int n = mat[0].length;
            k %= n; // k会大于n
            if (k == 0) {
                return true;
            }
            for (int[] r : mat) {
                for (int j = 0; j < n; ++j) {
                    if (r[j] != r[(j + k) % n]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}