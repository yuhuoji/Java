package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 438 找到字符串中所有字母异位词
public class LC438FindAllAnagramsInAString {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 438);
        Solution solution = new LC438FindAllAnagramsInAString().new Solution();

    }

    // Arrays.equals
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 长度为pLen的滑动窗口
        public List<Integer> findAnagrams(String s, String p) {
            int sLen = s.length();
            int pLen = p.length();
            if (sLen < pLen) {
                return new ArrayList<>();
            }
            List<Integer> ans = new ArrayList<>();
            int[] sArr = new int[128];
            int[] pArr = new int[128];
            // 初始化
            for (int i = 0; i < pLen; ++i) {
                sArr[s.charAt(i)]++;
                pArr[p.charAt(i)]++;
            }
            if (Arrays.equals(sArr, pArr)) {
                ans.add(0);
            }
            // i-pLen+1..pLen的滑动窗口
            for (int i = pLen; i < sLen; ++i) {
                sArr[s.charAt(i)]++;
                sArr[s.charAt(i - pLen)]--;
                if (Arrays.equals(sArr, pArr)) {
                    ans.add(i - pLen + 1);
                }
            }
            return ans;
        }
    }


    class Solution1 {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ans = new ArrayList<>();
            int sLen = s.length();
            int pLen = p.length();
            if (sLen < pLen) {
                return ans;
            }
            int[] sCount = new int[26];
            int[] pCount = new int[26];
            for (int i = 0; i < pLen; ++i) {
                sCount[s.charAt(i) - 'a']++;
                pCount[p.charAt(i) - 'a']++;
            }
            if (Arrays.equals(sCount, pCount)) {
                ans.add(0);
            }
            for (int i = pLen; i < sLen; ++i) { //[i-pLen+1,i]
                sCount[s.charAt(i - pLen) - 'a']--;
                sCount[s.charAt(i) - 'a']++;
                if (Arrays.equals(sCount, pCount)) {
                    ans.add(i - pLen + 1);
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}