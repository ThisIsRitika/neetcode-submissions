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
        
        //to store the clone nodes and their references
        Map<Node,Node>map=new HashMap<>();

        //to keep track of visited nodes
        //number of nodes are 1 to n where n<=100
        boolean[] visited=new boolean[101];
        visited[0]=true;//no node has value 0

        Node curr=node;//store the first node

        dfs(curr,map,visited);

        return map.get(node);
    }

    private void dfs(Node curr, Map<Node, Node> map, boolean[] visited){
        if(visited[curr.val]==true) return;

        map.put(curr, new Node(curr.val));
        visited[curr.val]=true;

        if(curr.neighbors!=null){
            for(int i=0;i<curr.neighbors.size();i++){
                //store the ith neighbor from list of neighbors of current
                Node neigh=curr.neighbors.get(i);
                //dfs on neighbor to add it in the map
                dfs(neigh,map,visited);

                //get the cloned neighbor node from the map and add that to the neighbors list of curr node
                map.get(curr).neighbors.add(map.get(neigh));
            }
        }
    }
}