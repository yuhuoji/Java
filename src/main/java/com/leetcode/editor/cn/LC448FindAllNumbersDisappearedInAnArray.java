package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 448 找到所有数组中消失的数字
public class LC448FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "448");
        Solution solution = new LC448FindAllNumbersDisappearedInAnArray().new Solution();
        //${question.code.testCase}
    }
    //[1..n]
    // nums[i]=i+1

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int n = nums.length;
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                while (nums[nums[i] - 1] != nums[i]) {
                    swap(nums, nums[i] - 1, i);
                }
            }
            for (int i = 0; i < n; ++i) {
                if (nums[i] != i + 1) {
                    ans.add(i + 1);
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