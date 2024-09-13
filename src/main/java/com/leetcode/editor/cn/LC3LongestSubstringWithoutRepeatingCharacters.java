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
        public int lengthOfLongestSubstring(String string) {
            char[] s = string.toCharArray();
            int n = s.length;
            Map<Character, Integer> mp = new HashMap<>();
            int ans = 0;
            for (int l = 0, r = 0; r < n; ++r) {
                if (mp.containsKey(s[r])) {
                    l = Math.max(l, mp.get(s[r]) + 1); //直接跳到重复字符的下一位
                }
                mp.put(s[r], r);
                ans = Math.max(ans, r - l + 1);
            }
            return ans;
        }

        public int lengthOfLongestSubstring1(String string) {
            int n = string.length();
            char[] s = string.toCharArray();
            Map<Character, Integer> mp = new HashMap<>();
            int ans = 0;
            for (int l = 0, r = 0; r < n; ++r) {
                while (mp.containsKey(s[r])) {
                    mp.remove(s[l]);
                    l++;
                }
                mp.put(s[r], 1);
                ans = Math.max(ans, r - l + 1);
            }
            return ans;
        }

        // 不含重复字符 哈希表or其他
        // 最长 滑动窗口
    }
// leetcode submit region end(Prohibit modification and deletion)

}