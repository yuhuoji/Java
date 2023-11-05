package com.leetcode.contest;


public class Leetcode370 {
    //TODO @date 2023-11-05
    public static void main(String[] args) {
        System.out.println("Leetcode ");
        Leetcode370 solution = new Leetcode370();

        int[] nums = {3,3,5,6};
        System.out.println(solution.maxBalancedSubsequenceSum(nums));
    }

    //子序列
    //以i结尾的平衡子序列的最大和dp[j] = max{dp[i], dp[i] + nums[i]}
    //Hidden for this testcase during contest.
    public long maxBalancedSubsequenceSum(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        long maxSum = Integer.MIN_VALUE / 2;

        for (int j = 0; j < n; j++) { //枚举结束位置
            dp[j] = nums[j];
            int pre = Integer.MIN_VALUE / 2; //最大子序列和
            for (int i = j - 1; i >= 0; i--) {
                if (nums[j] - nums[i] >= j - i) { //是平衡子序列
                    pre = Math.max(pre, dp[i]);
                }
            }
            dp[j] = Math.max(dp[j], dp[j]+pre);
            maxSum = Math.max(maxSum, dp[j]); //计算最大值
        }

        return maxSum == Integer.MIN_VALUE / 2 ? -1 : maxSum;
    }

    //树型dp
    //无向树
    //isHealthy
    //从前i个选f[i] = max{f[i-1], f[i-1] + values[i]}, on isHealthy
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        int n = values.length;
        int score = 0;

        //建树


        return score;
    }

    //Q2
    public int findChampion2(int n, int[][] edges) {
        int m = edges.length;
        int[] win = new int[n]; //1 for win, 0 for lose
        for (int i = 0; i < n; i++) {
            win[i] = 1;
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            //x->y
            win[y] = 0;
        }

        int cnt = 0;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (win[i] == 1) {
                ans = i;
                cnt++;
            }
        }
        if (cnt == 1) {
            return ans;
        } else {
            return -1;
        }
    }

    //Q1
    public int findChampion(int[][] grid) {
        int n = grid.length;
        int[] win = new int[n]; //0 for win, 1 for lose
        for (int i = 0; i < n; i++) {
            win[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    win[j] = 1;
                }
            }
        }

        int cnt = 0;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (win[i] == 0) {
                ans = i;
                cnt++;
            }
        }
        if (cnt == 1) {
            return ans;
        } else {
            return -1;
        }
    }
}
