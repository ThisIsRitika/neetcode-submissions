class Solution {
    public boolean exist(char[][] board, String word) {
        HashSet<int[]> set=new HashSet<>();
        int n=board.length;
        int m=board[0].length;

        int k=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(backtrack(board,word,0,i,j)) return true;
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word, int idx, int row, int col){
        if(idx==word.length()) return true;

        if(row<0 || col<0 || row>=board.length || col>=board[0].length || word.charAt(idx)!=board[row][col] || board[row][col]=='#'){
            return false;
        }

        char temp=board[row][col];
        board[row][col]='#';

        boolean res=backtrack(board,word,idx+1,row+1,col) ||
        backtrack(board,word,idx+1,row-1,col) ||
        backtrack(board,word,idx+1,row,col+1) || 
        backtrack(board,word,idx+1,row,col-1);

        board[row][col]=temp;
        return res;
    }
}
