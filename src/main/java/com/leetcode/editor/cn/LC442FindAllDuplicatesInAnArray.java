package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 442 数组中重复的数据
public class LC442FindAllDuplicatesInAnArray {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "442");
        Solution solution = new LC442FindAllDuplicatesInAnArray().new Solution();

    }


    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; ++i) {
                while (nums[nums[i] - 1] != nums[i]) {
                    swap(nums, nums[i] - 1, i);
                }
            }
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                if (nums[i] - 1 != i) {
                    ans.add(nums[i]);
                }
            }
            return ans;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}