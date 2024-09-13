package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 912 排序数组
public class LC912SortAnArray {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 912);
        Solution solution = new LC912SortAnArray().new Solution();

    }

    // REVIEW @date 2024-07-23 排序
    // 快排
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void quickSort(int[] nums, int left, int right) {
            if (left < right) {
                int i = randomPartition(nums, left, right);
                quickSort(nums, left, i - 1);
                quickSort(nums, i + 1, right);
            }
        }

        private int randomPartition(int[] nums, int left, int right) {
            int i = new Random().nextInt(right - left + 1) + left;
            swap(nums, i, right);
            return partition(nums, left, right);
        }

        private int partition(int[] nums, int left, int right) {
            int pivot = nums[right];
            int i = left - 1;
            for (int j = left; j < right; ++j) { // 快慢指针划分 [l,i] [i+1,j-1] [r]
                if (nums[j] <= pivot) {
                    i++;
                    swap(nums, i, j);
                }
            }
            swap(nums, i + 1, right);
            return i + 1;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}