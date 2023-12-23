package com.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;

// 1926 Nearest Exit from Entrance in Maze
public class LC1926NearestExitFromEntranceInMaze {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1926);
        Solution solution = new LC1926NearestExitFromEntranceInMaze().new Solution();

    }

    // 回溯 dfs 复杂度高
    // bfs 模板
    //！入口不能作为出口
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int[][] DIRECTION = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int nearestExit(char[][] maze, int[] entrance) {
            int m = maze.length;
            int n = maze[0].length;
            int[][] visited = new int[m][n];
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{entrance[0], entrance[1], 0}); //(x,y) step
            visited[entrance[0]][entrance[1]] = 1;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                for (int[] dir : DIRECTION) {
                    int x = cur[0] + dir[0], y = cur[1] + dir[1], step = cur[2];
                    if (x < 0 || x >= m || y < 0 || y >= n) { // 越界
                        continue;
                    }
                    if (maze[x][y] == '+') { // 墙壁
                        continue;
                    } else if (visited[x][y] == 1) { // 已经走过
                        continue;
                    }
                    if (x == 0 || x == m - 1 || y == 0 || y == n - 1) {
                        return step + 1; // 下一步就到边界
                    }
                    visited[x][y] = 1;
                    q.offer(new int[]{x, y, step + 1}); // 加入队列
                }
            }
            return -1; // 没有解
        }

    }
// leetcode submit region end(Prohibit modification and deletion)

}