package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;
import java.util.stream.Collectors;

// 4 寻找两个正序数组的中位数
public class LC4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "4");
        Solution solution = new LC4MedianOfTwoSortedArrays().new Solution();

        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2)); // 2.0

    }
    // REVIEW @date 2025-01-08 二分

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 归并 奇数，选(m+n+1)/2 -1
        // 偶数，选(m+n)/2 -1和(m+n)/2
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length;
            int[] nums = new int[m + n];
            int cnt = 0, i = 0, j = 0;
            while (cnt < m + n) {
                if (i == m) {
                    while (j < n) {
                        nums[cnt++] = nums2[j++];
                    }
                    break;
                }
                if (j == n) {
                    while (i < m) {
                        nums[cnt++] = nums1[i++];
                    }
                    break;
                }
                if (nums1[i] < nums2[j]) {
                    nums[cnt++] = nums1[i++];
                } else {
                    nums[cnt++] = nums2[j++];
                }
            }
            return cnt % 2 == 1 ? nums[(cnt - 1) / 2] : (nums[cnt / 2 - 1] + nums[cnt / 2]) / 2.0;
        }

        // 二分查找 找到最大的 a[i]<b[j+1]
        // 循环不变 a[left]<=b[j+1]
        // a[right]>b[j+1]
        public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                int[] tmp = nums1;
                nums1 = nums2;
                nums2 = tmp;
            }

            int m = nums1.length, n = nums2.length;
            int[] a = new int[m + 2];
            int[] b = new int[n + 2];
            a[0] = b[0] = Integer.MIN_VALUE;
            a[m + 1] = b[n + 1] = Integer.MAX_VALUE;
            System.arraycopy(nums1, 0, a, 1, m);
            System.arraycopy(nums2, 0, b, 1, n);
            int left = 0, right = m + 1;
            while (left + 1 < right) { // 二分
                int i = (left + right) / 2;
                int j = (m + n + 1) / 2 - i;
                if (a[i] <= b[j + 1]) {
                    left = i;
                } else {
                    right = i;
                }
            }
            // left+1=right
            int i = left, j = (m + n + 1) / 2 - i;
            int max1 = Math.max(a[i], b[j]);
            int min2 = Math.min(a[i + 1], b[j + 1]);
            return (m + n) % 2 == 1 ? max1 : (max1 + min2) / 2.0;
        }

        // 分为两组。m+n为奇数，两组都有(m+n)/2个数；m+n为偶数，第一组(m+n+1)/2个数
        // floor{(m+n+1)/2}
        public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                int[] tmp = nums1;
                nums1 = nums2;
                nums2 = tmp;
            }

            int m = nums1.length, n = nums2.length;
            int[] a = new int[m + 2];
            int[] b = new int[n + 2];
            a[0] = b[0] = Integer.MIN_VALUE;
            a[m + 1] = b[n + 1] = Integer.MAX_VALUE;
            System.arraycopy(nums1, 0, a, 1, m);
            System.arraycopy(nums2, 0, b, 1, n);
            int i = 0, j = (m + n + 1) / 2;
            while (true) {
                if (a[i] <= b[j + 1] && a[i + 1] > b[j]) {
                    int max1 = Math.max(a[i], b[j]);
                    int min2 = Math.min(a[i + 1], b[j + 1]);
                    return (m + n) % 2 == 1 ? max1 : (max1 + min2) / 2.0;
                }
                i++;
                j--;
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}