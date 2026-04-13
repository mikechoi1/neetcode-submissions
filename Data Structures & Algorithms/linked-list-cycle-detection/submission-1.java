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
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode walk = head, run = head.next;
        while (run != null) {
            if (walk == run) {
                return true;
            }
            walk = walk.next;
            if (run.next != null && run.next.next != null) {
                run = run.next.next;
            }
            else {
                break;
            }
        }
        return false;
    }
}
