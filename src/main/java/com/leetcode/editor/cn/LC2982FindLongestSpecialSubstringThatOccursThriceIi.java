package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 2982 Find Longest Special Substring That Occurs Thrice II
public class LC2982FindLongestSpecialSubstringThatOccursThriceIi {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2982);
        Solution solution = new LC2982FindLongestSpecialSubstringThatOccursThriceIi().new Solution();

    }

    // TODO @date 2024-01-29
    // 按相同字母分组，然后分类讨论
    // max(a[0]−2, min(a[0]−1,a[1]), a[2])
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumLength(String string) {
            char[] s = string.toCharArray();
            List<Integer>[] groups = new ArrayList[26]; // 统计每个字母的连续字符长度
            Arrays.setAll(groups, i -> new ArrayList<>());
            int n = s.length;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                cnt++;
                if (i == n - 1 || s[i] != s[i + 1]) {
                    groups[s[i] - 'a'].add(cnt);
                    cnt = 0;
                }
            }

            int ans = 0;
            for (var group : groups) {
                if (group.isEmpty()) {
                    continue;
                }
                group.sort(Collections.reverseOrder());
                group.add(0);
                group.add(0); // 末尾填两个空串
                ans = Math.max(ans,
                        Math.max(group.get(0) - 2,
                                Math.max(
                                        Math.min(group.get(0) - 1, group.get(1)), group.get(2)
                                )
                        )
                );
            }
            return ans > 0 ? ans : -1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}