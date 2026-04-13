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
    public boolean isValidBST(TreeNode root) {
        // send up max from left subtree and min from right subtree
        boolean[] isValid = new boolean[] {true};
        dfs(root, isValid);
        return isValid[0];
    }

    private int[] dfs(TreeNode node, boolean[] isValid) {
        if (node == null) {
            return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        int[] leftMinMax = dfs(node.left, isValid);
        int[] rightMinMax = dfs(node.right, isValid);
        if (node.val <= leftMinMax[1]) {
            isValid[0] = false;
        }
        else if (node.val >= rightMinMax[0]) {
            isValid[0] = false;
        }
        int min = Math.min(node.val, Math.min(leftMinMax[0], rightMinMax[0]));
        int max = Math.max(node.val, Math.max(leftMinMax[1], rightMinMax[1]));
        return new int[] {min, max};
    }
}
