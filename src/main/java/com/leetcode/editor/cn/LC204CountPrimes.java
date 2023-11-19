package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 204 Count Primes
public class LC204CountPrimes {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 204);
        Solution solution = new LC204CountPrimes().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // [0,n]质数数量
        // 枚举
        // 埃氏筛
        public int countPrimes(int n) {
            int[] isPrime = new int[n];
            Arrays.fill(isPrime, 1);
            int ans = 0;
            for (int i = 2; i < n; ++i) {
                if (isPrime[i] != 1) {
                    continue;
                }
                ans += 1;
                if ((long) i * i >= n) {
                    continue;
                }
                for (int j = i * i; j < n; j += i) { // 将不可能为质数的位置标为0
                    isPrime[j] = 0;
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}