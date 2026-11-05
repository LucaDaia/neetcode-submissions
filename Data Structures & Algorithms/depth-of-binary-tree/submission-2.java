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
    public int maxDepth(TreeNode root) {
        
        int levels = 0;
        Queue<TreeNode> que = new ArrayDeque();
        if(root!= null) {
            que.offer(root);
        }

        while(!que.isEmpty()) {
            int size = que.size();

            for(int i=0;i<size;i++) {
                TreeNode temp = que.poll();

                if(temp.left != null) que.offer(temp.left);
                if(temp.right != null) que.offer(temp.right);
            }

            levels++;
        }

        return levels;

    }
}
