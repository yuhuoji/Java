package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;
import java.util.Comparator;

// 435 Non-overlapping Intervals
public class LC435NonOverlappingIntervals {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 435);
        Solution solution = new LC435NonOverlappingIntervals().new Solution();
        String s = "[[1,3],[2,3],[3,4],[1,2]]";
        int[][] intervals = LeetCodeHelper.stringTo2DIntArray(s);
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        System.out.println(Arrays.deepToString(intervals)); // 打印多维数组
        // System.out.println(solution.eraseOverlapIntervals(LeetCodeHelper.stringTo2DIntArray(intervals)));
    }

    // REVIEW @date 2023-12-25
    // 区间集合 452 435
    // 两种 左端升序和右端升序
    // 左端升序会有前面包括后面的情况 右端升序则不会，省略了维护右端最小值

    // 1. 贪心 结尾尽量短
    // 2. dp
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // n = 保留的 + 去掉的
        // 贪心 结尾尽量短
        // 总数量-不交叉的区间数量
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1])); // 按右端点排序
            int n = intervals.length;
            int cnt = 1; // 统计不交叉的区间的数量
            int end = intervals[0][1]; // 当前的end最小值
            for (int i = 1; i < n; ++i) {
                if (end <= intervals[i][0]) { // 不重叠
                    cnt++;
                    end = intervals[i][1];
                }
            }
            return n - cnt;
        }

        // 统计交叉区间
        public int eraseOverlapIntervals1(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0])); // 按左端点排序 会有前面包括后面的情况
            int n = intervals.length;
            int ans = 0; // 统计交叉区间
            int end = intervals[0][1]; // 当前的end
            for (int i = 1; i < n; ++i) {
                if (intervals[i][0] < end) { // 重叠
                    ans++;
                    end = Math.min(end, intervals[i][1]);
                } else { // 不重叠
                    end = intervals[i][1];
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}