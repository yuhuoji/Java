package com.bilibili40.chapter06;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @date 2022-11-01 20:37
 */
public class SerializeAndReconstructTree {
    //head为头，#代表null，下划线_表示当前节点的value结束，先序遍历将树序列化为字符串返回
    public String serialByPreOrder(TreeNode head) {
        if (head == null) {
            return "#_";
        }
        String res = head.value + "_";
        res += serialByPreOrder(head.left);
        res += serialByPreOrder(head.right);
        return res;
    }

    //反序列化，返回头节点head
    public TreeNode reconstructByPreString(String preStr) {
        String[] values = preStr.split("_"); //用下划线_分割
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(values)); //将value放到队列里进行操作
        return reconstructByPreStringProcess(queue);
    }

    //根据队列重建树
    private TreeNode reconstructByPreStringProcess(Queue<String> queue) {
        String value = queue.poll();
        //base case
        if (value.equals("#")) {
            return null;
        }
        //父节点
        TreeNode head = new TreeNode(Integer.parseInt(value));
        //左节点
        head.left  = reconstructByPreStringProcess(queue);
        //右节点
        head.right = reconstructByPreStringProcess(queue);
        //返回头节点
        return head;
    }

    @Test
    public void test() {
        System.out.println("test");
    }

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;


        TreeNode() {
        }

        TreeNode(int value) {
            this.value = value;
        }

        TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
