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
        String s = "ibpbhixfiouhdljnjfflpapptrxgcomvnb";
        int k = 33;
        System.out.println(solution.maxVowels(s, k));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxVowels(String string, int k) {
            int n = string.length();
            char[] s = string.toCharArray();
            Set<Character> vowel = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
            int cnt = 0;
            for (int i = 0; i < k; ++i) {
                cnt += vowel.contains(s[i]) ? 1 : 0;
            }
            int mx = cnt;
            for (int i = k; i < n; ++i) {
                cnt += vowel.contains(s[i]) ? 1 : 0;
                cnt -= vowel.contains(s[i - k]) ? 1 : 0;
                mx = Math.max(mx, cnt);
            }
            return mx;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}