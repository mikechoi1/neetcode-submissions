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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        // Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        // int depth = 0;
        // stack.push(new Pair<>(root, 1));
        // while (!stack.isEmpty()) {
        //     Pair<TreeNode, Integer> pair = stack.pop();
        //     int curDepth = pair.getValue();
        //     depth = Math.max(depth, curDepth);
        //     TreeNode node = pair.getKey();
        //     if (node.right != null) {
        //         stack.push(new Pair<>(node.right, curDepth + 1));
        //     }
        //     if (node.left != null) {
        //         stack.push(new Pair<>(node.left, curDepth + 1));
        //     }
        // }
        // return depth;
    }
}
