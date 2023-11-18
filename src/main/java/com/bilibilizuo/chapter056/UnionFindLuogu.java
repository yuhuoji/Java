package com.bilibilizuo.chapter056;

import java.io.*;

// 并查集模版(洛谷)
// 本实现用递归函数实现路径压缩(扁平化)，而且省掉了小挂大的优化(一般情况下可以省略)
// 测试链接 : https://www.luogu.com.cn/problem/P3367
//REVIEW @date 2023-11-18
public class UnionFindLuogu {
    public static int MAXN = 10001;

    public static int[] father = new int[MAXN];

    public static int n; // 开始时集合的数量

    public static void build() {
        for (int i = 0; i <= n; ++i) { // 0..n
            father[i] = i;
        }
    }

    //！！！递归实现路径压缩
    public static int find(int i) {
        if (i != father[i]) {
            father[i] = find(father[i]);
        }
        return father[i]; // 代表节点自己指向自己
    }

    public static boolean isSameSet(int x, int y) {
        return find(x) == find(y);
    }

    public static void union(int x, int y) {
        father[find(x)] = find(y); // x代表 -> y代表
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            build();
            in.nextToken();
            int m = (int) in.nval;
            for (int i = 0; i < m; ++i) {
                in.nextToken();
                int z = (int) in.nval;
                in.nextToken();
                int x = (int) in.nval;
                in.nextToken();
                int y = (int) in.nval;
                if (z == 1) {
                    union(x, y);
                } else {
                    out.println(isSameSet(x, y) ? "Y" : "N");
                }
            }
        }
        out.flush();
        out.close();
        br.close();
    }

}
