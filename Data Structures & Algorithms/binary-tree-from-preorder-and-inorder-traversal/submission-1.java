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
    int pIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    HashMap<Integer,Integer> hash=new HashMap<>();
    for(int i=0;i<preorder.length;i++)
    {
        hash.put(inorder[i],i);
    }
    return arrParser(preorder,hash,0,inorder.length-1);
    }

    public TreeNode arrParser(int [] p,HashMap<Integer,Integer>hash,int start, int end)
    {
        if(start>end)
            return null;
        TreeNode root=new TreeNode(p[pIndex]);
        int mid=hash.get(p[pIndex++]);
        root.left=arrParser(p,hash,start,mid-1);
        root.right=arrParser(p,hash,mid+1,end);
        return root;
    }
    }

