package com.bilibilizuo.chapter056;

import java.io.*;

// 并查集模版(牛客)
// 两点优化: 路径压缩(扁平化) + 小挂大
// 测试链接 : https://www.nowcoder.com/practice/e7ed657974934a30b2010046536a5372
public class CodeUnionFindNowcoder {
    public static int MAXN = 1000001;

    public static int[] father = new int[MAXN];

    public static int[] size = new int[MAXN]; //每个集合大小，只用代表元素的位置，用于小挂大

    public static int[] stack = new int[MAXN]; // 记录路径，用于压缩

    public static int n;

    // 初始化，每个元素自己指向自己，单独一个集合
    public static void build() {
        for (int i = 0; i <= n; i++) {  //0..n
            father[i] = i;
            size[i] = 1;
        }
    }

    // i号节点，往上一直找，找到代表节点返回！
    public static int find(int i) {
        // 沿途收集了几个点
        int size = 0;
        while (i != father[i]) {
            stack[size++] = i;
            i = father[i];
        }
        // 沿途节点收集好了，i已经跳到代表节点了
        while (size > 0) {
            father[stack[--size]] = i;
        }
        return i;
    }

    public static boolean isSameSet(int x, int y) {
        return find(x) == find(y);
    }

    public static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy) {
            // fx是集合的代表：拿大小
            // fy是集合的代表：拿大小
            if (size[fx] >= size[fy]) {
                size[fx] += size[fy];
                father[fy] = fx;
            } else {
                size[fy] += size[fx];
                father[fx] = fy;
            }
        }
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
            for (int i = 0; i < m; i++) {
                in.nextToken();
                int op = (int) in.nval;
                in.nextToken();
                int x = (int) in.nval;
                in.nextToken();
                int y = (int) in.nval;
                if (op == 1) {
                    out.println(isSameSet(x, y) ? "Yes" : "No");
                } else {
                    union(x, y);
                }
            }
        }
        out.flush();
        out.close();
        br.close();
    }
}
