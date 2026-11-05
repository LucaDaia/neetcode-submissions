class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        // Path passing through this node
        max = Math.max(max, root.val + left + right);

        // Return max downward path
        return root.val + Math.max(left, right);
    }
}
