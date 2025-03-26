package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 80 删除有序数组中的重复项 II
public class LC80RemoveDuplicatesFromSortedArrayIi {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "80");
        Solution solution = new LC80RemoveDuplicatesFromSortedArrayIi().new Solution();

    }

    // REVIEW @date 2025-03-26
    // 不超过2次
    // 不超过k次
    // 分组循环

    // 栈
    // 当前数字不与栈下方的数字相同
    // 入栈

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 分组循环
        public int removeDuplicates(int[] nums) {
            int n = nums.length;
            int idx = 0;
            for (int i = 0; i < n; ) {
                int start = i;
                while (i < n && nums[i] == nums[start]) {
                    i++;
                }
                int cnt = Math.min(i - start, 2); // k
                for (int j = 0; j < cnt; ++j) {
                    nums[idx++] = nums[start];
                }
            }
            return Math.min(idx, n);
        }

        // 栈
        public int removeDuplicates1(int[] nums) {
            int n = nums.length;
            int stackSize = 2;
            for (int i = 2; i < n; ++i) {
                if (nums[i] != nums[stackSize - 2]) {
                    nums[stackSize++] = nums[i];
                }
            }
            return Math.min(stackSize, n);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}