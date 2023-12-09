package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 2953 Count Complete Substrings
public class LC2953CountCompleteSubstrings {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2953);
        Solution solution = new LC2953CountCompleteSubstrings().new Solution();
        String word = "jjjqq";
        int k = 1;
        System.out.println(solution.countCompleteSubstrings(word, k));
    }

    // REVIEW @date 2023-12-09 滑动窗口
    // 分组循环
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private char[] cs;

        public int countCompleteSubstrings(String word, int k) {
            int n = word.length();
            cs = word.toCharArray();
            int ans = 0;

            for (int i = 0; i < n; ) {
                int start = i;
                for (i++; i < n && Math.abs((int) cs[i] - (int) cs[i - 1]) <= 2; i++) ;
                // 本组[start, i-1]
                ans += f(start, i - 1, k);
            }
            return ans;
        }

        // 滑动窗口 出现字母1-26 
        // cs[l,r]
        private int f(int l, int r, int k) {
            int len = r - l + 1; // 本段字串的长度
            int res = 0;
            for (int m = 1; m <= 26; ++m) { // 枚举字母数量m，长度m*k
                if (m * k > len) { // 剪枝
                    break;
                }
                int[] cnt = new int[26]; // 哈希表，记录m个字母是否都出现k次
                for (int right = l; right <= r; ++right) {
                    cnt[cs[right] - 'a']++;
                    int left = right + 1 - k * m;
                    if (left >= l) {
                        boolean ok = true;
                        for (int i = 0; i < 26; ++i) {
                            if (cnt[i] > 0 && cnt[i] != k) {
                                ok = false;
                                break;
                            }
                        }
                        if (ok) {
                            res++;
                        }
                        cnt[cs[left] - 'a']--;
                    }
                }
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}