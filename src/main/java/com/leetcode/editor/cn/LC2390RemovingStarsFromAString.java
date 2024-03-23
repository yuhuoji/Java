package com.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

// 2390 Removing Stars From a String
public class LC2390RemovingStarsFromAString {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2390);
        Solution solution = new LC2390RemovingStarsFromAString().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeStars(String string) {
            char[] s = string.toCharArray();
            int n = s.length;
            Deque<Character> stk = new ArrayDeque<>();
            for (int i = 0; i < n; ++i) {
                if (s[i] != '*') {
                    stk.push(s[i]);
                } else {
                    stk.pop();
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char c : stk) {
                sb.insert(0, stk.pop());
            }
            return sb.toString();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}