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
        int[] res = new int[1];
        res[0] = 0;

        dfs(root, Integer.MIN_VALUE, res);
        return res[0];
    }

    public void dfs(TreeNode root, int max, int[] res) {
        if(root == null) return;

        if(root.val >= max) {
            max = root.val;
            res[0]++;
        }

        dfs(root.left, max, res);
        dfs(root.right, max, res);
    }
}
