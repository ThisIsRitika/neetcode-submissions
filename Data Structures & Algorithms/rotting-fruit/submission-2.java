class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]>q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        int fresh=0;
        int time=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) fresh++;
                if(grid[i][j]==2) q.add(new int[]{i,j});
            }
        }

        int[][] dirs={{1,0},{0,1},{-1,0},{0,-1}};

        while(fresh>0 && !q.isEmpty()){
            int size=q.size();

            for(int i=0;i<size;i++){
                int[] rot=q.poll();
                int row=rot[0];
                int col=rot[1];

                for(int[] dir : dirs){
                    int r=row+dir[0];
                    int c=col+dir[1];

                    if(r>=0 && r<m && c>=0 && 
                    c<n && grid[r][c]==1){
                        grid[r][c]=2;
                        q.offer(new int[]{r, c});
                        fresh--;
                    }                    
                }
            }

            time++;
            

        }

        return fresh==0 ? time : -1;
    }
}
