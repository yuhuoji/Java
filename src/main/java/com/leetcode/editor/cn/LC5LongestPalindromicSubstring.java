package com.leetcode.editor.cn;

// 5 Longest Palindromic Substring
public class LC5LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 5);
        Solution solution = new LC5LongestPalindromicSubstring().new Solution();
        String s = "cbbd";
        System.out.println(solution.longestPalindrome(s));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private String s;

        // dfs(i,j) 依赖左下角 dfs(i+1,j-1)。i倒序枚举，j顺序枚举
        public String longestPalindrome(String s) {
            int n = s.length();
            this.s = s;
            int maxLen = 1;
            int maxStart = 0;
            boolean[][] dp = new boolean[n][n];
            for (int i = n - 1; i >= 0; --i) {
                dp[i][i] = true; // i=j
                for (int j = i + 1; j < n; ++j) {
                    if (j - i == 1) { // i+1=j, 防止越界
                        dp[i][j] = s.charAt(i) == s.charAt(j);
                    } else if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        maxStart = i;
                    }
                }
            }
            return s.substring(maxStart, maxStart + maxLen);
        }

        // 区间dp
        // dfs(i,j) = s[i]==s[j]&&dfs(i+1,j-1)
        // [i]=[j]  dfs(i+1,j-1)
        // != false
        public String longestPalindrome1(String s) {
            int n = s.length();
            this.s = s;
            int maxLen = 1;
            int maxStart = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    if (dfs(i, j)) { // 是回文
                        if (j - i + 1 > maxLen) {
                            maxLen = j - i + 1;
                            maxStart = i;
                        }
                    }
                }
            }
            return s.substring(maxStart, maxStart + maxLen);
        }

        // [i,j]是否为回文串 TLE
        private boolean dfs(int i, int j) {
            if (i >= j) {
                return true;
            }
            if (s.charAt(i) == s.charAt(j)) {
                return dfs(i + 1, j - 1);
            }
            // 不等
            return false;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}