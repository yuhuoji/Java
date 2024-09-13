package com.leetcode.editor.cn;

public class LC198HouseRobber {
    public static void main(String[] args) {
        System.out.println("LC " + 198);
        Solution solution = new LC198HouseRobber().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // f[i] f[i+2] 0..i位置能得到的金额
        // f[i]=max{f[i-1],f[i-2]+nums[i]}
        // f增加两位 f[i+2]=max{f[i+1],f[i]+nums[i]}
        // f[<0]=0 f[0]f[1] = 0
        // 返回f[n-1] f[n+1]
        public int rob(int[] nums) {
            int n = nums.length;
            int[] f = new int[n + 2];
            for (int i = 0; i < n ; ++i) {
                f[i + 2] = Math.max(f[i + 1], f[i] + nums[i]);
            }
            return f[n + 1];
        }

        // 空间压缩
        public int rob2(int[] nums) {
            int n = nums.length;
            int f0 = 0, f1 = 0; // 记录两个状态
            for (int i = 0; i < n; i++) {
                int newF = Math.max(f1, f0 + nums[i]);
                f0 = f1;
                f1 = newF;
            }
            return f1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}