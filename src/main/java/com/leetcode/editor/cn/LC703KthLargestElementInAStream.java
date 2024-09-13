package com.leetcode.editor.cn;

import java.util.PriorityQueue;

// 703 数据流中的第 K 大元素
public class LC703KthLargestElementInAStream {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 703);
        int k = 5;
        int[] nums = {1, 2, 3, 4, 5};
        KthLargest kthLargest = new LC703KthLargestElementInAStream().new KthLargest(k, nums);

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class KthLargest {
        PriorityQueue<Integer> heap;
        int capacity;

        public KthLargest(int k, int[] nums) {
            this.capacity = k;
            heap = new PriorityQueue<>(capacity + 1);
            for (int x : nums) {
                heap.add(x);
                if (heap.size() > capacity) {
                    heap.poll();
                }
            }
        }

        public int add(int val) {
            heap.add(val);
            if (heap.size() > capacity) {
                heap.poll();
            }
            return heap.peek();
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
// leetcode submit region end(Prohibit modification and deletion)

}