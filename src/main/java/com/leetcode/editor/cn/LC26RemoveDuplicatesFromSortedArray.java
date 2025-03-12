package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 26 删除有序数组中的重复项
public class LC26RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "26");
        Solution solution = new LC26RemoveDuplicatesFromSortedArray().new Solution();

    }
    // lc283

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            int n = nums.length;
            int cnt = 1; // 不同元素的个数
            for (int i = 1; i < n; ++i) {
                if (nums[i] != nums[i - 1]) {
                    nums[cnt++] = nums[i];
                }
            }
            return cnt;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}