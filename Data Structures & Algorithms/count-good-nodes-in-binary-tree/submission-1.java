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
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int maxValue) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        if (node.val >= maxValue) {
            res++;
        }
        res += dfs(node.left, Math.max(maxValue, node.val));
        res += dfs(node.right, Math.max(maxValue, node.val));
        return res;
    }
}

// BFS
        // if (root == null) {
        //     return 0;
        // }
        // Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        // queue.offer(new Pair<>(root, root.val));
        // int numOfGoodNodes = 0;
        // while (!queue.isEmpty()) {
        //     Pair<TreeNode, Integer> pair = queue.poll();
        //     TreeNode node = pair.getKey();
        //     int maxValue = pair.getValue();
        //     if (node.val >= maxValue) {
        //         numOfGoodNodes++;
        //     }
        //     if (node.left != null) {
        //         queue.offer(new Pair<>(node.left, Math.max(maxValue, node.left.val)));
        //     }
        //     if (node.right != null) {
        //         queue.offer(new Pair<>(node.right, Math.max(maxValue, node.right.val)));
        //     }
        // }
        // return numOfGoodNodes;
