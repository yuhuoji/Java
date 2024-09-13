package com.leetcode.editor.cn;

import java.util.Arrays;

// 494. 目标和
public class LC494TargetSum {
    public static void main(String[] args) {
        System.out.println("LC " + 494);
        Solution solution = new LC494TargetSum().new Solution();
    }
    // REVIEW @date 2024-07-18 01背包 选或不选i都要转移到i-1位置
    // 递推 dfs(i,c) = max(dfs(i-1,c),dfs(i-1,c-w[i])+v[i])

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 一个数组 从右向左计算
        public int findTargetSumWays(int[] nums, int target) {
            int sum = Arrays.stream(nums).sum();
            target += sum;
            if (target < 0 || target % 2 == 1) {
                return 0;
            }
            int capacity = target /= 2;
            int n = nums.length;
            int[] f = new int[capacity + 1];
            f[0] = 1;
            for (int i = 0; i < n; ++i) {
                for (int c = capacity; c >= 0; --c) {
                    if (c < nums[i]) {
                        f[c] = f[c];
                    } else {
                        f[c] = f[c] + f[c - nums[i]];
                    }
                }
            }
            return f[capacity];
        }

        // 两个数组滚动 f[i] 对i%2
        public int findTargetSumWays2(int[] nums, int target) {
            int sum = Arrays.stream(nums).sum();
            target += sum;
            if (target < 0 || target % 2 == 1) {
                return 0;
            }
            int capacity = target /= 2;
            int n = nums.length;
            int[][] f = new int[2][capacity + 1];
            f[0][0] = 1;
            for (int i = 0; i < n; ++i) {
                for (int c = 0; c <= capacity; ++c) {
                    if (c < nums[i]) {
                        f[(i + 1) % 2][c] = f[i % 2][c];
                    } else {
                        f[(i + 1) % 2][c] = f[i % 2][c] + f[i % 2][c - nums[i]];
                    }
                }
            }
            return f[n % 2][capacity];
        }

        // 设正数=p
        // p-(s-p)=t
        // p=(s+t)/2 每个数可选可不选，和为p
        // 定义f[i][c] 表示从0..i选和为c的方法数
        // f[i][c] = f[i-1][c] + f[i-1][c-nums[i]], where c-nums[i]>=0
        // 返回f[n-1][t]
        // 初始值f[-1][0]=1, 其他都不合理
        // f左侧加1位
        // f[i+1][c] = f[i][c] + f[i][c-nums[i]], where c-nums[i]>=0
        // 返回f[n][t]
        // 初始值f[0][0]=1, 其他都不合理
        public int findTargetSumWays1(int[] nums, int target) {
            int sum = Arrays.stream(nums).sum();
            target += sum;
            if (target < 0 || target % 2 == 1) {
                return 0;
            }
            int capacity = target /= 2;
            int n = nums.length;
            int[][] f = new int[n + 1][capacity + 1];
            f[0][0] = 1;
            for (int i = 0; i < n; ++i) {
                for (int c = 0; c <= capacity; ++c) {
                    if (c < nums[i]) {
                        f[i + 1][c] = f[i][c];
                    } else {
                        f[i + 1][c] = f[i][c] + f[i][c - nums[i]];
                    }
                }
            }
            return f[n][capacity];
        }
    }

    class Solution1 {
        // 正数和p，负数和s-p,
        // p - (s-p) = t
        // p = (s+t)/2

        private int[] nums;
        private int[][] cache;

        // 滚动数组, 交换数组 or i%2
        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for (int x : nums) {
                sum += x;
            }
            target += sum; // s+t
            if (target < 0 || target % 2 == 1) { // 不能
                return 0;
            }
            target /= 2; //(s+t)/2
            int n = nums.length;
            cache = new int[2][target + 1]; // i%2, 两行滚动使用
            cache[0][0] = 1;
            for (int i = 0; i < n; ++i) { // 枚举nums
                for (int c = 0; c <= target; ++c) {
                    if (nums[i] > c) {
                        cache[(i + 1) % 2][c] = cache[i % 2][c];
                    } else {
                        cache[(i + 1) % 2][c] = cache[i % 2][c] + cache[i % 2][c - nums[i]];
                    }
                }
            }
            return cache[n % 2][target];
        }

        private void swap(int[] a, int[] b) {
            if (a.length != b.length) {
                return;
            }
            for (int i = 0; i < a.length; i++) {
//                a[i] = a[i] ^ b[i];
//                b[i] = a[i] ^ b[i];
//                a[i] = a[i] ^ b[i];
                a[i] ^= b[i];
                b[i] ^= a[i];
                a[i] ^= b[i];
            }
        }

        // 递推
        // f[i][c] = f[i-1][c] + f[i-1][c-nums[i]], i:-1~n-1, c:0~target,让i加一位0~n
        // f[i+1][c] = f[i][c] + f[i][c-nums[i]] , i:0~n-1
        public int findTargetSumWays2(int[] nums, int target) {
            int sum = 0;
            for (int x : nums) {
                sum += x;
            }
            target += sum; // s+t
            if (target < 0 || target % 2 == 1) { // 不能
                return 0;
            }
            target /= 2; //(s+t)/2

            int n = nums.length;
            this.cache = new int[n + 1][target + 1]; // 0~n, 0~target

            cache[0][0] = 1; // i=0其他情况为0

            for (int i = 0; i < n; ++i) { // 枚举nums
                for (int c = 0; c <= target; ++c) {
                    if (nums[i] > c) {
                        cache[i + 1][c] = cache[i][c];
                    } else {
                        cache[i + 1][c] = cache[i][c] + cache[i][c - nums[i]];
                    }
                }
            }
            return cache[n][target];
        }

        // 时间O(N*(s+t))
        public int findTargetSumWays1(int[] nums, int target) {
            int sum = 0;
            for (int x : nums) {
                sum += x;
            }
            target += sum; // s+t
            if (target < 0 || target % 2 == 1) { // 不能
                return 0;
            }
            target /= 2; //(s+t)/2

            int n = nums.length;
            this.nums = nums;
            return dfs(n - 1, target);
        }

        // -1~n-1, 0~target
        private int dfs(int i, int c) {
            if (i < 0) {
                if (c == 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
            if (c < nums[i]) { // 不能选当前数
                return dfs(i - 1, c);
            }
            return dfs(i - 1, c) + dfs(i - 1, c - nums[i]); // 选或不选
        }

    }
// leetcode submit region end(Prohibit modification and deletion)

}