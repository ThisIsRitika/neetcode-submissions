class Solution {
    class DSU{
        int[] parent;
        int[] rank;

        public DSU(int n){
            parent=new int[n+1];
            rank=new int[n+1];

            for(int i=1;i<n+1;i++){
                parent[i]=i;
                rank[i]=1;
            }
        }

        public int find(int node){
            int curr=node;
            while(curr!=parent[curr]){
                parent[curr]=parent[parent[curr]];
                curr=parent[curr];
            }

            return curr;
        }

        public boolean union(int u,int v){
            int pu=find(u);
            int pv=find(v);

            if(pu==pv) return true;

            if(rank[pv]>rank[pu]){
                int temp=pu;
                pu=pv;
                pv=temp;
                //return true;
            }

            parent[pv]=pu;
            rank[pu]+=rank[pv];
            return false;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        DSU dsu=new DSU(n);
        int[] ans=new int[2];
        for(int edge[] : edges){
            if(dsu.union(edge[0],edge[1])) ans=edge;
        }

        return ans;
    }
}
