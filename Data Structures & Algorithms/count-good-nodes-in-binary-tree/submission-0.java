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
        if(root == null) return 0;
        int max = Integer.MIN_VALUE;
        dfs(max,res, root);
        return res[0];
    }

    public void dfs(int max, int[] res, TreeNode root) {
        
        if(root == null) return;

        if(root.val >= max) {
            res[0]++;
            max = root.val;
        }

        dfs(max, res, root.left);
        dfs(max, res, root.right);
    }
}
