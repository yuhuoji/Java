package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 392 Is Subsequence
public class LC392IsSubsequence {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 392);
        Solution solution = new LC392IsSubsequence().new Solution();
        String s = "b";
        String t = "abc";
        System.out.println(solution.isSubsequence(s, t));
    }

    // 双指针
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isSubsequence(String s, String t) {
            int sLen = s.length();
            int tLen = t.length();
            char[] cs = s.toCharArray();
            char[] ct = t.toCharArray();
            int ps = 0, pt = 0;
            while (ps < sLen && pt < tLen) {
                if (cs[ps] == ct[pt]) {
                    ps++;
                }
                pt++;
            }
            return ps == sLen;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}