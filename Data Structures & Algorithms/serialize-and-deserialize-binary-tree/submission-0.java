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

public class Codec {

    List<String> res = new ArrayList<>();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfsSerialize(root);
        return String.join(",", res);
    }

    public void dfsSerialize(TreeNode root) {
        if(root == null) {
            res.add("N");
            return;
        }

        res.add(String.valueOf(root.val));
        dfsSerialize(root.left);
        dfsSerialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] stringArray = data.split(",");
        int[] i = {0};
        return dfsDeserialize(stringArray, i);
    }

    public TreeNode dfsDeserialize(String[] stringArray, int[] i) {

        if(stringArray[i[0]].equals("N")) {
            i[0]++;
            return null;
        }

        TreeNode newNode = new TreeNode();
        newNode.val = Integer.valueOf(stringArray[i[0]]);
        i[0]++;
        newNode.left = dfsDeserialize(stringArray, i);
        newNode.right = dfsDeserialize(stringArray, i);

        return newNode;
    }
}
