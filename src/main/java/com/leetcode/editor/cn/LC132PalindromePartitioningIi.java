package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 132 Palindrome Partitioning II
public class LC132PalindromePartitioningIi {
    public static void main(String[] args) {
        System.out.println("LC " + 132);
        Solution solution = new LC132PalindromePartitioningIi().new Solution();
        String s = "coder";
        System.out.println(solution.minCut(s));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // REVIEW @date 2023-11-20
        // 回溯 枚举分割位置
        // 区间dp 最小分割次数

        // 找到r之前尽量长的回文串
        // [0..i]
        // dp[i] = dp[i-尽量长的回文串] + 1
        // dp[0]=1
        // i<0 dp=0
        // 返回dp[n-1]
        public int minCut(String s) {
            int n = s.length();
            char[] chars = s.toCharArray();

            boolean[][] isPalindrome = new boolean[n][n]; //[l,r]是否为回文串
            for (var p : isPalindrome) { // 对角线左下均为true
                Arrays.fill(p, true);
            }
            // dp(l,r)  = dp(l+1,r-1) && s[l]==s[r]
            for (int l = n - 1; l >= 0; --l) {
                isPalindrome[l][l] = true; //[l=r]
                for (int r = l + 1; r < n; ++r) {
                    isPalindrome[l][r] = chars[l] == chars[r] && isPalindrome[l + 1][r - 1];
                }
            }

            int[] dp = new int[n + 1]; // 分割[0..i]的最小次数, 前面插入一位, 防止越界
            for (int r = 0; r < n; ++r) { // dp[r] [0..r]分割次数
                if (isPalindrome[0][r]) { // 是回文串，不需要分割
                    dp[r + 1] = 0;
                    continue;
                }
                int min = n;
                for (int l = 0; l <= r; ++l) { // 从[0..r]中找最长回文串, 最少为1
                    if (isPalindrome[l][r]) { //[l,r]
                        min = Math.min(min, dp[l] + 1); // 越界
                    }
                }
                dp[r + 1] = min;
            }
            return dp[n];
        }


    }
// leetcode submit region end(Prohibit modification and deletion)

}