package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 6 Zigzag Conversion
public class LC6ZigzagConversion {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 6);
        Solution solution = new LC6ZigzagConversion().new Solution();
        String s = "AB";
        int num = 1;
        System.out.println(solution.convert(s, num));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 3 12321232123 读第一行第二行第三行
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            StringBuilder[] rows = new StringBuilder[numRows]; // 每一行
            for (int i = 0; i < numRows; ++i) {
                rows[i] = new StringBuilder();
            }
            int flag = -1, row = 0; // 用flag控制方向
            for (char c : s.toCharArray()) {
                rows[row].append(c);
                if (row == 0 || row == numRows - 1) {
                    flag = -flag;
                }
                row += flag;
            }
            StringBuilder sb = new StringBuilder(); // 把每一行合成结果
            for (StringBuilder r : rows) {
                sb.append(r);
            }
            return sb.toString();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}