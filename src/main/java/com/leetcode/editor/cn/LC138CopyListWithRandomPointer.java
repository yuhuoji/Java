package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.HashMap;
import java.util.Map;

// 138 Copy List with Random Pointer
public class LC138CopyListWithRandomPointer {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 138);
        Solution solution = new LC138CopyListWithRandomPointer().new Solution();

    }

    // Definition for a Node.
    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 哈希表 原节点-新节点
        // mp.get(old) = new
        // mp.get(old.next) = new.next
        // mp.get(old.random) = new.random
        public Node copyRandomList(Node head) {
            Map<Node, Node> mp = new HashMap<>();
            Node cur = head;
            while (cur != null) {
                mp.put(cur, new Node(cur.val));
                cur = cur.next;
            }

            cur = head;
            Node newNode;
            while (cur != null) { // old
                newNode = mp.get(cur);
                if (cur.next != null) {
                    newNode.next = mp.get(cur.next);
                }
                if (cur.random != null) {
                    newNode.random = mp.get(cur.random);
                }
                cur = cur.next;
            }

            return mp.get(head); // 返回新头
        }

        // 三步，新建，random，分离
        public Node copyRandomList1(Node head) {
            if (head == null) {
                return null;
            }
            // 创建
            // cur new nxt
            Node cur = head, nxt;
            while (cur != null) {
                nxt = cur.next;
                cur.next = new Node(cur.val);
                cur.next.next = nxt;
                // 下一个
                cur = nxt;
            }
            // 指针random
            // cur cur.next
            cur = head;
            while (cur != null) {
                if (cur.random != null) { //! random可以为空
                    cur.next.random = cur.random.next;
                }
                // 下一个
                cur = cur.next.next;
            }
            // 分离
            Node dummy = new Node(0);
            dummy.next = head.next;
            cur = head;
            Node newCur = head.next;
            // cur newCur nxt
            while (newCur.next != null) { // 最后一组需要特别判断
                nxt = newCur.next;
                newCur.next = nxt.next;
                cur.next = nxt;
                // 下一个
                cur = cur.next;
                newCur = newCur.next;
            }
            cur.next = null; // 最后一组
            return dummy.next;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}