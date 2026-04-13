/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode l1 = head, prev1 = null, l2 = head;
        while (l2 != null && l2.next != null) {
            prev1 = l1;
            l1 = l1.next;
            l2 = l2.next.next;
        }
        prev1.next = null;
        // l1 should be midway point now

        ListNode cur = l1, prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        l1 = prev;
        // l1 is now reversed

        ListNode cur1 = head, cur2 = l1;
        while (cur1 != null) {
            ListNode next1 = cur1.next, next2 = cur2.next;
            cur1.next = cur2;
            if (next1 != null) {
                cur2.next = next1;
            }
            cur1 = next1;
            cur2 = next2;
        }
    }
}
