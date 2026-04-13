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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (sameTree(node, subRoot)) {
                return true;
            }
            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return false;
    }

    private boolean sameTree(TreeNode n1, TreeNode n2) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(n1);
        queue.offer(n2);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll(), right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.left);
            queue.offer(left.right);
            queue.offer(right.right);
        }
        return true;
    }
}
