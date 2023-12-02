package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.ArrayList;
import java.util.List;

// 30 Substring with Concatenation of All Words
public class LC30SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 30);
        Solution solution = new LC30SubstringWithConcatenationOfAllWords().new Solution();

    }

    // TODO @date 2023-11-30
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            int n = s.length();
            int sz = words.length;
            int len = words[0].length();
            // 滑动窗口sz * len

            List<Integer> ans = new ArrayList<>();
            for (int l = 0, r = 0; r < n; ++r) {

            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}