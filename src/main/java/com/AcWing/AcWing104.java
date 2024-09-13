package com.AcWing;

import java.io.*;
import java.util.Arrays;

// 货舱选址（中位数贪心）
// AC
public class AcWing104 {
    // public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     StreamTokenizer in = new StreamTokenizer(br);
    //     PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    //     PrintWriter consoleOut = new PrintWriter(System.out); // PrintWriter for console output
    //     while (in.nextToken() != StreamTokenizer.TT_EOF) {
    //         int n = (int) in.nval;
    //         int[] a = new int[n];
    //         for (int i = 0; i < n; i++) {
    //             in.nextToken();
    //             a[i] = (int) in.nval;
    //         }
    //         int ans = solution104(a);
    //         out.println(ans);
    //         consoleOut.println(ans);
    //         consoleOut.flush();
    //     }
    //     out.flush(); // 把答案提交
    //     br.close();
    //     out.close();
    // }

    public static void main(String[] args) {
        // 6 2 9 1
        int[] nums = {6, 2, 9, 1};
        System.out.println(solution104(nums));
    }

    private static int solution104(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] pre = new int[n + 1]; // 前缀和 pre[i+1] 0..i
        for (int i = 0; i < n; ++i) {
            pre[i + 1] = pre[i] + nums[i];
        }
        // 中位数 n/2 可以选择[n/2, n/2+1]
        // 前缀和pre[n/2]
        // pre[n] - pre[n/2]
        int left = nums[n / 2] * (n / 2) - pre[n / 2];
        int right = pre[n] - pre[n / 2] - nums[n / 2] * ((n - 1) / 2 + 1);
        return left + right;
    }
}
