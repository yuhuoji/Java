package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.HashMap;
import java.util.Map;

// 2949 Count Beautiful Substrings II
public class LC2949CountBeautifulSubstringsIi {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2949);
        Solution solution = new LC2949CountBeautifulSubstringsIi().new Solution();

    }

    // TODO @date 2023-12-02
    // 前缀和
    // o(N^2)
    // x^2 % k == 0
    //！质因数分解 4k
    // 哈希表统计pair(i%k', sum) 类似两数之和
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long beautifulSubstrings(String s, int k) {
            int n = s.length();
            char[] cs = s.toCharArray();
            Map<Integer, Integer> mp = new HashMap<>();
            for (int i = 0; i < n / 2; ++i) {
                if (i * i % k == 0) {
                    mp.put(i, 1);
                }
            }
            int[] pre = new int[n + 1];
            pre[0] = 0;
            for (int i = 0; i < n; ++i) {
                if (cs[i] == 'a' || cs[i] == 'e' || cs[i] == 'i' || cs[i] == 'o' || cs[i] == 'u') {
                    pre[i + 1] = pre[i] + 1;
                } else {
                    pre[i + 1] = pre[i];
                }
            }
            //[i..j]
            // j-i+1 = 2 * pre[j+1] - pre[i]
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    int vowels = pre[j + 1] - pre[i];
                    if (j - i + 1 == 2 * vowels && (vowels * (j - i + 1 - vowels)) % k == 0) {
                        cnt++;
                    }
                }
            }
            return cnt;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}