package com.csp;

import java.io.*;

// 从标准输入读入数据。
// 输出到标准输出中。
public class Code20230901 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        PrintWriter consoleOut = new PrintWriter(System.out); //注释
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int) in.nval;
            in.nextToken();
            int m = (int) in.nval;
            int[] op = new int[2];
            int[][] coordinate = new int[m][2];
            for (int i = 0; i < n; ++i) { // n行操作 dx dy
                in.nextToken();
                op[0] += (int) in.nval;
                in.nextToken();
                op[1] += (int) in.nval;
            }
            for (int i = 0; i < m; ++i) { // m行坐标 x y
                in.nextToken();
                coordinate[i][0] = (int) in.nval;
                in.nextToken();
                coordinate[i][1] = (int) in.nval;
            }
            transformationOfCoordinates(op, coordinate);
            // 输出m行结果
            for (int i = 0; i < m; ++i) {
                out.println(coordinate[i][0] + " " + coordinate[i][1]);
                consoleOut.println(coordinate[i][0] + " " + coordinate[i][1]); //注释
            }
            consoleOut.flush(); //注释
        }
        out.flush();
        br.close();
        out.close();
    }

    static void transformationOfCoordinates(int[] op, int[][] coordinate) {
        int m = coordinate.length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < 2; ++j) {
                coordinate[i][j] += op[j];
            }
        }
    }
}
