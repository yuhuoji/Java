package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 22 括号生成
public class LC22GenerateParentheses {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 22);
        Solution solution = new LC22GenerateParentheses().new Solution();
        int n = 3;
        System.out.println(solution.generateParenthesis(n));
    }

    // 最终left right都是n
    // 任何位置left>=right
    // left<n 都能选左括号 left=n只能选右括号 left不可能>n
    // left>right 能选右括号

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 枚举下一个左括号的位置
        private List<String> ans = new ArrayList<>();
        private List<Integer> path = new ArrayList<>(); // 记录左括号的位置
        private int n;

        public List<String> generateParenthesis(int n) {
            this.n = n;
            dfs(0, 0);
            return ans;
        }

        // 0..i-1，i个字符有left个左括号，有i-left个右括号，可以再添加2*left-i个右括号
        private void dfs(int i, int left) {
            if (path.size() == n) { // 最多填n个左括号
                char[] s = new char[n * 2];
                Arrays.fill(s, ')');
                for (int j : path) {
                    s[j] = '(';
                }
                ans.add(new String(s));
                return;
            }
            for (int right = 0; right <= 2 * left - i; ++right) { // 可以添加的右括号数量,填入[i,i+right-1]
                path.add(i + right); // 记录下一个左括号的位置
                dfs(i + right + 1, left + 1);
                path.remove(path.size() - 1);// 恢复现场
            }

        }
    }

    class Solution1 {
        // 枚举左括号还是右括号
        private List<String> ans = new ArrayList<>();
        private char[] path;
        private int n;

        public List<String> generateParenthesis(int n) {
            this.n = n;
            path = new char[2 * n]; // 路径长度固定为2n
            dfs(0, 0);
            return ans;
        }

        private void dfs(int i, int left) {
            if (i == path.length) {
                ans.add(new String(path));
                return;
            }
            if (left < n) {
                path[i] = '(';
                dfs(i + 1, left + 1);
            }
            if (left > i - left) { // left>right 能选右括号
                path[i] = ')';
                dfs(i + 1, left);
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}