package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 17 电话号码的字母组合
public class LC17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 17);
        Solution solution = new LC17LetterCombinationsOfAPhoneNumber().new Solution();

    }

    // REVIEW @date 2024-07-22 回溯模板 选哪个
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // digits[i]-'0'
        private static final String[] MAPPING = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        private List<String> ans;
        private char[] digits, path;
        private int n;

        public List<String> letterCombinations(String digits) {
            n = digits.length();
            if (n == 0) {
                return List.of();
            }
            ans = new ArrayList<>();
            this.digits = digits.toCharArray();
            path = new char[n]; // 路径长度为n
            dfs(0);
            return ans;
        }

        private void dfs(int i) {
            if (i == n) {
                ans.add(new String(path));
                return;
            }
            for (char c : MAPPING[digits[i] - '0'].toCharArray()) { // eg:abc
                path[i] = c;
                dfs(i + 1);
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}