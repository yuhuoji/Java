package com.leetcode.editor.cn;

import com.leetcode.helper.LeetCodeHelper;

public class LC152MaximumProductSubarray {
    // relate to 53
    public static void main(String[] args) {
        System.out.println("LC " + 152);
        Solution solution = new LC152MaximumProductSubarray().new Solution();

        String s = "[0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0]";
        System.out.println(solution.maxProduct(LeetCodeHelper.stringToIntegerArray(s)));

    }

    // REVIEW @date 2024-07-11
    // x=nums[i]
    // 从lc53 f[i]=max(f[i-1]*x,x)
    // 不满足「最优子结构」,当前位置的最优解未必是由前一个位置的最优解转移得到的
    // f[i]以i结尾的最大乘积
    // fmax[i] = max(fmax[i-1]*x,fmin[i-1]*x,x)
    // fmin[i] = min(fmax[i-1]*x,fmin[i-1]*x,x)
    // 同时维护最大和最小 maxF minF

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxProduct3(int[] nums) {
            int n = nums.length;
            double maxP = 1, minP = 1;
            double ans = nums[0];
            for (int i = 0; i < n; ++i) {
                int x = nums[i];
                double newMaxP = Math.max(Math.max(maxP * x, minP * x), x);
                double newMinP = Math.min(Math.min(maxP * x, minP * x), x);
                maxP = newMaxP;
                minP = newMinP;
                ans = Math.max(ans, maxP);
            }
            return (int) ans;
        }

        //[0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0]
        // 测试用例可用double，和double存储方式有关
        public int maxProduct(int[] nums) {
            int n = nums.length;
            double[] maxF = new double[n], minF = new double[n];
            maxF[0] = nums[0];
            minF[0] = nums[0];
            double ans = nums[0];
            for (int i = 1; i < n; ++i) {
                int x = nums[i];
                maxF[i] = Math.max(Math.max(maxF[i - 1] * x, minF[i - 1] * x), x);
                minF[i] = Math.min(Math.min(maxF[i - 1] * x, minF[i - 1] * x), x);
                ans = Math.max(ans, maxF[i]);
            }
            return (int) ans;
        }


        // 以i结尾
        // f[i] = max{f[i-1]*nums[i], nums[i]} 不满足最优子结构
        // 需要考虑nums[i]<0
        // 维护fmax[i], fmin[i]
        // fmax[i] = max{fmax[i-1]*nums[i], fmin[i-1]*nums[i], nums[i]}
        public int maxProduct1(int[] nums) {
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
// leetcode submit region end(Prohibit modification and deletion)

}