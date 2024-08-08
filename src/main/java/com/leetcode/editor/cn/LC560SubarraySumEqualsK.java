package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.HashMap;
import java.util.Map;

// 560 Subarray Sum Equals K
public class LC560SubarraySumEqualsK {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 560);
        Solution solution = new LC560SubarraySumEqualsK().new Solution();

    }
    //子数组 前缀和
    // 用哈希快速查询
    // sum[i,j] = pre[j]-pre[i-1];
    // pre左侧加一位0
    // sum[i,j] = pre[j+1]-pre[i];
    // [0,j]的和为sum，只需要找有没有sum-k即可
    // 如果k=0，先更新哈希表会查到sum

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int n = nums.length;
            int sum = 0;
            int ans = 0;
            Map<Integer, Integer> mp = new HashMap<>();
            mp.put(0, 1); //!和为0的前缀有一个
            for (int i = 0; i < n; ++i) {
                sum += nums[i];
                ans += mp.getOrDefault(sum - k, 0);
                mp.merge(sum, 1, Integer::sum);
            }
            return ans;
        }

        public int subarraySum1(int[] nums, int k) {
            int n = nums.length;
            int ans = 0;
            int sum = 0; //[0..i]的前缀和
            Map<Integer, Integer> mp = new HashMap<>(); // 和-次数
            mp.put(0, 1); // 和为0的前缀有一个
            for (int num : nums) {
                sum += num;
                if (mp.containsKey(sum - k)) {
                    ans += mp.get(sum - k);
                }
                mp.put(sum, mp.getOrDefault(sum, 0) + 1);// 加入当前前缀和
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}