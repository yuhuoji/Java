package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 841 钥匙和房间
public class LC841KeysAndRooms {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 841);
        Solution solution = new LC841KeysAndRooms().new Solution();

    }
    // TODO @date 2024-06-28

    // dfs or bfs
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // dfs
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        }

        private void dfs() {

        }
    }

    class Solution1 {
        // bfs
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            int n = rooms.size();
            int num = 0; // 统计去过的房间
            boolean[] visited = new boolean[n]; // 标记是否访问过，防止重复访问
            Queue<Integer> q = new ArrayDeque<>();
            visited[0] = true;
            q.offer(0);
            while (!q.isEmpty()) {
                int x = q.poll();
                num++;
                for (int i : rooms.get(x)) {
                    if (!visited[i]) {
                        visited[i] = true;
                        q.offer(i);
                    }
                }
            }
            return num == n;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
