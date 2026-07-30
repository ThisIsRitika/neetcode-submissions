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
    
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        StringBuilder st=new StringBuilder();
        q.offer(root);

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();

                if(node==null){
                    st.append("N,");
                    continue;
                }

                st.append(node.val);
                st.append(",");

                q.offer(node.left);
                q.offer(node.right);
                
            }
        } 

        return st.toString();       
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> q=new LinkedList<>();

        String[] arr=data.split(",");

        if (arr[0].equals("N")) return null;

        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);
        int idx=1;

        while(!q.isEmpty()){
            TreeNode parent=q.poll();

            if(!arr[idx].equals("N")){
                TreeNode left=new TreeNode(Integer.parseInt(arr[idx]));
                q.offer(left);
                parent.left=left;
            }
            idx++;

            if(!arr[idx].equals("N")){
                TreeNode right=new TreeNode(Integer.parseInt(arr[idx]));
                q.offer(right);
                parent.right=right;
            }
            idx++;
    
        }

        return root;
    }
}
