package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 1456 Maximum Number of Vowels in a Substring of Given Length
public class LC1456MaximumNumberOfVowelsInASubstringOfGivenLength {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1456);
        Solution solution = new LC1456MaximumNumberOfVowelsInASubstringOfGivenLength().new Solution();
        String s = "abciiidef";
        int k = 33;
        System.out.println(solution.maxVowels(s, k));
    }

    // 滑动窗口 长度为k的子字符串
    // 注意滑动窗口边界问题

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 先i进入窗口，再更新答案，最后i-k+1出窗口
        public int maxVowels(String string, int k) {
            char[] s = string.toCharArray();
            int n = s.length;
            Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
            int cnt = 0;
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                if (vowels.contains(s[i])) {
                    cnt++;
                }
                if (i < k - 1) { // 窗口大小不足k
                    continue;
                }
                ans = Math.max(ans, cnt);
                if (vowels.contains(s[i - k + 1])) {
                    cnt--;
                }
            }
            return ans;
        }

        // 先i进入窗口，再i-k出窗口，最后更新答案
        public int maxVowels1(String string, int k) {
            char[] s = string.toCharArray();
            int n = s.length;
            Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
            int cnt = 0;
            for (int i = 0; i < k; ++i) { // 初始化
                cnt += vowels.contains(s[i]) ? 1 : 0;
            }
            int ans = cnt; // 初始化为窗口当前的最大值
            // 滑动窗口 长度为k 枚举右端点i 维护左端点(窗口出去的那个点)i-k
            for (int i = k; i < n; ++i) {
                cnt += vowels.contains(s[i]) ? 1 : 0;
                cnt -= vowels.contains(s[i - k]) ? 1 : 0;
                ans = Math.max(ans, cnt);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}