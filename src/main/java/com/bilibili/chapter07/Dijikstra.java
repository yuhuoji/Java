package com.bilibili.chapter07;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


/**
 * @date 2022-11-24 10:53
 * Dijikstra算法
 * 单源最短路径
 * 适用于没有权值为负的边
 */
public class Dijikstra {
    public int networkDelayTime(int[][] times, int n, int k) {
        return 0;
    }

    /**
     * leetcode 743. 网络延迟时间
     * 给定一个n个点m条边的有向图，图中可能存在重边和自环，所有边权均为正值。
     * <p>
     * 请你求出1号点到n号点的最短距离，如果无法从1号点走到n号点，则输出-1。
     * <p>
     * 输入格式
     * 第一行包含整数n和m。
     * <p>
     * 接下来m行每行包含三个整数x，y，z，表示存在一条从点x到点y的有向边，边长为z。
     * <p>
     * 输出格式
     * 输出一个整数，表示1号点到n号点的最短距离。
     * <p>
     * 如果路径不存在，则输出-1。
     * <p>
     * 数据范围
     * 1≤n≤500,
     * 1≤m≤105,
     * 图中涉及边长均不超过10000。
     * <p>
     * 输入样例：
     * 3 3
     * 1 2 2
     * 2 3 1
     * 1 3 4
     * 输出样例：
     * 3
     *
     * @param n n个点
     * @param m m行边
     */
    public int[] leetcodeDijikstra(int n, int m) {
        //初始化
        int[] dist = new int[n];
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = 0;
        }

        //
        for (int i = 0; i < n; i++) {  // 每次循环都会剔除掉1个点，因此需要for循环遍历n次。
            int index = -1;  // index代表当前未被访问的距离原点最近的点
            dist[1] = 0; // 原点到原点的距离为0，这个很重要，否则下面for循环所有的dist都是0x3f3f3f3f,无法找出index。
            for (int j = 0; j < n; j++) { // find the index of min distance
                if (visited[j] == 0 && (index == -1 || dist[j] < dist[index])) { // 当前的点没有被踢出，并且当前点的距离比index点的距离小，则更新index。index == -1表示还未开始找到dist中最小值，则把dist[1]加入。
                    index = j;
                }
            }

//            visited[index] = 1;  //找到当前距离原点最小值的点，则把点进行标记踢出。
//            for (int j = 0; j < n; j++) {
//                if (dist[index] + edges[index][j] < dist[j]) { //index点更新与它相连的所有点。
//                    dist[j] = dist[index] + edges[index][j];
//                }
//            }
        }
        return dist;
    }


    /**
     * dijikstra
     *
     * @param head 是求解的源点
     * @return HashMap<Node, Integer> distanceMap key-value 如果没有记录则距离为正无穷
     *      key：从源点head出发到达key点
     *      value：从源点head出发到达key点的距离
     * node1 => node1, node2, node3, node4 ......
     *          dist1, dist2, dist3, dist4 ......
     * ========================================
     * TODO dijikstra算法，堆的改写，实现值改变堆的移动
     */
    public HashMap<Node, Integer> dijikstra(Node head) {
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0); //源点到源点的距离为0
        HashSet<Node> selectedNodesSet = new HashSet<>(); //已经求得源点的最小距离的点，之后不会再更新

        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodesSet);
        while (minNode != null) {
            int distance = distanceMap.get(minNode); //获取边的weight
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) { //不含有当前节点的记录，表示当前距离为正无穷
                    distanceMap.put(toNode, distance + edge.weight);
                }else {
                    //用当前点minNode更新minNode连接的各点的距离，之前已经存的最小distance和source->minNode的距离+边的weight的最小值
                    distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
                }
            }
            selectedNodesSet.add(minNode); //minNode的距离被锁定，后序不会再更新
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodesSet); //当所有点都在selectedNodesSet里时，表示所有点都已经遍历完了，算法结束
        }
        return distanceMap;
    }

    private Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> selectedNodesSet) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        //TODO entrySet()
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!selectedNodesSet.contains(node) && distance < minDistance) { //如果当前node为添加过且距离最小
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }

    @Test
    public void test() {
        System.out.println(Integer.MAX_VALUE);
    }
}
