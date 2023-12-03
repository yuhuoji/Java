package com.bilibilizuo.chapter019InputAndOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

// 测试链接 : https://www.nowcoder.com/exam/test/70070648/detail?pid=27976983
// 按行读入
public class CodeReadByLine {
    public static String line;
    public static String[] parts;
    public static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while ((line = in.readLine()) != null) {
            parts = line.split(" ");
            sum = 0;
            for (String num : parts) {
                sum += Integer.valueOf(num);
            }
            out.println(sum);
        }
        out.flush();
        in.close();
    }
}
