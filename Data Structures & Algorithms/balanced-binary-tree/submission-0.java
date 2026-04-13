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
    public boolean isBalanced(TreeNode root) {
        boolean[] isBalanced = new boolean[] {true};
        dfs(root, isBalanced);
        return isBalanced[0];
    }

    private int dfs(TreeNode root, boolean[] isBalancedSoFar) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, isBalancedSoFar);
        int right = dfs(root.right, isBalancedSoFar);

        if (Math.abs(left - right) > 1) {
            isBalancedSoFar[0] = false;
        }
        return 1 + Math.max(left, right);
    }
}
