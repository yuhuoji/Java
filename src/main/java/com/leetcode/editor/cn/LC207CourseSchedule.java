package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 207 Course Schedule
public class LC207CourseSchedule {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 207);
        Solution solution = new LC207CourseSchedule().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //REVIEW @date 2023-11-20
        // 有向无环图 拓扑排序
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<Integer>[] g = new ArrayList[numCourses]; // 邻接表
            int[] inDegree = new int[numCourses]; // 入度
            Arrays.setAll(g, value -> new ArrayList<>());
            for (var p : prerequisites) {
                int x = p[0], y = p[1];
                g[y].add(x); // 学x需要先学y, y -> x
                inDegree[x]++; // 计算入度
            }

            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < numCourses; i++) { // 加入初始入度为0的点
                if (inDegree[i] == 0) {
                    q.offer(i);
                }
            }

            int cnt = 0;
            while (!q.isEmpty()) {
                int x = q.poll(); // x的入度为0
                cnt++; // 学的课程数量+1
                for (int y : g[x]) { // 遍历邻居，入度-1，看是否有入度为0的点
                    if (--inDegree[y] == 0) {
                        q.offer(y);
                    }
                }
            }
            return cnt == numCourses;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}