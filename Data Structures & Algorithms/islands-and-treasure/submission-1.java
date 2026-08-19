class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]>q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==0){
                    q.add(new int[] {row, col});
                }
            }
        }

        if(q.size()==0) return;

        int[][] dirs={{1,0},{0,1},{-1,0},{0,-1}};

        while(!q.isEmpty()){
            int[] node=q.poll();
            int row=node[0];
            int col=node[1];

            for(int[] dir : dirs){
                int r=row+dir[0];
                int c=col+dir[1];

                if(r<0 || r>=m || c<0 || c>=n || grid[r][c]!=Integer.MAX_VALUE) continue;

                q.add(new int[]{r,c});
                grid[r][c]=grid[row][col]+1;
            }
        }


        
    }

    
}
