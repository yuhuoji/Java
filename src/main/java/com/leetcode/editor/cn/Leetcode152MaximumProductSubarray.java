package com.leetcode.editor.cn;

public class Leetcode152MaximumProductSubarray {
    //relate to 53
    public static void main(String[] args) {
        System.out.println("Leetcode " + 152);
        Solution solution = new Leetcode152MaximumProductSubarray().new Solution();

        int[] nums = {2, 3, -2, 4};
        System.out.println(solution.maxProduct(nums));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //以i结尾
        //f[i] = max{f[i-1]*nums[i], nums[i]} 不满足最优子结构
        //需要考虑nums[i]<0
        // 维护fmax[i], fmin[i]
        // fmax[i] = max{fmax[i-1]*nums[i], fmin[i-1]*nums[i], nums[i]}

        //TODO @date 2023-11-04 空间压缩
        public int maxProduct(int[] nums) {
            int n = nums.length;
            int[] maxF = new int[n];
            int[] minF = new int[n];
            maxF[0] = nums[0];
            minF[0] = nums[0];

            for (int i = 1; i < n; i++) {
                maxF[i] = Math.max(Math.max(maxF[i - 1] * nums[i], minF[i - 1] * nums[i]), nums[i]);
                minF[i] = Math.min(Math.min(maxF[i - 1] * nums[i], minF[i - 1] * nums[i]), nums[i]);
            }

            int ans = maxF[0];
            for (int i = 1; i < n; i++) {
                ans = Math.max(ans, maxF[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}