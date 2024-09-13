package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 740 删除并获得点数
public class LC740DeleteAndEarn {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 740);
        Solution solution = new LC740DeleteAndEarn().new Solution();

    }


    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // f[i] 在去重数组0..i偷
        // f[i]=max(f[i-2]+arr[i]*cnt[arr[i]],f[i-1])
        // arr[i] - last > 1, 则不相邻f[i]=f[i-1]+arr[i]*cnt[arr[i]]
        // 返回f[n-1]
        // f[i+2]=max(f[i]+arr[i]*cnt[arr[i]],f[i+1])
        // arr[i] - last > 1, 则不相邻f[i+2]=f[i+1]+arr[i]*cnt[arr[i]]
        // f[-]=0
        public int deleteAndEarn(int[] nums) {
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
            int last = -1;
            int[] f = new int[n + 2];
            for (int i = 0; i < arr.size(); ++i) {
                if (arr.get(i) - last == 1) {
                    f[i + 2] = Math.max(f[i] + arr.get(i) * cnt.get(arr.get(i)), f[i + 1]);
                } else {
                    f[i + 2] = f[i + 1] + arr.get(i) * cnt.get(arr.get(i));
                }
                last = arr.get(i);
            }
            return f[n + 1];
        }

        // 排序+分组循环收集次数，再在0..MAX上dp
        // f[i] 0..i收集的，>i已经收集完
        // f[i]=max(f[i-2]+cnt*i,f[i-1])
        // 选i， =f[i-2]+cnt*i
        // 不选i,=f[i-1]
        // f[0]=0
        // 返回f[MAX] or f[10^4]
        // 增加两位 f[i+2]=max(f[i]+cnt*i,f[i+1])
        public int deleteAndEarn1(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            int mx = Arrays.stream(nums).max().getAsInt(); // 最大值
            int[] cnt = new int[mx + 1];
            int i = 0;
            while (i < n) {
                int start = i, num = nums[i];
                while (i < n && nums[i] == num) {
                    i++;
                }
                cnt[num] = i - start;
            }
            int[] f = new int[mx + 3];
            for (int num = 0; num <= mx; ++num) {
                f[num + 2] = Math.max(f[num] + cnt[num] * num, f[num + 1]);
            }
            return f[mx + 2];
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}