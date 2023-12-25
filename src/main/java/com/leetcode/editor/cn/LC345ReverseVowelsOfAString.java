package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 345 Reverse Vowels of a String
public class LC345ReverseVowelsOfAString {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 345);
        Solution solution = new LC345ReverseVowelsOfAString().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 双指针

        public String reverseVowels(String s) {
            int n = s.length();
            char[] cs = s.toCharArray();
            for (int l = 0, r = n - 1; l < r; ) {
                while (l < n && !isVowel(cs[l])) {
                    l++;
                }
                while (r >= 0 && !isVowel(cs[r])) {
                    r--;
                }
                if (l < r) {
                    swap(cs, l, r);
                    l++;
                    r--;
                }
            }
            return new String(cs);
        }

        private boolean isVowel(char c) {
            return "aeiouAEIOU".indexOf(c) >= 0; // 返回第一次出现的下标，否则返回-1
        }

        private void swap(char[] arr, int i, int j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}