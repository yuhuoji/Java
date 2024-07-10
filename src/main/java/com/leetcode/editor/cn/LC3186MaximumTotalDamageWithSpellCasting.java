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
// TODO @date 2024-07-10
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // f[i]=max(f[i-3]+arr[i]*cnt[arr[i]],f[i-1])
        public long maximumTotalDamage(int[] nums) {
            Arrays.sort(nums);
            Map<Integer, Integer> cnt = new HashMap<>();
            // int[] arr = Arrays.stream(nums)    // 创建一个 IntStream
            //         .distinct()       // 去重
            //         .sorted()         // 排序
            //         .toArray();       // 转回 int[]
            List<Integer> arr = new ArrayList<>();
            for (int x : nums) {
                cnt.put(x, cnt.getOrDefault(x, 0) + 1);
                if (cnt.get(x) == 1) {
                    arr.add(x);
                }
            }
            int n = arr.size();
            int last = -2;
            int[] f = new int[n + 3];
            for (int i = 0; i < arr.size(); ++i) {
                if (arr.get(i) - last <= 2) {
                    f[i + 3] = Math.max(f[i + 1] + arr.get(i) * cnt.get(arr.get(i)), f[i + 2]);
                } else {
                    f[i + 3] = f[i + 2] + arr.get(i) * cnt.get(arr.get(i));
                }
                last = arr.get(i);
            }
            return f[n + 2];
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