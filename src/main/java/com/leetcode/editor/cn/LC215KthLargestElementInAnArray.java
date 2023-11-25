package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 215 Kth Largest Element in an Array
public class LC215KthLargestElementInAnArray {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 215);
        Solution solution = new LC215KthLargestElementInAnArray().new Solution();

    }
    //TODO @date 2023-11-23

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 最小堆维护最大的k个元素
        // n*log(k)
        public int findKthLargest(int[] nums, int k) {
            int n = nums.length;
            PriorityQueue<Integer> heap = new PriorityQueue<>(k + 1); // 最小堆
            for (int x : nums) {
                heap.add(x);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
            return heap.peek();
        }

        public int findKthLargest1(int[] nums, int k) {
            int n = nums.length;
            PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder()); // 最大堆
            for (int x : nums) {
                heap.add(x);
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < k; ++i) {
                ans = heap.poll();
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}