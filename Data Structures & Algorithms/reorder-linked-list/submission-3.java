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
        if (head == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode l2 = slow.next;
        slow.next = null;
        ListNode l1 = head;

        // reverse second list
        ListNode cur = l2;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        l2 = prev;

        while (l2 != null) {
            ListNode next1 = l1.next;
            ListNode next2 = l2.next;
            l1.next = l2;
            l2.next = next1;
            l1 = next1;
            l2 = next2;
        }
    }
}
