class Solution {
    int[][] dirs={{1,0},{0,1},{-1,0},{0,-1}};
    int ROWS, COLS;
    public void solve(char[][] board) {
        ROWS=board.length;
        COLS=board[0].length;

        for(int row=0;row<ROWS;row++){
            for(int col=0;col<COLS;col++){
                if(row==0 || col==0 || row==ROWS-1 || col==COLS-1){
                    if(board[row][col]=='O'){
                        dfs(board,row,col);
                    }
                }
            }
        }

        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if(board[r][c]=='O') board[r][c]='X';
                else if(board[r][c]=='#') board[r][c]='O';
            }
        }
    }

    private void dfs(char[][] board, int row, int col){
        if(row<0 || col<0 || row>=ROWS || col>=COLS || board[row][col]!='O') return;

        char temp=board[row][col];
        board[row][col]='#';

        for(int[] dir : dirs){
            dfs(board,row+dir[0],col+dir[1]);
        }

    }
}
