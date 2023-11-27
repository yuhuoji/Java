package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Collections;
import java.util.PriorityQueue;

// 295 Find Median from Data Stream
public class LC295FindMedianFromDataStream {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 295);
        MedianFinder medianFinder = new LC295FindMedianFromDataStream().new MedianFinder();

    }

    // 二叉平衡树
    // 最大堆+最小堆
// leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {
        // 左侧最大堆，右侧最小堆，保持最大堆数量>=最小堆
        PriorityQueue<Integer> maxHeap; // 小的部分，多一个
        PriorityQueue<Integer> minHeap; // 大的部分

        public MedianFinder() {
            //(a, b) -> b - a 返回negative，表示第一个元素看作小，排在前面；返回positive，表示第一个元素看作大，排在后面
            maxHeap = new PriorityQueue<>((a, b) -> b - a); // Collections.reverseOrder();
            minHeap = new PriorityQueue<>((a, b) -> a - b);
        }

        public void addNum(int num) {
            if (maxHeap.size() == minHeap.size()) { // 相等，添加完左侧多一个
                if (minHeap.isEmpty() || num <= minHeap.peek()) { // 一定不在右侧，直接添加
                    maxHeap.add(num);
                } else { // 添加位置在右侧
                    maxHeap.add(minHeap.poll());
                    minHeap.add(num);
                }
            } else { // 不相等
                if (num >= maxHeap.peek()) { // 添加位置在右侧，直接添加
                    minHeap.add(num);
                } else { // 添加位置在左侧
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(num);
                }
            }
        }

        public double findMedian() {
            if (maxHeap.size() == 0) { // 为空
                return -1;
            }
            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else {
                return maxHeap.peek();
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// leetcode submit region end(Prohibit modification and deletion)

}