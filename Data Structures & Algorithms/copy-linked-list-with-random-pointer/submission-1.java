/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    Map<Node, Node> hashmap = new HashMap<>();

    public Node copyRandomList(Node head) {
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            Node newNode = new Node(cur.val);
            cur.next = newNode;
            newNode.next = next;
            cur = next;
        }

        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        cur = head;
        Node dummy = new Node(0);
        Node newNodeIter = dummy;
        while (cur != null) {
            newNodeIter.next = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            newNodeIter = newNodeIter.next;
        }
        return dummy.next;
    }
}


        // if (head == null) {
        //     return null;
        // }
        // Node newNode = new Node(head.val);
        // hashmap.put(head, newNode);

        // newNode.next = copyRandomList(head.next);
        // newNode.random = hashmap.get(head.random);
        // return newNode;
