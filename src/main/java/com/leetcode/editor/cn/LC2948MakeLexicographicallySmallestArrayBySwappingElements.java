package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;
import java.util.Comparator;

// 2948 Make Lexicographically Smallest Array by Swapping Elements
public class LC2948MakeLexicographicallySmallestArrayBySwappingElements {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2948);
        Solution solution = new LC2948MakeLexicographicallySmallestArrayBySwappingElements().new Solution();
        String s = "[1,7,6,18,2,1]";
        int[] nums = LeetCodeHelper.stringToIntegerArray(s);
        System.out.println(Arrays.toString(nums));
    }

    // REVIEW @date 2023-12-02
    // LC 1202
    // 没思路
    // 周赛373 Q3 2948. 交换得到字典序最小的数组
    // 带着下标排序
    // 连通的(并查集)组内可以随意交换，字典序最小
    // ！分组循环
    // 时间 循环O(N) 排序O(N*logN)
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] lexicographicallySmallestArray(int[] nums, int limit) {
            int n = nums.length;
            // !带下标排序
            Integer[] indices = new Integer[n]; // num有序
            for (int i = 0; i < n; ++i) {
                indices[i] = i;
            }
            Arrays.sort(indices, (i, j) -> nums[i] - nums[j]);
            int[] ans = new int[n];
            // !分组循环
            // 外层 准备工作+更新答案
            // 内层 找最长连续段的结尾位置
            for (int i = 0; i < n; ) {
                int start = i;
                i++;
                while (i < n && nums[indices[i]] - nums[indices[i - 1]] <= limit) {
                    i++;
                }
                // indices[start,i-1]
                // !提取下标，排序
                Integer[] subIndices = Arrays.copyOfRange(indices, start, i);
                Arrays.sort(subIndices);
                for (int j = 0; j < subIndices.length; ++j) {
                    ans[subIndices[j]] = nums[indices[start + j]];
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}