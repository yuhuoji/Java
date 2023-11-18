package com.bilibilizuo.chapter019InputAndOutput;

import java.io.*;

/*
链接：https://www.nowcoder.com/questionTerminal/cb82a97dcd0d48a7b1f4ee917e2c0409
给定一个矩阵matrix，其中的值有正、有负、有0，返回子矩阵的最大累加和
例如，矩阵matrix为：
-90 48 78
64 -40 64
-81 - 7 66
其中，最大的累加和的子矩阵为：
48 78
-40 64
-7 66
所以返回累加和209。
例如，matrix为：
-1 -1 -1
-1 2 2
-1 -1 -1
其中，最大累加和的子矩阵为：
2 2
所以返回4
[要求]O(n^2m)，空间复杂度为O(nm)
输入
3 3
-90 48 78
64 -40 64
-81 -7 66
输出
209
备注:1⩽N,M⩽200; −100⩽arri,j⩽100
*/
public class ACMInputAndOutput {
    // REVIEW @date 2023-11-14 重要！ACM风格的输入和输出
    // 在线io读写数据方法
    public static void main(String[] args) throws IOException {
        // 把文件读取到内存中
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 一个一个读取数字，自动忽略空格和回车，不区分空格和回车
        StreamTokenizer in = new StreamTokenizer(br);
        // 提交答案用的内存托管区
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        PrintWriter consoleOut = new PrintWriter(System.out); // PrintWriter for console output
        while (in.nextToken() != StreamTokenizer.TT_EOF) { // 文件没有结束就继续
            // n，二维数组的行
            int n = (int) in.nval; // in.nval可以读出任何类型的数据
            in.nextToken();
            // m，二维数组的列
            int m = (int) in.nval;
            // 装数字的矩阵，临时动态生成
            int[][] mat = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    in.nextToken();
                    mat[i][j] = (int) in.nval;
                }
            }
            int ans = maxSumSubmatrix(mat, n, m);
            out.println(ans);
            consoleOut.println(ans);
            consoleOut.flush();
        }
        out.flush(); // 把答案提交
        br.close();
        out.close();
    }

    // 求子矩阵的最大累加和，后面的课会讲
    public static int maxSumSubmatrix(int[][] mat, int n, int m) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // 需要的辅助数组，临时动态生成
            int[] arr = new int[m];
            for (int j = i; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    arr[k] += mat[j][k];
                }
                max = Math.max(max, maxSumSubarray(arr, m));
            }
        }
        return max;
    }

    // 求子数组的最大累加和，后面的课会讲
    public static int maxSumSubarray(int[] arr, int m) {
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < m; i++) {
            cur += arr[i];
            max = Math.max(max, cur);
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }
}
