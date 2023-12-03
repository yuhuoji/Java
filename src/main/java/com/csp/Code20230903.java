package com.csp;

import java.io.*;
//TODO @date 2023-12-02
// 梯度求解
public class Code20230903 {
    private static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int) in.nval; // 自变量的个数和
            in.nextToken();
            int m = (int) in.nval; // 要求解的偏导数的个数
            // 逆波兰式

            // m行 3..m+2
            for (int i = 3; i <= m + 2; ++i) {
                // 每行 n+1
                in.nextToken();
                int x = (int) in.nval; // xi
            }
        }
        out.flush();
        br.close();
        out.close();
    }
}
