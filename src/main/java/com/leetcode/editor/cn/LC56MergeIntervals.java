package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 56 合并区间
public class LC56MergeIntervals {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 56);
        Solution solution = new LC56MergeIntervals().new Solution();

    }
    // REVIEW @date 2024-08-09

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            int n = intervals.length;
            List<int[]> ans = new ArrayList<>();
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); // (a, b) -> a[0] - b[0]
            for (int[] interval : intervals) {
                int m = ans.size();
                int l = interval[0], r = interval[1];
                if (m > 0 && l <= ans.get(m - 1)[1]) {
                    ans.get(m - 1)[1] = Math.max(ans.get(m - 1)[1], r);
                } else {
                    ans.add(new int[]{l, r});
                }
            }
            return ans.toArray(new int[ans.size()][]);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}