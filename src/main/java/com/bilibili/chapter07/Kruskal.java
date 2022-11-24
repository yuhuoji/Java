package com.bilibili.chapter07;

import java.util.*;

/**
 * @date 2022-11-16 15:07
 * Kruskal算法，对边操作
 * TODO 并查集
 */
public class Kruskal {
    /**
     * Kruskal
     *
     * @param graph 图
     * @return 最小生成树的边集
     */
    public Set<Edge> KruskalMST(Graph graph) {
        //TODO 将HashMap里的value取出存至List里，3 ways
        List<Node> nodesList = new ArrayList<>();
        Collection<Node> values = graph.nodes.values();
        Iterator<Node> iterator = values.iterator();
        while (iterator.hasNext()) {
            nodesList.add(iterator.next());
        }

        //初始化Mysets
        Mysets mysets = new Mysets(nodesList);

        //初始化priorityQueue，TODO 比较器
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        for (Edge edge : graph.edges) { //M条边
            priorityQueue.add(edge); //O（logM）
        }

        //返回的边集，就是最小生成树
        Set<Edge> result = new HashSet<>();

        while (!priorityQueue.isEmpty()) { //M条边
            //依次检查权值最小的边是否生成环
            Edge edge = priorityQueue.poll(); //O(logM)
            if (!mysets.isSameSet(edge.from, edge.to)){ //O(1)
                result.add(edge);
            }
            mysets.union(edge.from, edge.to);
        }
        return result;
    }

    static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge e1, Edge e2) {
            return e1.weight - e2.weight;
        }
    }

    /**
     * Mysets结构，提供两个方法
     * isSameSet
     * union
     */
    public class Mysets {
        //每个集合代表已经连通的点和边
        public HashMap<Node, List<Node>> setMap;

        public Mysets(List<Node> nodes) {
            for (Node curNode : nodes) {
                List<Node> set = new ArrayList<>();
                //每个节点脂肪在一个集合里
                set.add(curNode);
                //在setMap里注册，表示Graph里有这些点
                setMap.put(curNode, set);
            }
        }

        //检查from和to是否在同一个集合里，即加入当前边是否可能形成环
        public boolean isSameSet(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            //判断集合地址是否相同
            return fromSet == toSet;
        }

        //合并from和to集合(合并至fromSet里)
        public void union(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            for (Node curToNode : toSet) {
                //把toSet里的节点都添加至fromSet里
                fromSet.add(curToNode);
                //
                setMap.put(curToNode, fromSet);
            }
        }
    }
}
