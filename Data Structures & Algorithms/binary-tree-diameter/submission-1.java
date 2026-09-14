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
    public int diameterOfBinaryTree(TreeNode root) {
        int maxD[]={0};
        height(root,maxD);
        return maxD[0];
    }
    public int height(TreeNode root,int maxD[])
    {
        if(root==null)
            return 0;
        int leftHeight=height(root.left,maxD);
        int rightHeight=height(root.right,maxD);
        maxD[0]=Math.max(maxD[0],rightHeight+leftHeight);
        return 1+Math.max(leftHeight,rightHeight);
    }
    
}
