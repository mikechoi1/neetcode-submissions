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
        if (head == null) {
            return null;
        }
        Node newNode = new Node(head.val);
        hashmap.put(head, newNode);

        newNode.next = copyRandomList(head.next);
        newNode.random = hashmap.get(head.random);
        return newNode;
    }
}
