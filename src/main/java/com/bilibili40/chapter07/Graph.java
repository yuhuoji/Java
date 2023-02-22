package com.bilibili40.chapter07;

import java.util.HashMap;
import java.util.HashSet;

class Graph {
    public HashMap<Integer,Node> nodes; //点集，点的编号和权值
    public HashSet<Edge> edges; //边集
    public Graph(){
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }
}
