package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 2336 无限集中的最小数字
public class LC2336SmallestNumberInInfiniteSet {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2336);
        SmallestInfiniteSet smallestInfiniteSet = new LC2336SmallestNumberInInfiniteSet().new SmallestInfiniteSet();

    }
    // 有序集合
    // REVIEW @date 2024-07-03

    // leetcode submit region begin(Prohibit modification and deletion)
    class SmallestInfiniteSet {
        int thres; // 连续正整数的开始
        TreeSet<Integer> set; // 小于thres，单独添加的

        public SmallestInfiniteSet() {
            set = new TreeSet<>();
            thres = 1;
        }


        public int popSmallest() {
            if (!set.isEmpty()) {
                return set.pollFirst();
            } else {
                return thres++;
            }
        }

        // 判断在或不在
        public void addBack(int num) {
            if (num < thres) {
                set.add(num);
            }
        }
    }

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
// leetcode submit region end(Prohibit modification and deletion)

}