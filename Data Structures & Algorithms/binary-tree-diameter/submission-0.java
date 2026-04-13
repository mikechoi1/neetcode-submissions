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
        int[] height = new int[] {0};
        dfs(root, height);
        return height[0];
    }

    private int dfs(TreeNode root, int[] diameter) {
        if (root == null) {
            return 0;
        }
        int leftHeight = dfs(root.left, diameter);
        int rightHeight = dfs(root.right, diameter);
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}

        // dfs
        // at cur node, keep track of longest depth
        // and calc diameter by adding longest depth of left and right
        // if (root == null) {
        //     return 0;
        // }
        // int maxDiameter = 0;
        // Stack<TreeNode> stack = new Stack<>();
        // while (!stack.isEmpty()) {
        //     TreeNode peekNode = stack.peek();
        //     if (peekNode.left != null || peekNode.right != null) {
        //         if (peekNode.left != null) {
        //             stack.push(peekNode.left);
        //         }
        //         if (peekNode.right != null) {
        //             stack.push(peekNode.right);
        //         }
        //         continue;
        //     }
        //     else {

        //     }
        // }
        // return maxDiameter;
