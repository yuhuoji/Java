package com.leetcode.helper;

import java.util.*;
import java.util.regex.*;

// TODO @date 2023-11-12 添加其他有效方法 stringToList
// List.of
// use T in definitions
public class LeetCodeHelper {
    // 将字符串转换为整数
    public static int stringToInteger(String input) {
        return Integer.parseInt(input);
    }

    // 将字符串(只包括英文字母)转换为字符数组
    public static char[] stringToCharArray(String input) {
        input = input.replaceAll("[^a-zA-Z]", ""); // 只保留英文字母
        return input.toCharArray();
    }

    // 将字符串转换为整数数组
    public static int[] stringToIntegerArray(String input) {
        input = input.replaceAll("\\[|\\]", "");
        String[] parts = input.split(",");
        int[] result = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            result[i] = Integer.parseInt(parts[i].trim());
        }
        return result;
    }

    // 将整数数组转换为字符串
    public static String integerArrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // 将字符串转换为字符串数组
    public static String[] stringToStringArray(String input) {
        input = input.replaceAll("\\[|\\]", "");
        String[] parts = input.split(",");
        String[] result = new String[parts.length];
        for (int i = 0; i < parts.length; i++) {
            result[i] = parts[i].trim();
        }
        return result;
    }

    // 将字符串数组转换为字符串
    public static String stringArrayToString(String[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append("\"" + array[i] + "\"");
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // 将链表节点表示的字符串转换为链表
    public static ListNode stringToListNode(String input) {
        input = input.trim();
        if (input.equals("[]")) {
            return null;
        }
        input = input.replaceAll("\\[|\\]", "");
        String[] parts = input.split("->");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (String part : parts) {
            current.next = new ListNode(Integer.parseInt(part.trim()));
            current = current.next;
        }
        return dummy.next;
    }

    // 将链表转换为链表节点表示的字符串
    public static String listNodeToString(ListNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (node != null) {
            sb.append(node.val);
            node = node.next;
            if (node != null) {
                sb.append("->");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // 将布尔值转换为字符串
    public static String boolToString(boolean input) {
        return input ? "true" : "false";
    }

    // 将字符串转换为布尔值
    public static boolean stringToBool(String input) {
        return input.equalsIgnoreCase("true");
    }

    // 将二维整数数组表示的字符串转换为二维整数数组
    public static int[][] stringTo2DIntegerArray(String input) {
        Pattern pattern = Pattern.compile("\\[\\[([^]]+)\\],?\\s?\\[([^]]+)\\]\\]");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String[] arr1 = matcher.group(1).split(",");
            String[] arr2 = matcher.group(2).split(",");
            int[][] result = new int[2][arr1.length];
            for (int i = 0; i < arr1.length; i++) {
                result[0][i] = Integer.parseInt(arr1[i].trim());
                result[1][i] = Integer.parseInt(arr2[i].trim());
            }
            return result;
        }
        return new int[][]{};
    }

    // 将二维整数数组转换为二维整数数组表示的字符串
    public static String int2DArrayToString(int[][] array) {
        if (array == null || array.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[[");
        for (int i = 0; i < array[0].length; i++) {
            sb.append(array[0][i]);
            if (i < array[0].length - 1) {
                sb.append(", ");
            }
        }
        sb.append("], [");
        for (int i = 0; i < array[1].length; i++) {
            sb.append(array[1][i]);
            if (i < array[1].length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]]");
        return sb.toString();
    }

    // 将树节点表示的字符串转换为树节点
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        if (input.equals("[]")) {
            return null;
        }
        input = input.replaceAll("\\[|\\]", "");
        String[] parts = input.split(",");
        Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(parts[0].trim()));
        nodes.add(root);
        int i = 1;
        while (!nodes.isEmpty() && i < parts.length) {
            TreeNode current = nodes.poll();
            if (!parts[i].trim().equals("null")) {
                current.left = new TreeNode(Integer.parseInt(parts[i].trim()));
                nodes.add(current.left);
            }
            i++;
            if (i < parts.length && !parts[i].trim().equals("null")) {
                current.right = new TreeNode(Integer.parseInt(parts[i].trim()));
                nodes.add(current.right);
            }
            i++;
        }
        return root;
    }

    // 将树节点转换为树节点表示的字符串
    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (node == null) {
                sb.append("null");
            } else {
                sb.append(node.val);
                nodes.add(node.left);
                nodes.add(node.right);
            }
            if (!nodes.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // 将布尔值列表转换为字符串
    public static String boolListToString(List<Boolean> list) {
        if (list == null || list.isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append(boolToString(list.get(i)));
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Definitions
/*    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }*/
}
