package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.HashMap;
import java.util.Map;

// 3 Longest Substring Without Repeating Characters
public class LC3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 3);
        Solution solution = new LC3LongestSubstringWithoutRepeatingCharacters().new Solution();

    }

    // s 由英文字母、数字、符号和空格组成 用哈希表
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 不含重复字符 哈希表or其他
        // 最长 滑动窗口
        public int lengthOfLongestSubstring1(String s) {
            int n = s.length();
            char[] c = s.toCharArray();
            int max = 0; // 输入空字符串""
            Map<Character, Integer> mp = new HashMap<>();
            for (int l = 0, r = 0; r < n; ++r) {
                if (mp.containsKey(c[r])) {
                    l = Math.max(l, mp.get(c[r]) + 1);
                }
                mp.put(c[r], r);
                max = Math.max(max, r - l + 1);
            }
            return max;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}