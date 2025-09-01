package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 3 Longest Substring Without Repeating Characters
public class LC3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 3);
        Solution solution = new LC3LongestSubstringWithoutRepeatingCharacters().new Solution();

    }
    // REVIEW @date 2025-09-01

    // s 由英文字母、数字、符号和空格组成。包含在0-127中，可以用int[128]存储
    // Map其实也可以用int[int[]]代替

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 哈希数组/布尔数组
        public int lengthOfLongestSubstring(String string) {
            int n = string.length();
            char[] s = string.toCharArray();
            boolean[] has = new boolean[128];
            int ans = 0, left = 0;
            for (int right = 0; right < n; ++right) {
                char c = s[right];
                while (has[c]) {
                    has[s[left++]] = false;
                }
                has[c] = true;
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }

        // 哈希 滑动窗口
        // !! Map 出现重复时直接跳到下一位
        public int lengthOfLongestSubstring2(String string) {
            int n = string.length();
            char[] s = string.toCharArray();
            Map<Character, Integer> mp = new HashMap<>();
            int ans = 0, left = 0;
            for (int right = 0; right < n; ++right) {
                if (mp.containsKey(s[right])) {
                    left = mp.get(s[right]) + 1; // !直接跳到下一位
                }
                mp.put(s[right], right);
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }

        // Set
        public int lengthOfLongestSubstring1(String string) {
            int n = string.length();
            char[] s = string.toCharArray();
            Set<Character> st = new HashSet<>();
            int ans = 0, left = 0;
            for (int right = 0; right < n; ++right) {
                while (st.contains(s[right])) {
                    st.remove(s[left++]);
                }
                st.add(s[right]);
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }
    }

    class Solution1 {

        // 布尔数组存储
        public int lengthOfLongestSubstring(String string) {
            int n = string.length();
            char[] s = string.toCharArray();
            int ans = 0;
            int left = 0;
            boolean[] has = new boolean[128];
            for (int right = 0; right < n; ++right) {
                char c = s[right];
                while (has[c]) { // 有重复字符
                    has[s[left]] = false;
                    left++;
                }
                has[c] = true;
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }

        // int[128]整形数组存储
        public int lengthOfLongestSubstring2(String string) {
            int n = string.length();
            char[] s = string.toCharArray();
            int ans = 0;
            int left = 0;
            int[] cnt = new int[128];
            for (int right = 0; right < n; ++right) {
                char c = s[right];
                cnt[c]++;
                while (cnt[c] > 1) { // 有重复字符
                    cnt[s[left]]--;
                    left++;
                }
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }

        // 用set存
        public int lengthOfLongestSubstring1(String string) {
            int n = string.length();
            char[] s = string.toCharArray();
            int ans = 0;
            int left = 0;
            Set<Character> st = new HashSet<>();
            for (int right = 0; right < n; ++right) {
                while (st.contains(s[right])) {
                    st.remove(s[left]);
                    left++;
                }
                st.add(s[right]);
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }

        // 用map存字符和对应位置，出现重复字符时left可以直接跳转到重复字符的下一个位置
        public int lengthOfLongestSubstring0(String string) {
            int n = string.length();
            char[] s = string.toCharArray();
            int ans = 0;
            int left = 0;
            Map<Character, Integer> mp = new HashMap<>(); // set
            for (int right = 0; right < n; ++right) {
                if (mp.containsKey(s[right])) {
                    left = Math.max(left, mp.get(s[right]) + 1);// ！！！如果在滑动窗口内，则直接跳到重复字符的下一位。如果不在滑动窗口内则left不用移动
                }
                mp.put(s[right], right);
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }

        // 不含重复字符 哈希表or其他
        // 最长 滑动窗口
    }
// leetcode submit region end(Prohibit modification and deletion)

}