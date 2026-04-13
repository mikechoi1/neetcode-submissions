class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    private int capacity;
    private Node oldest;
    private Node newest;
    private Map<Integer, Node> hashmap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        oldest = new Node(0, 0);
        newest = new Node(0, 0);
        oldest.next = newest;
        newest.prev = oldest;
        hashmap = new HashMap<>();
        
    }
    
    public int get(int key) {
        if (hashmap.containsKey(key)) {
            Node res = hashmap.get(key);
            remove(res);
            insert(res);
            return res.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        boolean isUpdating = false;
        if (hashmap.containsKey(key)) {
            remove(hashmap.get(key));
            isUpdating = true;
        }
        Node newNode = new Node(key, value);
        if (!isUpdating && hashmap.size() == capacity) {
            Node removeNode = oldest.next;
            remove(removeNode);
            hashmap.remove(removeNode.key);
        }
        insert(newNode);
        hashmap.put(key, newNode);
    }

    private void insert(Node node) {
        Node prevNode = newest.prev;
        prevNode.next = node;
        node.prev = prevNode;
        newest.prev = node;
        node.next = newest;
    }

    private void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}
