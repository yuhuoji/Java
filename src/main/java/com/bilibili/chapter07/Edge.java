package com.bilibili.chapter07;

/**
 * @date 2022-11-03 10:48
 * 图的边
 */
class Edge {
    public int weight; //边的权值
    public Node from; //边的出点
    public Node to; //边的入点

    public Edge() {
        this.weight = 0;
        this.from = null;
        this.to = null;
    }

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
