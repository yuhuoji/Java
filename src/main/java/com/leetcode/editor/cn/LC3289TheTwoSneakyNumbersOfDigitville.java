package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 3289 The Two Sneaky Numbers of Digitville
public class LC3289TheTwoSneakyNumbersOfDigitville {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "3289");
        Solution solution = new LC3289TheTwoSneakyNumbersOfDigitville().new Solution();

    }


    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getSneakyNumbers(int[] nums) {
            int n = nums.length - 2;
            int a = Arrays.stream(nums).sum() - (n - 1) * n / 2;
            int b = Arrays.stream(nums).map(x -> x * x).sum() - (n - 1) * n * (2 * n - 1) / 6;
            int x = (int) ((a - Math.sqrt(2 * b - a * a)) / 2);
            return new int[]{x, a - x};
        }

        public int[] getSneakyNumbers1(int[] nums) {
            int n = nums.length;
            List<Integer> ans = new ArrayList<>();
            int[] mp = new int[n];
            for (int x : nums) {
                mp[x]++;
            }
            for (int x : nums) {
                if (mp[x] == 2) {
                    ans.add(x);
                }
            }
            return ans.stream().distinct().mapToInt(i -> i).toArray();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}