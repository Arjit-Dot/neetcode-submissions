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
        return DFS(root,root.val);
    }
    private int DFS(TreeNode root, int largest)
    {
        if(root==null) return 0;
        if(root.val>largest) largest=root.val;
        int left=DFS(root.left,largest);
        int right=DFS(root.right,largest);
        return (root.val>=largest)? 1+left+right: left+right;
        }
}
