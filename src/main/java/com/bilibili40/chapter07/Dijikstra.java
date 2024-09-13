package com.bilibili40.chapter07;

import org.junit.jupiter.api.Test;

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
     * key：从源点head出发到达key点
     * value：从源点head出发到达key点的距离
     * node1 => node1, node2, node3, node4 ......
     * dist1, dist2, dist3, dist4 ......
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
                } else {
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

    /**
     * 用堆改进后的dijikstra算法
     *
     * @param head 从head出发
     * @param size 总共有size个节点
     * @return key：每个节点，value：最短距离
     */
    public HashMap<Node, Integer> dijikstra2(Node head, int size) {
        NodeHeap nodeHeap = new NodeHeap(size); //新建的堆
        nodeHeap.addOrUpdateOrIgnore(head, 0); //加入head
        HashMap<Node, Integer> result = new HashMap<>(); //返回的结果
        while (!nodeHeap.isEmpty()) {
            //弹出并取值
            NodeRecord nodeRecord = nodeHeap.pop();
            Node curNode = nodeRecord.node;
            int distance = nodeRecord.distance;
            for (Edge edge : curNode.edges) { //遍历当前节点相连的所有节点，检测能否用当前节点到源点的距离更新nodeHeap
                nodeHeap.addOrUpdateOrIgnore(edge.to, edge.weight + distance);
            }
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(Integer.MAX_VALUE);
    }

    /**
     * 改进的堆结构
     */
    public static class NodeHeap {
        private Node[] nodes; //index -> node
        private HashMap<Node, Integer> heapIndexMap; //node -> index，如果node出堆了则value=-1
        private HashMap<Node, Integer> distanceMap; //node当前的最短距离
        private int size; //堆中节点的数量

        public NodeHeap(int size) {
            nodes = new Node[size];
            heapIndexMap = new HashMap<>();
            distanceMap = new HashMap<>();
            this.size = size;
        }

        private boolean isEmpty() {
            return size == 0;
        }

        //如果node在堆中则返回key,如果node出堆了则value=-1
        private boolean isEntered(Node node) {
            return heapIndexMap.containsKey(node);
        }

        //node在堆里 <=> 进入过堆且heapIndexMap的value不为-1（未出堆）
        private boolean isInHeap(Node node) {
            return isEntered(node) && heapIndexMap.get(node) != -1;
        }

        //两个节点交换位置, 在nodes和heapIndexMap都交换
        private void swap(int index1, int index2) {
            heapIndexMap.put(nodes[index1], index2);
            heapIndexMap.put(nodes[index2], index1);

            Node tmpNode = nodes[index1];
            nodes[index1] = nodes[index2];
            nodes[index2] = tmpNode;
        }


        public NodeRecord pop() {
            NodeRecord nodeRecord = new NodeRecord(nodes[0], distanceMap.get(nodes[0])); //记录NodeRecord作为结果返回
            //交换nodes[0]和nodes[size-1]并删除nodes[size-1]
            swap(0, size - 1);
            heapIndexMap.put(nodes[size - 1], - 1); //出堆的点 <=> index=-1
            distanceMap.remove(nodes[size - 1]); //从堆中移除
            nodes[size - 1] = null; //释放节点
            heapify(0, --size); //将0位置的节点进行堆调整，size--
            return nodeRecord;
        }

        //根据distanceMap的值调整堆结构
        private void insertHeapify(Node node, int index) {
            while (distanceMap.get(nodes[index]) > distanceMap.get(nodes[(index - 1) / 2])) {
                swap(index, (index - 1) / 2); //与父节点交换
                index = (index - 1) / 2; //向上移动
            }
        }

        private void heapify(int index, int heapSize) {
            /* 左孩子2*i+1, 右孩子2*i+2 */
            int left = index * 2 + 1; //right = left + 1

//        int largest;
            while (left < heapSize) {
                /* 两个子节点比较 */
                int largest = left + 1 < heapSize && distanceMap.get(nodes[left + 1]) > distanceMap.get(nodes[left])
                        ? left + 1 : left;
/*            if ((left + 1 < heapSize) && (arr[left + 1] > arr[left])) {
                largest = left + 1;
            } else {
                largest = left;
            }*/

                /* 较大值与父节点比较 */
                largest = distanceMap.get(nodes[index]) >= distanceMap.get(nodes[largest]) ? index : largest;
/*            if (arr[index] >= arr[largest]) {
                largest = index;
            }*/

                /* 父节点最大，结束移动 */
                if (largest == index)
                    break;
                swap(largest, index);
                System.out.println("swap(arr, " + largest + ", " + index + ");");

                /* 准备下次循环 */
                index = largest; //下移到子节点
                left = 2 * index + 1;
            }
            System.out.println("Heapify over.");
        }


        /**
         * 记录第一次出现 => add，比已存在的值小 => update，不小于已存在记录 => ignore
         *
         * @param node     节点
         * @param distance 边的权值
         */
        public void addOrUpdateOrIgnore(Node node, int distance) {
            if (isInHeap(node)) { //已经在堆上了，可能将值改小，只可能向上移动
                distanceMap.put(node, Math.min(distanceMap.get(node), distance)); //记录的距离和当前的距离取最小值
                insertHeapify(node, heapIndexMap.get(node)); //调整堆结构
            }
            if (!isEntered(node)) {
                nodes[size] = node;
                heapIndexMap.put(node, size); //堆上新加一个节点
                distanceMap.put(node, distance); //新增记录
                insertHeapify(node, size++); //向上调整
            }
            //进过堆但是不在堆上 => ignore
        }
    }

    //某一点到源点的距离
    public static class NodeRecord {
        public Node node;
        public int distance; //这一点到源点的距离

        public NodeRecord(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
