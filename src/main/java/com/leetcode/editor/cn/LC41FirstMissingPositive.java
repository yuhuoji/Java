package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 41 缺失的第一个正数
public class LC41FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 41);
        Solution solution = new LC41FirstMissingPositive().new Solution();

    }
    // REVIEW @date 2024-08-12

    // 10^5 可能有相同数字
    // 要求空间O(1)
    // [0..n-1]放1..n
    // nums[i]应该放到nums[i]-1位置上，如nums[i]=3应该放到2位置
    // 答案是第一个nums[i]!=i+1的数

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; ++i) {
                while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                    swap(nums, nums[i] - 1, i);
                }
            }
            for (int i = 0; i < n; ++i) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }
            return n + 1; // 没有答案
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}