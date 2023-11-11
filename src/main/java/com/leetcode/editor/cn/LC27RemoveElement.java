package com.leetcode.editor.cn;

import java.util.Arrays;

// 27 Remove Element
public class LC27RemoveElement {
    // REVIEW @date 2023-11-07
    public static void main(String[] args) {
        System.out.println("Leetcode " + 27);
        Solution solution = new LC27RemoveElement().new Solution();
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int res = solution.removeElement(nums, val);
        System.out.println(res);
        System.out.println(Arrays.toString(nums));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 双指针
        public int removeElement(int[] nums, int val) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            }
            int l = 0, r = n - 1; // n一定不等于val
            while (l <= r) {
                //[l-1]不等于[r+1]一定不等于
                if (nums[l] == val) {// 交换l和r
                    nums[l] = nums[r];
                    r--;
                } else {
                    l++;
                }
            }
            return l;
        }

        // 不等于val, s, 等于val, f, 没搜索的
        public int removeElement1(int[] nums, int val) {
            int n = nums.length;
            int s = 0, f = 0;
            for (; f < n; ++f) {
                if (nums[f] != val) {
                    nums[s] = nums[f];
                    s++;
                }
            }
            return s;
        }


    }
// leetcode submit region end(Prohibit modification and deletion)

}