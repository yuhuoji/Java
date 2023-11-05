package com.leetcode.editor.cn;

public class Leetcode198HouseRobber {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 198);
        Solution solution = new Leetcode198HouseRobber().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //空间压缩
        public int rob(int[] nums) {
            int n = nums.length;
            int f0 = 0, f1 = 0; //记录两个状态
            for (int i = 0; i < n; i++) {
                int newF = Math.max(f1, f0 + nums[i]);
                f0 = f1;
                f1 = newF;
            }
            return f1;
        }


        //最多隔一个偷一个
        //f[i] = max{f[i-1], f[i-2]+nums[i]}
        //加两位 f[i+2] = max{f[i+1], f[i]+nums[i]}
        public int rob1(int[] nums) {
            int n = nums.length;
            int[] f = new int[n + 2]; //0~n+1
            for (int i = 0; i < n; i++) {
                f[i + 2] = Math.max(f[i + 1], f[i] + nums[i]);
            }
            return f[n + 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}