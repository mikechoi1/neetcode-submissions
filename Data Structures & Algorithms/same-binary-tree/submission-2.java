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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            if (p != null || q != null) {
                return false;
            }
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);
        while (!stack.isEmpty()) {
            if (stack.size() % 2 == 1) {
                return false;
            }
            TreeNode qNode = stack.pop(), pNode = stack.pop();
            if (pNode == null && qNode == null) {
                continue;
            }
            if (pNode == null || qNode == null || pNode.val != qNode.val) {
                return false;
            }
            stack.push(pNode.left);
            stack.push(qNode.left);
            stack.push(pNode.right);
            stack.push(qNode.right);
        }
        return true;
    }
}
