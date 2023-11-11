package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 31 Next Permutation
public class Leetcode31NextPermutation {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 31);
        Solution solution = new Leetcode31NextPermutation().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 下一个排列
        // 1.找到「较小的数」(i,i+1)
        // 2.找到「较大的数」
        // 3.交换，将较小的数后变为升序
        public void nextPermutation(int[] nums) {
            int n = nums.length;
            int low = n - 2;
            // 找到「较小的数」
            while (low >= 0 && nums[low] >= nums[low + 1]) {
                low--;
            }
            // 找到「较大的数」
            if (low >= 0) {
                int high = n - 1;
                while (nums[low] >= nums[high]) {
                    high--;
                }
                swap(nums, low, high);
            }
            // 将之后的数（一定为降序）变为升序
            reverse(nums, low + 1);
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        //[i+1,n)一定为降序，只需要反转就可变为升序
        private void reverse(int[] nums, int start) {
            int l = start, r = nums.length - 1;
            while (l < r) {
                swap(nums, l++, r--);
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}