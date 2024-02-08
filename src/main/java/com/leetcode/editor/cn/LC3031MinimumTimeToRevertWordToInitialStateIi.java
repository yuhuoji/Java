package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 3031 Minimum Time to Revert Word to Initial State II
public class LC3031MinimumTimeToRevertWordToInitialStateIi {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 3031);
        Solution solution = new LC3031MinimumTimeToRevertWordToInitialStateIi().new Solution();

    }

    // REVIEW @date 2024-02-08 z函数/扩展kmp 后缀和前缀匹配
    // TODO @date 2024-02-08 LC2223
    // 求z[i] 如果z[i]大于n-i表示后缀能与前缀匹配
    // https://personal.utdallas.edu/~besp/demo/John2010/z-algorithm.htm
    // 字符串 abababzabababab
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTimeToInitialState(String word, int k) {
            char[] s = word.toCharArray();
            int n = s.length;
            int[] z = new int[n]; // i位置开始能匹配多长的前缀
            int l = 0, r = 0; // 滑动窗口 z-box的左右边界
            for (int i = 1; i < n; ++i) { // 从1位置开始匹配
                if (i <= r) { // i在z-box内
                    z[i] = Math.min(z[i - l], r - i + 1); // z算法 i位置能匹配的和z-box剩余长度
                }
                while (i + z[i] < n && s[z[i]] == s[i + z[i]]) {
                    l = i;
                    r = i + z[i];
                    z[i]++;
                }
                if (i % k == 0 && z[i] >= n - i) { // k倍数的后缀是一个前缀
                    return i / k;
                }
            }
            return (n - 1) / k + 1; // 把字符串全删除 n/k上取整
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}