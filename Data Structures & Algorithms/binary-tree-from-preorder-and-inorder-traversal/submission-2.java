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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hashmap.put(inorder[i], i);
        }
        return buildTreeRecursively(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, hashmap);
    }

    private TreeNode buildTreeRecursively(int[] preorder, int preStart, int preEnd,
                                        int[] inorder, int inStart, int inEnd, Map<Integer, Integer> hashmap) {
        if (preStart < 0 || inStart < 0 || preEnd >= preorder.length || inEnd >= inorder.length
            || preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int partition = hashmap.get(preorder[preStart]);
        root.left = buildTreeRecursively(preorder, preStart + 1, preStart + partition - inStart,
                    inorder, inStart, partition - 1, hashmap);
        root.right = buildTreeRecursively(preorder, preStart + partition - inStart + 1, preEnd,
                    inorder, partition + 1, inEnd, hashmap);
        return root;
    }
}
