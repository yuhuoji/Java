package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 3186 施咒的最大总伤害
public class LC3186MaximumTotalDamageWithSpellCasting {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 3186);
        Solution solution = new LC3186MaximumTotalDamageWithSpellCasting().new Solution();

    }

    // lc740
    // 扩展 选了x则[x-k,x+k]都不能选
    // REVIEW @date 2024-07-11 值域打家劫舍
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // f[i]在去重数组arr 0..i 上
        // f[i] = max(f[i-1],f[j-1]+arr[i]*cnt[arr[i]]), j是最小的arr[j]>=arr[i]-2
        // f[i+1] = max(f[i],f[j]+arr[i]*cnt[arr[i]]), j是最小的arr[j]>=arr[i]-2
        // 返回f[n-1]

        // ！找到j, 其中j是最小的arr[j]>=arr[i]-2， 可以用双指针
        // f数组加1
        public long maximumTotalDamage(int[] nums) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int x : nums) {
                // cnt.put(x, cnt.getOrDefault(x, 0) + 1);
                cnt.merge(x, 1, Integer::sum); //!merge方法
            }
            int[] arr = Arrays.stream(nums)    // 创建一个 IntStream
                    .distinct()       // 去重
                    .sorted()         // 排序
                    .toArray();       // 转回 int[]
            int n = cnt.size();
            long[] f = new long[n + 1];
           int k = 2; //
            for (int i = 0, j = 0; i < n; ++i) {
                int x = arr[i];
                while (arr[j] < x - k) {
                    j++;
                }
                f[i + 1] = Math.max(f[i], f[j] + (long) x * cnt.get(x));
            }
            return f[n];
        }

        public long maximumTotalDamage1(int[] power) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int x : power) {
                cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            }
            int[] nums = Arrays.stream(power)    // 创建一个 IntStream
                    .distinct()       // 去重
                    .sorted()         // 排序
                    .toArray();       // 转回 int[]

            int n = nums.length;
            int last = -3;
            int[] f = new int[n + 3];
            for (int i = 0; i < n; ++i) {
                if (nums[i] - last <= 2) {
                    f[i + 3] = Math.max(f[i + 1] + nums[i] * cnt.get(nums[i]), f[i + 2]);
                } else {
                    f[i + 3] = f[i + 2] + nums[i] * cnt.get(nums[i]);
                }
                last = nums[i];
            }
            return f[n + 2];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}