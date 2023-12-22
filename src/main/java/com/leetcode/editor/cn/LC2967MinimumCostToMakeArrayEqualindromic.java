package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 2967 Minimum Cost to Make Array Equalindromic
public class LC2967MinimumCostToMakeArrayEqualindromic {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2967);
        Solution solution = new LC2967MinimumCostToMakeArrayEqualindromic().new Solution();
        String s = "[10,12,13,14,15]";
        System.out.println(solution.minimumCost(LeetCodeHelper.stringToIntegerArray(s)));
    }

    // REVIEW @date 2023-12-22 中位数贪心 回文数
    // 中位数贪心
    // 枚举10^9回文数 模板，通过枚举回文数的左半部分（枚举中位数左右两边的回文数也能过 ）
    // 取中位数到所有数的距离之和是最小的
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static int[] palindromic = new int[109_999]; // 10^9 大约有10^5个

        static { // 模板 从小到大生成所有回文数
            int palIdx = 0;
            for (int base = 1; base <= 10000; base *= 10) { // 枚举回文数的长度 1 10 100..
                // 生成奇数长度回文数 先去掉最后一位，逆序加在后面
                for (int i = base; i < base * 10; ++i) { // 100..999
                    int x = i; // 生成的回文数
                    for (int t = i / 10; t > 0; t /= 10) { // 先去掉最后一位
                        x = x * 10 + t % 10; // 加上t的最后一位
                    }
                    palindromic[palIdx++] = x;
                }
                // 生成偶数长度回文数 反转加在后面
                if (base <= 1000) {
                    for (int i = base; i < base * 10; ++i) {
                        int x = i;
                        for (int t = i; t > 0; t /= 10) {
                            x = x * 10 + t % 10;
                        }
                        palindromic[palIdx++] = x;
                    }
                }
            }
            palindromic[palIdx++] = 1_000_000_001; // 哨兵，防止二分返回下标i越界
        }

        public long minimumCost(int[] nums) {
            Arrays.sort(nums); // 排序找到中位数
            int n = nums.length;
            int i = lowerBound(nums[(n - 1) / 2]); // 二分找到回文数下标
            // 中位数[(n-1)/2, n/2]
            if (palindromic[i] <= nums[n / 2]) {
                return cost(nums, palindromic[i]);
            }
            // 中位数左边最近 右边最近 取最小
            return Math.min(cost(nums, palindromic[i - 1]), cost(nums, palindromic[i]));
        }

        // 计算nums都变成target的代价
        private long cost(int[] nums, int target) {
            long sum = 0;
            for (int x : nums) {
                sum += Math.abs(x - target);
            }
            return sum;
        }

        // 二分 返回大于等于的第一个下标
        private int lowerBound(int target) {
            int l = 0, r = palindromic.length;
            // [l,r)
            // 循环不变量 pal[l]<t pal[r]>=t
            while (l < r) {
                int m = ((r - l) >> 1) + l;
                if (palindromic[m] < target) {
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