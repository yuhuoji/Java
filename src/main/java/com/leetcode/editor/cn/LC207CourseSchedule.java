package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 207 Course Schedule
public class LC207CourseSchedule {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 207);
        Solution solution = new LC207CourseSchedule().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //[0,numCourses-1]
        // 有向无环图 拓扑排序
        //TODO @date 2023-11-19
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<Integer>[] g = new ArrayList[numCourses];
            Arrays.setAll(g, value -> new ArrayList<>());
            for (var p : prerequisites) {
                int x = p[0], y = p[1];
                g[y].add(x); // y -> x
            }


            return false;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}