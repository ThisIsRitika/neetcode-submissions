class Solution {
    int count=0;
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u=edge[0];
            int v=edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited=new boolean[n];
        
        if(!dfs(0,-1,adj,visited)) return false;

        return count==n;
    }

    private boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] visited){
        if(visited[node]==true) return false;

        visited[node]=true;
        count++;
        for(int nei : adj.get(node)){
            if(nei==parent) continue;
            if(!dfs(nei,node,adj,visited)) return false; 
        }

        return true;

    }
}
