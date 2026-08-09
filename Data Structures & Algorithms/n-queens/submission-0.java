class Solution {
    
    public List<List<String>> solveNQueens(int n) {
        if(n==1) return new ArrayList<>(List.of(List.of("Q")));


        if(n<=3) return new ArrayList<>();

        char[][] board=new char[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }

        List<List<String>> result=new ArrayList<>();
        backtrack(board,0,result);

        return result;

    }

    private void backtrack(char[][] board,int row,List<List<String>> result){
        int n=board.length;

        if(row==n){
            result.add(constructString(board));
        }

        for(int col=0;col<n;col++){
            if(isSafe(board, row, col)){
                board[row][col]='Q';
                backtrack(board, row+1, result);
                board[row][col]='.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col){
        int n=board.length;
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q') return false;
        }

        int tempRow=row-1;
        int tempCol=col-1;
        while(tempRow>=0 && tempCol>=0){
            if(board[tempRow][tempCol]=='Q') return false;
            tempRow--;
            tempCol--;
        }

        int j=row-1;
        int k=col+1;
        while(j>=0 && k<n){
            if(board[j][k]=='Q') return false;
            j--;
            k++;
        }

        return true;
        
    }

    private List<String> constructString(char[][] board){
        List<String> sol=new ArrayList<>();

        for(char[] row : board){
            sol.add(new String(row));
        }

        return sol;
    }

}
