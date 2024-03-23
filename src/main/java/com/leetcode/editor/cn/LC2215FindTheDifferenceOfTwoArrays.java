package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 2215 Find the Difference of Two Arrays
public class LC2215FindTheDifferenceOfTwoArrays {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2215);
        Solution solution = new LC2215FindTheDifferenceOfTwoArrays().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
            List<List<Integer>> answer = new ArrayList<>(new ArrayList<>());
            answer.add(new ArrayList<>());
            answer.add(new ArrayList<>());
            Set<Integer> set1 = new HashSet<>();
            for (int num : nums1) {
                set1.add(num);
            }
            Set<Integer> set2 = new HashSet<>();
            for (int num : nums2) {
                set2.add(num);
            }
            for (Integer x : set1) {
                if (!set2.contains(x)) {
                    answer.get(0).add(x);
                }
            }
            for (Integer x : set2) {
                if (!set1.contains(x)) {
                    answer.get(1).add(x);
                }
            }
            return answer;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}