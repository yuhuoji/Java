package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.ArrayDeque;
import java.util.Deque;

// 2390 从字符串中移除星号
public class LC2390RemovingStarsFromAString {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2390);
        Solution solution = new LC2390RemovingStarsFromAString().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeStars(String string) {
            char[] s = string.toCharArray();
            Deque<Character> st = new ArrayDeque<>();
            for (char c : s) {
                if (c == '*') {
                    st.pop();
                } else {
                    st.push(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!st.isEmpty()) {
                sb.insert(0, st.pop());
            }
            return sb.toString();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}