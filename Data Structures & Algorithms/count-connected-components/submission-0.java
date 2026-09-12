class Solution {
    public int countComponents(int n, int[][] edges) {
        //created an adj list from edges array
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        //visited array
        //all the nodes reachable from each other makes 1 component
        boolean[] visited=new boolean[n];

        int component=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                component++;
                dfs(adj,visited,i);
            }
        }

        return component;
    }

    private void dfs(List<List<Integer>> adj, boolean[] visited, int node){
        if(visited[node]==true) return;

        visited[node]=true;

        for(int nei : adj.get(node)){
            dfs(adj,visited,nei);
        }
    }
}
