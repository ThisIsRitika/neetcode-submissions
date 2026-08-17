class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int island=0;
        int area=0;
        int maxarea=0;

        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[0].length;col++){
                if(grid[row][col]==1){
                    island++;
                    area=dfs(grid,row,col);
                }
                maxarea=Math.max(area, maxarea);
            }
        }

        return maxarea;
    }

    private int dfs(int[][] grid, int row, int col){
       if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]==0) return 0;

       grid[row][col]=0;

       int area=dfs(grid,row+1,col)+
                dfs(grid,row-1,col)+
                dfs(grid,row,col+1)+
                dfs(grid,row,col-1);

        return area+1;
    }
}
