package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 2947 Count Beautiful Substrings I
public class LC2947CountBeautifulSubstringsI {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2947);
        Solution solution = new LC2947CountBeautifulSubstringsI().new Solution();
        String s = "baeyh";
        int k = 2;
        System.out.println(solution.beautifulSubstrings(s, k));
    }
    // 前缀
    // o(N^2)
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int beautifulSubstrings(String s, int k) {
            int n = s.length();
            char[] cs = s.toCharArray();
            int[] pre = new int[n + 1];
            pre[0] = 0;
            for (int i = 0; i < n; ++i) {
                if (cs[i] == 'a' || cs[i] == 'e' || cs[i] == 'i' || cs[i] == 'o' || cs[i] == 'u') {
                    pre[i + 1] = pre[i] + 1;
                } else {
                    pre[i + 1] = pre[i];
                }
            }
            //[i..j]
            // j-i+1 = 2 * pre[j+1] - pre[i]
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    int vowels = pre[j + 1] - pre[i];
                    if (j - i + 1 == 2 * vowels && (vowels * (j - i + 1 - vowels)) % k == 0) {
                        cnt++;
                    }
                }
            }
            return cnt;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}