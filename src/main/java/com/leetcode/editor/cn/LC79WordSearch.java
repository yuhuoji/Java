package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 79 Word Search
public class LC79WordSearch {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 79);
        Solution solution = new LC79WordSearch().new Solution();
        String s = "[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]";
        String word = "ABCB";
        char[][] board = LeetCodeHelper.stringTo2DCharArray(s);
        // 遍历board
        for (var b : board) {
            for (char c : b) {
                System.out.print(c + ", ");
            }
            System.out.println();
        }
        System.out.println(solution.exist(board, word));
    }

    // 回溯
    // 剪枝?
    // 时间最差O(M*N*单词长度)
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        private boolean[][] visited;

        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;
            visited = new boolean[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) { // 从每个位置开始搜索
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, String word, int i, int j, int sIdx) {
            // base case
            if (board[i][j] != word.charAt(sIdx)) {
                return false;
            }
            // 当前位置相同
            if (sIdx == word.length() - 1) { // 搜索到最后一位了
                return true;
            }
            visited[i][j] = true; // 标记
            for (var dir : DIRECTIONS) { // 向四个方向搜索匹配下个位置
                int x = i + dir[0], y = j + dir[1]; // 下一个位置(x,y)
                if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) { // 越界
                    continue;
                }
                if (visited[x][y]) { // 不走回头路
                    continue;
                }
                if (dfs(board, word, x, y, sIdx + 1)) {
                    return true;
                }
            }
            visited[i][j] = false; // 恢复现场
            return false;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}