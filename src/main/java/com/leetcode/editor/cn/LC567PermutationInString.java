package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

//567 字符串的排列
public class LC567PermutationInString {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 567);
        Solution solution = new LC567PermutationInString().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int len1 = s1.length();
            int len2 = s2.length();
            if (len2 < len1) {
                return false;
            }
            int[] cnt1 = new int[26];
            int[] cnt2 = new int[26];
            for (int i = 0; i < len1; ++i) {
                cnt1[s1.charAt(i) - 'a']++;
                cnt2[s2.charAt(i) - 'a']++;
            }
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
            for (int i = len1; i < len2; ++i) { //[i-len1+1,i]
                cnt2[s2.charAt(i - len1) - 'a']--;
                cnt2[s2.charAt(i) - 'a']++;
                if (Arrays.equals(cnt1, cnt2)) {
                    return true;
                }
            }
            return false;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}