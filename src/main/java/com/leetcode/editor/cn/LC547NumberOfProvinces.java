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
    // REVIEW @date 2024-07-02 并查集
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] parent;
        int[] size; // 代表节点每个集合的大小
        int[] stack; // 用于路径压缩

        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            parent = new int[n];
            size = new int[n];
            stack = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                size[i] = 1;
            }
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    if (isConnected[i][j] == 1) {
                        union(i, j);
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                if (parent[i] == i) { // 有几个代表节点
                    ans++;
                }
            }
            return ans;
        }

        private int find(int i) {
            int size = 0;
            while (parent[i] != i) {
                stack[size] = i;
                size++;
                i = parent[i];
            }
            while (size > 0) { // 路径压缩
                size--;
                parent[stack[size]] = i;
            }
            return i;
        }

        private boolean isSameSet(int i, int j) {
            return find(i) == find(j);
        }

        private void union(int i, int j) {
            int pi = find(i);
            int pj = find(j);
            if (pi != pj) {
                if (size[pi] >= size[pj]) {
                    parent[pj] = pi;
                    size[pi] += size[pj];
                } else {
                    parent[pi] = pj;
                    size[pj] += size[pi];
                }
            }
        }
    }

    class Solution2 {

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
                while (!q.isEmpty()) { // bfs
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