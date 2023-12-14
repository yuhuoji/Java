package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 2381 Shifting Letters II
public class LC2381ShiftingLettersIi {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2381);
        Solution solution = new LC2381ShiftingLettersIi().new Solution();
        char c = 'a';
        System.out.println((int) 'a');
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String shiftingLetters(String s, int[][] shifts) {
            int n = s.length();
            int[] diff = new int[n + 1]; // 开成n+1省略溢出特判
            for (int[] shift : shifts) {
                int start = shift[0], end = shift[1], direction = shift[2];
                //[start,end]
                diff[start] += direction == 1 ? 1 : -1;
                diff[end + 1] -= direction == 1 ? 1 : -1;
            }
            for (int i = 1; i < n; ++i) {
                diff[i] += diff[i - 1];
            }
            char[] cs = s.toCharArray();
            for (int i = 0; i < n; ++i) {
                cs[i] = (char) ((cs[i] - 'a' + (diff[i] % 26) + 26) % 26 + 'a'); // 防止shift是负数
            }
            return new String(cs);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}