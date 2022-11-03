package com.bilibili.chapter07;

import java.util.ArrayList;

/**
 * @date 2022-11-03 10:41
 * 图的节点
 */
class Node {
    public int value; //节点权值
    public int in; //入度
    public int out; //出度
    public ArrayList<Node> nexts; //当前节点指向的节点
    public ArrayList<Edge> edges; // FIXME 从当前节点出发的边

    public Node() {
        this.value = 0;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public Node(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public Node(int value, int in, int out) {
        this.value = value;
        this.in = in;
        this.out = out;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}
