package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 3412 计算字符串的镜像分数
public class LC3412FindMirrorScoreOfAString {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "3412");
        Solution solution = new LC3412FindMirrorScoreOfAString().new Solution();

        String s = "eockppxdqclkhjgvnw";
        System.out.println(solution.calculateScore(s));

        // Deque
        // stack push pop peek
        // queue add/offer remove/poll
        // deque addFirst removeFirst addLast removeLast
    }
    // 镜像 对应数字相加等于25

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long calculateScore(String s) {
            Deque<Integer>[] stk = new Deque[26]; // 26个栈
            Arrays.setAll(stk, i -> new ArrayDeque<>());
            long ans = 0;
            for (int i = 0; i < s.length(); ++i) {
                int x = s.charAt(i) - 'a';
                if (!stk[25 - x].isEmpty()) {
                    int j = stk[25 - x].pop();
                    ans += i - j;
                } else {
                    stk[x].push(i);
                }
            }
            return ans;
        }

        //TODO @date 2025-01-09 模拟
        public long calculateScore1(String string) {
            long ans = 0;
            int n = string.length();
            char[] s = string.toCharArray();
            boolean[] flag = new boolean[n];
            Arrays.fill(flag, false);
            for (int i = 0; i < n; ++i) {
                for (int j = i - 1; j >= 0; --j) {
                    if (!flag[j] && (s[j] - 'a') + (s[i] - 'a') == 25) {
                        flag[j] = true;
                        ans += i - j;
                    }
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}