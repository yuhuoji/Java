package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;

// 2542 最大子序列的分数
public class LC2542MaximumSubsequenceScore {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2542);
        Solution solution = new LC2542MaximumSubsequenceScore().new Solution();

    }

    // REVIEW @date 2024-07-03
    // 对nums2降序排序，遍历，如果nums1的和变大则可能更新答案
    // 对下标数组indices排序，通过nums[indices[i]]访问
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxScore(int[] nums1, int[] nums2, int k) {
            int n = nums1.length;
            Integer[] indices = new Integer[n];
            for (int i = 0; i < n; ++i) {
                indices[i] = i;
            }
            Arrays.sort(indices, (i, j) -> nums2[j] - nums2[i]); // 对下标排序
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            long sum = 0;
            for (int i = 0; i < k; ++i) {
                sum += nums1[indices[i]];
                heap.offer(nums1[indices[i]]);
            }
            long ans = sum * nums2[indices[k - 1]]; // 降序排序，nums2[i]是最小的
            for (int i = k; i < n; ++i) {
                int x = nums1[indices[i]];
                if (x > heap.peek()) {
                    sum += x - heap.poll();
                    heap.offer(x);
                    ans = Math.max(ans, sum * nums2[indices[i]]);
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}