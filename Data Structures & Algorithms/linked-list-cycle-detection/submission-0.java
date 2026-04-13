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
        Set<ListNode> hashset = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (hashset.contains(cur)) {
                return true;
            }
            hashset.add(cur);
            cur = cur.next;
        }
        return false;
    }
}
