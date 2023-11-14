package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.ArrayDeque;
import java.util.Deque;

// 394 Decode String
public class LC394DecodeString {
    // REVIEW @date 2023-11-13
    public static void main(String[] args) {
        System.out.println("Leetcode " + 394);
        Solution solution = new LC394DecodeString().new Solution();
        String s = "100[leetcode]";
        System.out.println(solution.decodeString(s));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // k[encoded_string]
        // 以[]为界
        // 栈用deque push pop peek isEmpty
        public String decodeString(String s) {
            StringBuilder res = new StringBuilder();
            int n = s.length();
            Deque<Integer> kStk = new ArrayDeque<>(); // k
            Deque<StringBuilder> strStk = new ArrayDeque<>(); // encoded_string
            int k = 0;
            for (int i = 0; i < n; ++i) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') { // 数字
                    k = k * 10 + c - '0';
                } else if (c == '[') {
                    // 保存状态
                    kStk.push(k);
                    strStk.push(res);
                    // 重置
                    k = 0;
                    res = new StringBuilder();
                } else if (c == ']') {
                    // 恢复状态
                    int curK = kStk.pop();
                    StringBuilder tmp = new StringBuilder();
                    for (int j = 0; j < curK; ++j) { // 解码当前字符串
                        tmp.append(res);
                    }
                    // 与外层合并
                    res = strStk.pop().append(tmp);
                } else { // 字母
                    res.append(c);
                }
            }
            return res.toString();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}