package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 2602 Minimum Operations to Make All Array Elements Equal
public class LC2602MinimumOperationsToMakeAllArrayElementsEqual {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2602);
        Solution solution = new LC2602MinimumOperationsToMakeAllArrayElementsEqual().new Solution();

        int[] nums = {2, 9, 6, 3};
        int[] queries = {10};
        Arrays.sort(nums);
        System.out.println("lowerBound " + solution.lowerBound(nums, 10));
        System.out.println(solution.minOperations(nums, queries));
    }

    // REVIEW @date 2024-03-26
    // 模板 数组所有元素到q的距离和
    // 排序后，二分找大于等于q的第一个数
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Long> minOperations(int[] nums, int[] queries) {
            Arrays.sort(nums);
            int n = nums.length;
            long[] sum = new long[n + 1]; // sum[i+1] = 0..i的前缀和
            for (int i = 0; i < n; ++i) {
                sum[i + 1] = sum[i] + nums[i];
            }
            List<Long> ans = new ArrayList<>(queries.length);
            for (int q : queries) {
                int j = lowerBound(nums, q); // 二分找大于等于q的第一个数的下标
                long left = (long) j * q - sum[j]; // 小于q部分的面积
                long right = sum[n] - sum[j] - (long) (n - j) * q;
                ans.add(left + right);
            }
            return ans;
        }

        // 二分查找 [)
        public int lowerBound(int[] nums, int target) {
            int n = nums.length;
            int l = 0, r = n;
            while (l < r) {
                int m = ((r - l) >> 1) + l;
                // nums[l-1]<t
                // nums[r]>=t
                if (nums[m] < target) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            return r;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}