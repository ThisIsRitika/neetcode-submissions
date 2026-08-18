/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;

        boolean[] visited=new boolean[101];
        visited[0]=true;

        Node curr=node;

        HashMap<Node, Node> map=new HashMap<>();

        dfs(curr,map,visited);

        return map.get(node);
    }

    private void dfs(Node curr, HashMap<Node, Node> map, boolean[] visited){
        if(visited[curr.val]==true) return;

        map.put(curr, new Node(curr.val));
        visited[curr.val]=true;

        if(curr.neighbors!=null){
            for(int i=0;i<curr.neighbors.size();i++){
                dfs(curr.neighbors.get(i),map,visited);

                map.get(curr).neighbors.add(map.get(curr.neighbors.get(i)));
            }
        }
    }
}