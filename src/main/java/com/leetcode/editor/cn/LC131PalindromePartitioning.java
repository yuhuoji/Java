package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.ArrayList;
import java.util.List;

// 131 Palindrome Partitioning
public class LC131PalindromePartitioning {
    // 回溯
    public static void main(String[] args) {
        System.out.println("LC " + 131);
        Solution solution = new LC131PalindromePartitioning().new Solution();

    }

    // REVIEW @date 2024-07-22 回溯模板 枚举选哪个

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private String s;
        private List<List<String>> ans;
        private List<String> path;
        private int n;

        // 每个位置选或不选
        public List<List<String>> partition(String s) {
            this.s = s;
            this.n = s.length();
            ans = new ArrayList<>();
            path = new ArrayList<>();
            dfs(0);
            return ans;
        }

        // 从start开始，当前位置i
        private void dfs(int i) {
            if (i == n) {
                ans.add(new ArrayList<>(path));// 复制 path
                return;
            }

            for (int j = i; j < n; ++j) {
                if (isPalindrome(i, j)) {
                    path.add(s.substring(i, j + 1));
                    dfs(j + 1);
                    path.remove(path.size() - 1); // 恢复现场
                }
            }
        }

        //[]
        private boolean isPalindrome(int i, int j) {
            while (i < j) { // i=j
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                ++i;
                --j;
            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

    // 每个位置选或不选
    class Solution1 {
        private String s;
        private List<List<String>> ans;
        private List<String> path;
        private int n;

        public List<List<String>> partition1(String s) {
            this.s = s;
            this.n = s.length();
            ans = new ArrayList<>();
            path = new ArrayList<>();
            dfs(0, 0);
            return ans;
        }

        // 从start开始，当前位置i
        private void dfs(int start, int i) {
            if (i == n) {
                ans.add(new ArrayList<>(path));// 复制 path
                return;
            }

            // 不选
            if (i < n - 1) {
                dfs(start, i + 1);
            }

            // 选
            String t = s.substring(start, i + 1); // substring:[beginning, ending)
            // 判断t是否回文
            if (isPalindrome(t)) {
                path.add(t);
                dfs(i + 1, i + 1);
                path.remove(path.size() - 1);// 恢复现场
            }
        }

        private boolean isPalindrome(String s) {
            int i = 0, j = s.length() - 1;
            while (i < j) { // i=j
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                ++i;
                --j;
            }
            return true;
        }
    }
}