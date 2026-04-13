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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur1 = l1, cur2 = l2, sumCur = dummy;
        while (cur1 != null || cur2 != null) {
            int sum = 0;
            if (cur1 != null) {
                sum += cur1.val;
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                sum += cur2.val;
                cur2 = cur2.next;
            }
            sum += carry;
            sumCur.next = new ListNode(sum % 10);
            carry = sum / 10;
            sumCur = sumCur.next;
        }
        if (carry == 1) {
            sumCur.next = new ListNode(1);
        }
        return dummy.next;
    }
}
