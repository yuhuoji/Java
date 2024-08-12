package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 189 轮转数组
public class LC189RotateArray {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 189);
        Solution solution = new LC189RotateArray().new Solution();

    }

    // 3步 全部翻转 反转前k 反转后n-k
    // k可能大于n
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k %= n;
            rotate(nums, 0, n - 1);
            rotate(nums, 0, k - 1);
            rotate(nums, k, n - 1);
        }

        public void rotate(int[] nums, int left, int right) {
            for (; left < right; left++, right--) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}