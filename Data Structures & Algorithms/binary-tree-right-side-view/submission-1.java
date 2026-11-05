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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
    dfs(root, 0, result);
    return result;
}

private static void dfs(TreeNode node, int depth, List<Integer> result) {
    if (node == null) return;

    // If this is the first time we've reached this depth,
    // the node is the rightmost node at this depth
    if (depth == result.size()) {
        result.add(node.val);
    }

    // Visit right first, then left
    dfs(node.right, depth + 1, result);
    dfs(node.left, depth + 1, result);
}
}

