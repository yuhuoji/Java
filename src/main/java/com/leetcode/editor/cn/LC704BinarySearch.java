package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 704 Binary Search
public class LC704BinarySearch {
    public static void main(String[] args) {
        System.out.println("LC " + 704);
        Solution solution = new LC704BinarySearch().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 找到第一个>=t的
        public int search(int[] nums, int target) {
            int n = nums.length;
            int l = 0, r = n; //[0,n) [l,r)
            while (l < r) {
                // 循环不变量：
                // nums[left-1] < target
                // nums[right] >= target
                int m = ((r - l) >> 1) + l;
                if (target <= nums[m]) {
                    r = m; //[l,m)
                } else {
                    l = m + 1; //[m,r)
                }
            }
            // l==r
            return l < n && nums[l] == target ? l : -1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}