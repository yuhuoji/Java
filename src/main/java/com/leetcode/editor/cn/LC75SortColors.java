package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 75 Sort Colors
public class LC75SortColors {
    public static void main(String[] args) {
        System.out.println("LC " + 75);
        Solution solution = new LC75SortColors().new Solution();
        int[] nums = {2, 0, 2, 1, 1, 0};
        int[] nums2 = {2, 0, 2, 3, 2, 0, 1, 1, 1, 0, 3, 2, 1, 2};
        solution.sortColors0123(nums2);
        System.out.println(Arrays.toString(nums2));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // REVIEW @date 2023-11-08
        // 刷油漆
        public void sortColors(int[] nums) {
            int n = nums.length;
            int zero = 0, one = 0;
            //[0,zero) [zero, one) [one, n)
            for (int i = 0; i < n; ++i) {
                int t = nums[i];
                nums[i] = 2;
                if (t <= 1) {
                    nums[one++] = 1;
                }
                if (t == 0) {
                    nums[zero++] = 0;
                }
            }
        }

        public void sortColors0123(int[] nums) {
            int n = nums.length;
            int zero = 0, one = 0, two = 0;
            //[0,zero) [zero, one) [one, n)
            for (int i = 0; i < n; ++i) {
                int t = nums[i];
                nums[i] = 3;
                if (t <= 2) {
                    nums[two++] = 2;
                }
                if (t <= 1) {
                    nums[one++] = 1;
                }
                if (t == 0) {
                    nums[zero++] = 0;
                }
            }
        }

        // swap
        private void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}