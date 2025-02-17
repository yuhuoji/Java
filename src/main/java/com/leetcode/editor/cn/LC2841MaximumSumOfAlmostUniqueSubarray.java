package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 2841 几乎唯一子数组的最大和
public class LC2841MaximumSumOfAlmostUniqueSubarray {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "2841");
        Solution solution = new LC2841MaximumSumOfAlmostUniqueSubarray().new Solution();
        List<Integer> nums = Arrays.asList(1, 2, 2);
        int m = 2;
        int k = 2;
        System.out.println(solution.maxSum(nums, m, k));
    }
    // 注意元素范围，越界

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxSum(List<Integer> nums, int m, int k) {
            int n = nums.size();
            long mx = 0; // 最大和
            long sum = 0; // 滑动窗口内元素的和
            Map<Integer, Integer> mp = new HashMap<>();
            for (int i = 0; i < n; ++i) {
                int x = nums.get(i);
                sum += x;
                // mp.put(x, mp.getOrDefault(x, 0) + 1);
                mp.merge(x, 1, Integer::sum);
                if (i < k - 1) {
                    continue;
                }
                if (mp.size() >= m) {
                    mx = Math.max(mx, sum);
                }
                // 窗口最左边元素离开窗口
                int out = nums.get(i - k + 1);
                sum -= out;
                if (mp.merge(out, -1, Integer::sum) == 0) {
                    mp.remove(out);
                }
            }
            return mx;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}