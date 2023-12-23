package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 1466 Reorder Routes to Make All Paths Lead to the City Zero
public class LC1466ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1466);
        Solution solution = new LC1466ReorderRoutesToMakeAllPathsLeadToTheCityZero().new Solution();

    }
    // dfs
    // bfs

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minReorder(int n, int[][] connections) {
            // 建图
            List<int[]>[] g = new ArrayList[n];
            Arrays.setAll(g, value -> new ArrayList<>());
            for (int[] con : connections) {
                int from = con[0], to = con[1];
                // 当作无向图。[0]记录边连接的点。[1]记录边的方向，其中1表示原方向，0表示反方向
                g[from].add(new int[]{to, 1});
                g[to].add(new int[]{from, 0});
            }
            int ans = 0;
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{0, -1}); // 加入起点0的父亲是-1，防止循环
            while (!q.isEmpty()) {
                int[] tmp = q.poll();
                int cur = tmp[0], father = tmp[1];
                for (int[] to : g[cur]) {
                    int son = to[0], dir = to[1];
                    if (son == father) { // 防止循环
                        continue;
                    }
                    if (dir == 1) {
                        ans++;
                    }
                    q.offer(new int[]{son, cur}); // father->cur->son
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}