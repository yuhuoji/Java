package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 443 String Compression
public class LC443StringCompression {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 443);
        Solution solution = new LC443StringCompression().new Solution();
        String s = "[\"a\",\"a\",\"b\",\"b\",\"c\",\"c\",\"c\"]";
        char[] chars = LeetCodeHelper.stringToCharArray(s);
        System.out.println(solution.compress(chars));
    }

    // 1不用压缩
    // cnt可能为多位
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int compress(char[] chars) {
            int i = 0, j = 0, write = 0;
            int n = chars.length;
            while (j < n) {
                while (j < n && chars[j] == chars[i]) {
                    j++;
                }
                chars[write++] = chars[i];
                // j-i
                int cnt = j - i;
                if (cnt > 1) {
                    String t = Integer.toString(cnt);
                    for (int k = 0; k < t.length(); k++) {
                        chars[write++] = t.charAt(k);
                    }
                }
                i = j;
            }
            return write;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}