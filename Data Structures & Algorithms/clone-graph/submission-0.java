/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> hashmap = new HashMap<>();
        return dfs(node, hashmap);
    }

    private Node dfs(Node node, Map<Node, Node> hashmap) {
        Node copy = new Node(node.val);
        hashmap.put(node, copy);
        for (Node neighbor : node.neighbors) {
            if (hashmap.containsKey(neighbor)) {
                copy.neighbors.add(hashmap.get(neighbor));
            }
            else {
                copy.neighbors.add(dfs(neighbor, hashmap));
            }
        }
        return copy;
    }
}