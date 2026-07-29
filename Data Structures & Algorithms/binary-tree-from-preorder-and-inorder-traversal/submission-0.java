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
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder=preorder;
        this.inorder=inorder;

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return build(0,preorder.length-1,0,inorder.length-1);

    }

    private TreeNode build(int preSt, int preEnd, int inSt, int inEnd){
        //basecase
        if(preSt>preEnd) return null;
        if(inSt>inEnd) return null;

        TreeNode root=new TreeNode(preorder[preSt]);

        int rootIdx=map.get(root.val);
        int leftSize=rootIdx-inSt;

        root.left=build(preSt+1,preSt+leftSize,inSt,rootIdx-1);
        root.right=build(preSt+leftSize+1,preEnd,rootIdx+1,inEnd);

        return root;
    }
}
