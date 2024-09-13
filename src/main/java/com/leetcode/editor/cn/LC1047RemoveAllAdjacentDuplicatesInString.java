package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 1047 删除字符串中的所有相邻重复项
public class LC1047RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1047);
        Solution solution = new LC1047RemoveAllAdjacentDuplicatesInString().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicates(String s) {
            StringBuilder st = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (st.length() > 0 && c == st.charAt(st.length() - 1)) {
                    st.deleteCharAt(st.length() - 1);
                } else {
                    st.append(c);
                }
            }
            return st.toString();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}