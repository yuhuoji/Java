package com.bilibilizuo.chapter059;

import java.util.ArrayList;
import java.util.List;

public class CodeCreateGraph {
    //TODO @date 2023-11-12 链式前向星
    int[][] unWeightedGraph; // 邻接矩阵 带权
    // List<List<int[]>> weightedGraph; //邻接表
    List<int[]>[] graph; // 邻接表 带权

    public static void main(String[] args) {
        System.out.println("CreateGraph");
        int n = 10; // 点的数量 默认点从0开始，从一开始则n+1，1弃而不用

    }

    // 有向图
    // 无向图
    void directGraph(int n, int[][] edges) {
        unWeightedGraph = new int[n][n];
        for (int[] e : edges) {
            int x = e[0], y = e[1], w = e[2];
            unWeightedGraph[x][y] = w;
            unWeightedGraph[y][x] = w;
        }
        graph = new ArrayList[n];
        for (int[] e : edges) {
            int x = e[0], y = e[1], w = e[2]; // x-w->y
            graph[x].add(new int[]{y, w});
            graph[y].add(new int[]{x, w});
        }
    }


}
