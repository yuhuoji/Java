package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 1071 Greatest Common Divisor of Strings
public class LC1071GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1071);
        Solution solution = new LC1071GreatestCommonDivisorOfStrings().new Solution();

    }

    // s = t + ... + t
    // 一定是一个前缀串
    // 如果存在一定是gcd(len1,len2)
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String gcdOfStrings(String str1, String str2) {
            int len1 = str1.length(), len2 = str2.length();
            String t = str1.substring(0, gcd(len1, len2));
            if (check(str1, t) && check(str2, t)) {
                return t;
            }
            return "";
        }

        private boolean check(String s, String t) {
            if (s.length() % t.length() != 0) {
                return false;
            }
            int time = s.length() / t.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= time; ++i) {
                sb.append(t);
            }
            return sb.toString().equals(s);
        }

        private int gcd(int a, int b) {
            int remainder = a % b;
            while (remainder != 0) {
                a = b;
                b = remainder;
                remainder = a % b;
            }
            return b;
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)
    class Solution1 {
        public String gcdOfStrings(String str1, String str2) {
            int len1 = str1.length(), len2 = str2.length();
            for (int i = Math.min(len1, len2); i >= 1; --i) { // 从大到小枚举
                if (len1 % i == 0 && len2 % i == 0) {
                    String t = str1.substring(0, i);
                    if (check(str1, t) && check(str2, t)) {
                        return t;
                    }
                }
            }
            return "";
        }

        private boolean check(String s, String t) {
            if (s.length() % t.length() != 0) {
                return false;
            }
            int time = s.length() / t.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= time; ++i) {
                sb.append(t);
            }
            return sb.toString().equals(s);
        }

    }
}