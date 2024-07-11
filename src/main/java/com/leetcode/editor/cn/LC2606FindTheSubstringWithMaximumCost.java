package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 2606 找到最大开销的子字符串
public class LC2606FindTheSubstringWithMaximumCost {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2606);
        Solution solution = new LC2606FindTheSubstringWithMaximumCost().new Solution();

    }

    // lc53 最大子段和（允许子数组为空）
    // f[i] 以i结尾的子字符串的最大开销
    // =cost[i] 只选s[i]一个
    // =f[i-1]+cost[i] 以s[i]结尾和之前接上的子字符串
    // f[i]=max(cost[i],f[i-1]+cost[i])

    // 返回max(f)>=0
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumCostSubstring(String s, String chars, int[] vals) {
            int[] cost = new int[26]; // 所有字母的开销
            for (int i = 0; i < 26; ++i) { // a=1 b=2 z=26
                cost[i] = i + 1;
            }
            for (int i = 0; i < chars.length(); ++i) {
                char c = chars.charAt(i);
                cost[c - 'a'] = vals[i];
            }
            int n = s.length();
            int[] f = new int[n + 1];
            int ans = 0;
            for (int i = 0; i < n; ++i) { // 遍历s
                char c = s.charAt(i);
                f[i + 1] = Math.max(cost[c - 'a'], f[i] + cost[c - 'a']);
                ans = Math.max(ans, f[i + 1]);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}