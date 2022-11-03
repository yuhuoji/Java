package com.bilibili.chapter07;

import org.junit.Test;

import java.util.*;

/**
 * @date 2022-11-03 11:04
 * 将未知的数据结构先变换为已知的
 * eg: matrix N*3 , each row represents an edge :[from, weight, to]
 */
public class GraphOperation {
    //create a graph
    public Graph createGraph(Integer[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) { //matrix.length 行数， matrix[0].length 列数
            Integer from = matrix[i][0];
            Integer weight = matrix[i][1];
            Integer to = matrix[i][2];
            //create the node
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            //create the edge
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            //update
            fromNode.out++;
            toNode.in++;
            fromNode.nexts.add(toNode);
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);

        }
        return graph;
    }

    //graph bfs
    public void bfs(Node node) {
        //base case
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>(); //bfs uses queue
        HashSet<Node> hashSet = new HashSet<>(); //serve queue, the same cannot enter the queue twice，防止有环（检查去重）
        queue.add(node);
        hashSet.add(node);
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            //bfs operation
            System.out.println(curNode.value + " ");
            for (Node next : curNode.nexts) {
                if (!hashSet.contains(next)) {
                    queue.add(next);
                    hashSet.add(next);
                }
            }
        }
    }

    //graph dfs
    public void dfs(Node node) {
        //base case
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>(); //存储当前dfs的路径
        HashSet<Node> hashSet = new HashSet<>();
        stack.add(node);
        hashSet.add(node);
        //dfs operation
        System.out.println(node.value + " ");
        while (!stack.isEmpty()) {
            Node curNode = stack.pop();
            for (Node next : curNode.nexts) {
                if (!hashSet.contains(next)) { //选择一条未遍历过的点进行深度优先遍历
                    stack.push(curNode);
                    stack.push(next);
                    hashSet.add(next);
                    //dfs operation
                    System.out.println(next.value + " ");
                    break; //只选择一条路深度遍历
                }
            }
        }
    }

    //TODO topological sorting algorithm
    public List<Node> sortedTopology(Graph graph) {
        //key: 某一点， value: 当前剩余的入度
        HashMap<Node, Integer> inMap = new HashMap<>();
        //入度为0的点才能进入
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node : graph.nodes.values()) { //初始化所有节点及其入度
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }

        //拓扑排序的结果，将入度为0的点依次加入
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node curNode = zeroInQueue.poll();
            result.add(curNode);
            for (Node next : curNode.nexts) { //删除curNode及其影响
                inMap.put(next, inMap.get(next) - 1); //更新， 临近点的入度in -1
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }

            }
        }
        return result;
    }

    //


    @Test
    public void graphOperationTest() {
        System.out.println("test");
    }
}
