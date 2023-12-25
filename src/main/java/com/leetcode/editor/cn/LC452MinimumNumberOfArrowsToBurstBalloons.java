package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;
import java.util.Comparator;

// 452 Minimum Number of Arrows to Burst Balloons
public class LC452MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 452);
        Solution solution = new LC452MinimumNumberOfArrowsToBurstBalloons().new Solution();

    }

    // 区间集合 452 435
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinArrowShots(int[][] points) {
            Arrays.sort(points, Comparator.comparingInt(point -> point[1])); // 按右边界排序
            int n = points.length;
            int ans = 1; // 统计交叉区间 开始就需要一支箭
            int end = points[0][1]; // 当前的end
            for (int i = 1; i < n; ++i) {
                if (end < points[i][0]) { // 不重叠 需要下一支箭
                    ans++;
                    end = points[i][1];
                }
            }
            return ans;
        }

        public int findMinArrowShots1(int[][] points) {
            Arrays.sort(points, Comparator.comparingInt(point -> point[0])); // 按左边界排序
            int n = points.length;
            int ans = 1; // 统计交叉区间 开始就需要一支箭
            int end = points[0][1]; // 当前的end
            for (int i = 1; i < n; ++i) {
                if (points[i][0] <= end) { // 重叠 只用一支箭
                    end = Math.min(end, points[i][1]);
                } else { // 不重叠 需要下一支箭
                    ans++;
                    end = points[i][1];
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}