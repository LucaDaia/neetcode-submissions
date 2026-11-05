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
    public List<List<Integer>> levelOrder(TreeNode root)  {

        if(root == null) return new ArrayList<>();


        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> sublist = new ArrayList<>();
            for(int i=0;i<size; i++) {
                TreeNode polledNode = queue.poll();
                sublist.add(polledNode.val);

                if(polledNode.left != null)
                queue.add(polledNode.left);
                if(polledNode.right != null)
                queue.add(polledNode.right);
            }
            res.add(sublist);
        }

        return res;
    }
}
