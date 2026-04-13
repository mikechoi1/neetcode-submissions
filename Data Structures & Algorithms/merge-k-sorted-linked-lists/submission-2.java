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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        while (lists.length > 1) {
            List<ListNode> mergedLists = new ArrayList<>();
            for (int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = i + 1 < lists.length ? lists[i + 1] : null;
                mergedLists.add(merge(l1, l2));
            }
            lists = mergedLists.toArray(new ListNode[0]);
        }

        return lists[0];
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        else if (l2 != null) {
            cur.next = l2;
        }

        return dummy.next;
    }
}



        // ListNode dummy = new ListNode(0);
        // ListNode cur = dummy;
        // PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> {
        //     return Integer.compare(a.val, b.val);
        // });
        // for (ListNode list : lists) {
        //     if (list != null) {
        //         pq.offer(list);
        //     }
        // }
        // while (!pq.isEmpty()) {
        //     ListNode poppedNode = pq.poll();
        //     cur.next = poppedNode;
        //     cur = cur.next;
        //     if (poppedNode.next != null) {
        //         pq.offer(poppedNode.next);
        //     }
        // }

        // return dummy.next;
