package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 1010 总持续时间可被 60 整除的歌曲
public class LC1010PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "1010");
        Solution solution = new LC1010PairsOfSongsWithTotalDurationsDivisibleBy60().new Solution();

    }


    // leetcode submit region begin(Prohibit modification and deletion)
    // x+y
    class Solution {
        public int numPairsDivisibleBy60(int[] time) {
            int n = time.length;
            Map<Integer, Integer> mp = new HashMap<>();
            int ans = 0;
            for (int j = 0; j < n; ++j) {
                int x = time[j] % 60;
                ans += mp.getOrDefault((60 - x) % 60, 0);
                mp.put(x, mp.getOrDefault(x, 0) + 1);
            }
            return ans;
        }

        public int numPairsDivisibleBy601(int[] time) {
            int n = time.length;
            Map<Integer, Integer> mp = new HashMap<>();
            int ans = 0;
            for (int j = 0; j < n; ++j) {
                int x = time[j] % 60; // 0<=x<60
                if (x > 0) {
                    ans += mp.getOrDefault(60 - x, 0);
                } else if (x == 0) {
                    ans += mp.getOrDefault(0, 0);
                }
                mp.put(x, mp.getOrDefault(x, 0) + 1);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}