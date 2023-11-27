package com.csp;

import java.io.*;

// 直接模拟 80分
// 极坐标+前缀和
// 1k (x,y) -> (kx,ky)
// 2theta (x,y) -> ()
// i j x y : (x,y)经过 i..j的操作
public class Code20230902 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        // PrintWriter consoleOut = new PrintWriter(System.out); // 注释
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int) in.nval;
            in.nextToken();
            int m = (int) in.nval;
            double[] dArc = new double[n + 1]; // 弧长的伸缩量的前缀和, 用1..n
            dArc[0] = 1; //
            double[] dRad = new double[n + 1]; // 弧度的伸缩量的前缀和, 用1..n
            for (int i = 1; i <= n; ++i) { // n行操作计算前缀和 1k 2theta
                in.nextToken();
                int type = (int) in.nval;
                in.nextToken();
                double delta = (double) in.nval;
                if (type == 1) { // 弧长
                    dArc[i] = dArc[i - 1] * delta;
                    dRad[i] = dRad[i - 1];
                } else { // 弧度
                    dArc[i] = dArc[i - 1];
                    dRad[i] = dRad[i - 1] + delta;
                }
            }

            double x, y, r, theta;
            for (int k = 0; k < m; ++k) { // m行查询 i j x y
                in.nextToken();
                int i = (int) in.nval;
                in.nextToken();
                int j = (int) in.nval;
                in.nextToken();
                x = (double) in.nval;
                in.nextToken();
                y = (double) in.nval;
                // Cartesian-》polar
                r = Math.sqrt(x * x + y * y);
                theta = Math.atan2(y, x);
                // 用前缀和计算
                r *= dArc[j] / dArc[i - 1];
                theta += dRad[j] - dRad[i - 1];
                // polar -》 Cartesian
                x = r * Math.cos(theta);
                y = r * Math.sin(theta);
                out.println(x + " " + y);
                // consoleOut.println(x + " " + y); // 注释
            }
            // consoleOut.flush(); // 注释
        }
        out.flush();
        br.close();
        out.close();
    }

}
