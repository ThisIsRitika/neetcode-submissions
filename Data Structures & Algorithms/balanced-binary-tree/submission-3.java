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
    int flag=0;
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(root.left==null && root.right==null) return true;

        findHeight(root);

        if(flag<0) return false;
        return true;
    
    }

    private int findHeight(TreeNode root){
        if(root==null) return 0;

        int left=findHeight(root.left);
        int right=findHeight(root.right);

        if(left-right==1 || left-right==-1 || left-right==0) return 1+Math.max(left,right);
        else{
            flag=-1;
            return flag;
        }

    }
}
