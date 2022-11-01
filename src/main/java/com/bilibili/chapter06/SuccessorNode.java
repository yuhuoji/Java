package com.bilibili.chapter06;

/**
 * @date 2022-11-01 20:38
 * 一种树节点含父节点parent，返回当前节点的后继节点（中序遍历的下一个节点）
 */
public class SuccessorNode {

    //返回当前节点的后继节点（中序遍历的下一个节点）
    public TreeNode getSuccessorNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        //case1，右子树不为空，后继节点为右子树最左下的节点
        if (node.right != null) {
            return getLeftMost(node.right);
        } else { //case2，右子树为空，后继节点为
            TreeNode parent = node.parent;
            //node==null当前节点是树最右下的节点，返回null；parent.left==node当前节点是夫系欸但的左节点，返回node
            while (parent != null && parent.left != node) {
                //往上移动，直到node是父节点的右孩子
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    //当前树的最左节点
    private TreeNode getLeftMost(TreeNode node) {
        if (node == null) {
            return null;
        }
        //找到最左下的节点
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode parent;

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
