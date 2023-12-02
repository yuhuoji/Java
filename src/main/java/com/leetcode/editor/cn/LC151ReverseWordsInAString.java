package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

// 151 Reverse Words in a String
public class LC151ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 151);
        Solution solution = new LC151ReverseWordsInAString().new Solution();

    }
    // REVIEW @date 2023-11-30 StringBuilder
    // 倒序反转单词

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords2(String s) {
            s = s.trim();
            int n = s.length();
            StringBuilder sb = new StringBuilder();
            int end = n - 1, start;
            while (end >= 0) {
                while (end >= 0 && s.charAt(end) == ' ') {
                    --end;
                }
                start = end;
                while (start >= 0 && s.charAt(start) != ' ') {
                    --start;
                }
                sb.append(s.substring(start + 1, end + 1) + ' ');
                end = start;
            }
            return sb.toString().substring(0, sb.length() - 1);
        }

        public String reverseWords1(String s) {
            s = s.trim();
            List<String> list = Arrays.asList(s.split("\\s+"));
            Collections.reverse(list);
            return String.join(" ", list);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}