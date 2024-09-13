package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

//142 环形链表 II
public class LC142LinkedListCycleIi{
    public static void main(String[] args) {
        System.out.println("Leetcode " + "142");
        Solution solution = new LC142LinkedListCycleIi().new Solution();
        
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}