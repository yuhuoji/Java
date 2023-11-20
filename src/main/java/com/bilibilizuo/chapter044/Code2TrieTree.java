package com.bilibilizuo.chapter044;

import java.io.*;
import java.util.*;

// REVIEW @date 2023-11-20 按行读入
// 静态数组实现前缀树
// 测试链接 : https://www.nowcoder.com/practice/7f8a8553ddbf4eaab749ec988726702b
public class Code2TrieTree {
    // 需要提前预估数量
    public static final int MAXN = 150001;
    public static int[][] tree = new int[MAXN][26]; // 路 : 0..25 a..z
    public static int[] end = new int[MAXN];
    public static int[] pass = new int[MAXN];
    public static int cnt; // 当前分配到的位置
    public static String[] splits;

    public static void build() {
        cnt = 1;  // 0作为空，1作为根节点，记录分配到的位置
    }

    public static void insert(String word) {
        int cur = 1;
        pass[cur]++;
        for (int i = 0, path; i < word.length(); i++) {
            path = word.charAt(i) - 'a';
            if (tree[cur][path] == 0) {
                tree[cur][path] = ++cnt;  //分配cnt+1
            }
            cur = tree[cur][path];
            pass[cur]++;
        }
        end[cur]++;
    }

    public static int search(String word) {
        int cur = 1;
        for (int i = 0, path; i < word.length(); i++) {
            path = word.charAt(i) - 'a';
            if (tree[cur][path] == 0) {
                return 0;
            }
            cur = tree[cur][path];
        }
        return end[cur];
    }

    public static int prefixNumber(String pre) {
        int cur = 1;
        for (int i = 0, path; i < pre.length(); i++) {
            path = pre.charAt(i) - 'a';
            if (tree[cur][path] == 0) {
                return 0;
            }
            cur = tree[cur][path];
        }
        return pass[cur];
    }

    public static void delete(String word) {
        if (search(word) > 0) {
            int cur = 1;
            for (int i = 0, path; i < word.length(); i++) {
                path = word.charAt(i) - 'a';
                if (--pass[tree[cur][path]] == 0) {
                    tree[cur][path] = 0;
                    return;
                }
                cur = tree[cur][path];
            }
            end[cur]--;
        }
    }

    // 将使用过的位置刷为0，防止影响下一组数据
    public static void clear() {
        for (int i = 1; i <= cnt; i++) {
            Arrays.fill(tree[i], 0);
            end[i] = 0;
            pass[i] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String line = null;
        int m, op;
        while ((line = in.readLine()) != null) { // 按行读入
            build(); //
            m = Integer.valueOf(line); // m次操作
            for (int i = 1; i <= m; i++) {
                splits = in.readLine().split(" "); //
                op = Integer.valueOf(splits[0]); // 操作数
                if (op == 1) {
                    insert(splits[1]);
                } else if (op == 2) {
                    delete(splits[1]);
                } else if (op == 3) {
                    out.println(search(splits[1]) > 0 ? "YES" : "NO");
                } else if (op == 4) {
                    out.println(prefixNumber(splits[1]));
                }
            }
            clear(); // 清空
        }
        out.flush();
        in.close();
        out.close();
    }
}
