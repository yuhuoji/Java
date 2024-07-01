package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.ArrayDeque;
import java.util.Queue;

// 547 省份数量
public class LC547NumberOfProvinces {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 547);
        Solution solution = new LC547NumberOfProvinces().new Solution();

    }

    // 图搜索 or 并查集
    // LC200 岛屿数量
    // TODO @date 2024-07-01 并查集
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            int num = 0;
            boolean[] visited = new boolean[n];
            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < n; ++i) {
                if (visited[i]) {
                    continue;
                }
                q.offer(i);
                num++;
                while (!q.isEmpty()) { //bfs
                    int x = q.poll();
                    visited[x] = true;
                    for (int j = 0; j < n; ++j) {
                        if (isConnected[x][j] == 1 && !visited[j]) {
                            q.offer(j);
                        }
                    }
                }
            }
            return num;
        }
    }

    class Solution1 {

        int[][] isConnected;
        boolean[] visited;
        int n;

        public int findCircleNum(int[][] isConnected) {
            n = isConnected.length;
            int num = 0;
            this.isConnected = isConnected;
            visited = new boolean[n];
            for (int i = 0; i < n; ++i) {
                if (!visited[i]) {
                    dfs(i);
                    num++;
                }
            }
            return num;
        }

        private void dfs(int i) {
            if (i < 0 || i >= n) {
                return;
            }
            visited[i] = true;
            for (int j = 0; j < n; ++j) { // 方块i所连接的去i行搜
                if (isConnected[i][j] == 1 && !visited[j]) { // 相连且没有访问过
                    dfs(j);
                }
            }
        }

    }
// leetcode submit region end(Prohibit modification and deletion)

}