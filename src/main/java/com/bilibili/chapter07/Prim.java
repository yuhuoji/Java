package com.bilibili.chapter07;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @date 2022-11-24 17:37
 * Prim算法，对点操作
 * 适用范围：要求无向图
 */
public class Prim {
    /**
     * prim
     *
     * @param graph 图
     * @return 最小生成树的边集
     */
    public Set<Edge> primMST(Graph graph) {
        //解锁的边进入小根堆（连通两个点集之间的边），每次选weight最小的
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        //已经连通的点集
        HashSet<Node> codeSet = new HashSet<>();
        //返回的边集（最小生成树），依次添加
        Set<Edge> result = new HashSet<>();

        for (Node node : graph.nodes.values()) { //遍历所有点集，graph可能不是连通图，用for循环找到下一个连通子图
            //node是开始点
            if (!codeSet.contains(node)) {
                codeSet.add(node);

                for (Edge edge : node.edges) { //解锁当前node相连的所有边
                    priorityQueue.add(edge);
                }
                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll(); //解锁的边中weight最小且连通两个点集的边
                    //判断当前边是否是连通两个点集的边
                    Node toNode = edge.to;
                    if (!codeSet.contains(toNode)) { //toNode如果在codeSet里则形成环，不在则连通两个点集
                        codeSet.add(toNode);
                        result.add(edge);
                        for (Edge nextEdge : toNode.edges) {
                            priorityQueue.add(nextEdge); //会将当前edge重复添加，但只会选用连通两个点集的边，不影响结果
                        }
                    }
                }
            }
        }
        return result;
    }

    static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge e1, Edge e2) {
            return e1.weight - e2.weight;
        }
    }
}
