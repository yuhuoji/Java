package com.leetcode.editor.cn;

public class LC416PartitionEqualSubsetSum {
    public static void main(String[] args) {
        System.out.println("LC " + 416);
        Solution solution = new LC416PartitionEqualSubsetSum().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //背包
        //选或不选
        //选
        //TODO @date 2023-11-05 空间压缩
        private int[][] cache;

        public boolean canPartition(int[] nums) {
            int n = nums.length;
            int sum = 0;
            for (int x : nums) {
                sum += x;
            }
            //s = sum-s, s = sum/2
            if (sum % 2 != 0) {
                return false;
            }
            sum /= 2; //选sum/2
            this.cache = new int[n + 1][sum + 1];
            //f[i][c] = f[i-1][c-nums[i]], f[i-1][c]
            //f[i+1][c] = f[i][c-nums[i]]& f[i][c]
            //0 for illegal, 1 for legal
            cache[0][0] = 1;// i<0&&c==0 合法，其他不合法

            for (int i = 0; i < n; ++i) {
                for (int c = 0; c <= sum; ++c) {
                    if (nums[i] > c) { //不能选
                        cache[i + 1][c] = cache[i][c];
                    } else {//可以选
                        cache[i + 1][c] = cache[i][c - nums[i]] | cache[i][c]; //只要有一个合法
                    }
                }
            }

            return cache[n - 1][sum] == 1; //true
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}