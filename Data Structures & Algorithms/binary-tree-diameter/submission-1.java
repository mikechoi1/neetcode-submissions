/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        // dfs
        // at current node, keep track of longest height from sub trees
        // and calc max diameter seen so far by adding longest left and right height
        // and comparing to max diameter we've seen so far
        // need to track height at every node (int) and diameter (int) both of which the parent will use
        if (root == null) {
            return 0;
        }
        // Pair<tree node, max height at cur node>
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Pair<Integer, Integer>> hashmap = new HashMap<>();
        hashmap.put(null, new Pair<>(0, 0));
        stack.push(root);
        int maxDiameter = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left != null && !hashmap.containsKey(node.left)) {
                stack.push(node.left);
            }
            else if (node.right != null && !hashmap.containsKey(node.right)) {
                stack.push(node.right);
            }
            else {
                node = stack.pop();
                Pair<Integer, Integer> leftPair = hashmap.get(node.left),
                rightPair = hashmap.get(node.right);

                int leftHeight = leftPair.getKey(), leftDiameter = leftPair.getValue();
                int rightHeight = rightPair.getKey(), rightDiameter = rightPair.getValue();

                int curHeight = 1 + Math.max(leftHeight, rightHeight);
                int curMaxDiameter = Math.max(Math.max(leftDiameter, rightDiameter), leftHeight + rightHeight);
                hashmap.put(node, new Pair<>(curHeight, curMaxDiameter));
            }
        }
        return hashmap.get(root).getValue();
    }
}
// private int dfs(TreeNode root, int[] diameter) {
//     if (root == null) {
//         return 0;
//     }
//     int leftHeight = dfs(root.left, diameter);
//     int rightHeight = dfs(root.right, diameter);
//     diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
//     return 1 + Math.max(leftHeight, rightHeight);
// }
