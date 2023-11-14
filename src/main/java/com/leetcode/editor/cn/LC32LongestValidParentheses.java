package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 32 Longest Valid Parentheses
public class LC32LongestValidParentheses {
    // REVIEW @date 2023-11-12 dp
    public static void main(String[] args) {
        System.out.println("Leetcode " + 32);
        Solution solution = new LC32LongestValidParentheses().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // dp
        // 状态定义: dp[i] 以i结尾的有效长度
        // s[i]= "(", dp[i]=0
        // s[i]=")", s[i-1]="(", dp[i] = dp[i-2]+2
        // s[i]=")", s[i-1]=")", s[i-dp[i-1]-1]="(", dp[i] = dp[i-1] + 2 + dp[i−dp[i−1]−2]
        public int longestValidParentheses(String s) {
            int n = s.length();
            char[] chars = s.toCharArray();
            int[] dp = new int[n];
            int max = 0;
            for (int i = 1; i < n; ++i) {
                if (chars[i] == '(') {
                    continue;
                }
                // sp[i] = ')'
                if (chars[i - 1] == '(') {
                    dp[i] = 2;
                    if (i - 2 >= 0) {
                        dp[i] += dp[i - 2];
                    }
                } else if (dp[i - 1] > 0) {
                    if ((i - dp[i - 1] - 1) >= 0 && chars[i - dp[i - 1] - 1] == '(') {
                        dp[i] = dp[i - 1] + 2;
                        int pre = i - dp[i - 1] - 2;
                        if (pre >= 0) {
                            dp[i] += dp[pre];
                        }
                    }
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}