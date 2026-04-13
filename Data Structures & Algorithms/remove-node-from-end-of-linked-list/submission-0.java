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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode nAhead = dummy;
        for (int i = 0; i < n; i++) {
            // assume n <= size of linked list
            nAhead = nAhead.next;
        }

        ListNode cur = dummy;
        while (nAhead != null) {
            if (nAhead.next == null) {
                cur.next = cur.next.next;
            }
            nAhead = nAhead.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
