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
    int i=0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return ".,";
        String curr=Integer.toString(root.val);
        String left=serialize(root.left);
        String right=serialize(root.right);
        return curr+","+left+right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    if (i >= data.length()) {
        return null;
    }

    if (data.charAt(i) == '.') {
        i += 2;  // skip ".,"
        return null;
    }

    int start = i;

    while (data.charAt(i) != ',') {
        i++;
    }

    int val = Integer.parseInt(data.substring(start, i));

    i++; // skip ','

    TreeNode curr = new TreeNode(val);

    curr.left = deserialize(data);
    curr.right = deserialize(data);

    return curr;
}
}
