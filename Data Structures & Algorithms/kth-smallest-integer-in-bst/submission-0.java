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
    public static int kthSmallest(TreeNode root, int k) {
            List<Integer> res = new ArrayList<>();
            dfs(root, res);
            System.out.println(res);
            return res.get(k-1);
        }

    private static void dfs(TreeNode root, List<Integer> res) {
        if(root == null) {
            return;
        }

        dfs(root.left, res);
        if(!res.contains(root.val)) res.add(root.val);
        dfs(root.right, res);
        if(!res.contains(root.val)) res.add(root.val);

    }
}
