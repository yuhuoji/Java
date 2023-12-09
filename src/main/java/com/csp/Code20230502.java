package com.csp;

import java.io.*;

// TODO @date 2023-12-02
// (W⋅(Q×KT))×V
// 1*n n*d d*n n*d = n*d
// 矩阵计算顺序
public class Code20230502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        PrintWriter consoleOut = new PrintWriter(System.out, true); // 注释
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int) in.nval;
            in.nextToken();
            int d = (int) in.nval;
            in.nextToken();
            // n 行 d 列
            int[][] Q = new int[n][d];
            int[][] K = new int[n][d];
            int[][] V = new int[n][d];
            int[] W = new int[n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < d; ++j) {
                    Q[i][j] = (int) in.nval;
                    in.nextToken();
                }
            }
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < d; ++j) {
                    K[i][j] = (int) in.nval;
                    in.nextToken();
                }
            }
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < d; ++j) {
                    V[i][j] = (int) in.nval;
                    in.nextToken();
                }
            }
            for (int i = 0; i < n; ++i) {
                W[i] = (int) in.nval;
                in.nextToken();
            }
            // 计算 (W⋅(Q×KT))×V
            long[][] tmp = new long[d][d];
            long[][] ans = new long[n][n];
            // KT*V = tmp
            for (int i = 0; i < d; ++i) {
                for (int j = 0; j < d; ++j) { // KT x V
                    for (int k = 0; k < d; ++k) {
                        tmp[i][j] += (long) K[k][i] * V[k][j];
                    }
                }
            }
            // Q * tmp = ans
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < d; ++j) {
                    for (int k = 0; k < d; ++k) {
                        ans[i][j] += Q[i][k] * tmp[k][j];
                    }
                    ans[i][j] *= W[i];
                }
            }
            // 答案
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < d; ++j) {
                    out.println(ans[i][j] + " ");
                    consoleOut.println(ans[i][j] + " "); // 注释
                }
                out.println();
                consoleOut.println(); // 注释
            }
        }
        out.flush();
        br.close();
        out.close();
    }
}
