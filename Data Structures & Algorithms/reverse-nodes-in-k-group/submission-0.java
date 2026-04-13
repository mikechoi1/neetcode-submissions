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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode nextGroup = head;
        int count = 0;
        while (nextGroup != null && count < k) {
            nextGroup = nextGroup.next;
            count++;
        }
        if (count < k) {
            return head;
        }
        ListNode cur = head;
        ListNode prev = reverseKGroup(nextGroup, k);
        for (int i = 0; i < k; i++) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }        
}

/*
- reverse in groups, need to return previously last element in group as new head
- need to keep pointer at front of group to point to next reversed group
(aka process furthest group first in recursive order)

*/
