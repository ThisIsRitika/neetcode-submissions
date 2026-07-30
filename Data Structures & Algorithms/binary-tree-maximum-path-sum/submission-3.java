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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum=root.val;
        findMax(root);
        return maxSum;
    }

    private int findMax(TreeNode node){
        if(node==null) return 0;
        
        int leftsum=findMax(node.left);
        int rightsum=findMax(node.right);

        if(leftsum<0) leftsum=0;
        if(rightsum<0) rightsum=0;

        maxSum=Math.max(maxSum,node.val+leftsum+rightsum);

        return node.val+Math.max(leftsum, rightsum);
    }
}
