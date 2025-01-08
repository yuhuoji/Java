package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;
import java.util.stream.Collectors;

// 4 寻找两个正序数组的中位数
public class LC4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "4");
        Solution solution = new LC4MedianOfTwoSortedArrays().new Solution();

    }


    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
            // List<Integer> list2 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
            // for (int i = 0, j = 0; i < list1.size() && j < list2.size(); ++i) {
            //     if (list1.get(i) > list2.get(j)) {
            //         list1.
            //     }
            // }
            int m = nums1.length, n = nums2.length;
            double ans = 0;
            if ((m + n) % 2 == 1) { // 奇数 取中间的一个数做中位数
                int idx = (m + n + 1) / 2;
                int p1 = 0, p2 = 0;
                while (p1 < nums1.length && p2 < nums2.length) {
                    if (p1)
                }
            } else { // 偶数 取中间两个数做中位数
                int idx = (m + n) / 2;

            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}