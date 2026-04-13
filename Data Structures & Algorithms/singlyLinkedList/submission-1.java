class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}

class LinkedList {

    public Node dummyHead;

    public LinkedList() {
        dummyHead = new Node(0);
    }

    public int get(int index) {
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            if (cur == null) {
                return -1;
            }
            cur = cur.next;
        }
        return cur != null ? cur.val : -1;
    }

    public void insertHead(int val) {
        Node temp = dummyHead.next;
        dummyHead.next = new Node(val);
        dummyHead.next.next = temp;
    }

    public void insertTail(int val) {
        Node cur = dummyHead.next;
        Node prev = dummyHead;
        while (cur != null) {
            prev = cur;
            cur = cur.next;
        }
        prev.next = new Node(val);
    }

    public boolean remove(int index) {
        Node cur = dummyHead.next;
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            if (cur == null) {
                return false;
            }
            prev = cur;
            cur = cur.next;
        }
        if (cur == null) {
            return false;
        }
        Node next = cur.next != null ? cur.next : null;
        prev.next = next;
        return true;

    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> list = new ArrayList<>();
        Node cur = dummyHead.next;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        return list;
    }
}
