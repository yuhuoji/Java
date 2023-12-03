package com.csp;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

//AC
public class Code20230501 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String line = in.readLine();
        Map<String, Integer> mp = new HashMap<>();
        int n = Integer.parseInt(line);
        for (int i = 0; i < n; ++i) { // n组
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 8; ++j) { // 8行
                sb.append(in.readLine());
            }
            mp.put(sb.toString(), mp.getOrDefault(sb.toString(), 0) + 1);
            out.println(mp.get(sb.toString()));
        }
        out.flush();
        in.close();
        out.close();
    }
}
