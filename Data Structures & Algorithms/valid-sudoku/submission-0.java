class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows=board.length;
        int cols=board[0].length;


        //row check
        for(int i=0;i<rows;i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=0;j<cols;j++){
                if(board[i][j]=='.') continue;
                if(set.contains(board[i][j])) return false;
                else set.add(board[i][j]);
            }
        }

        //column check
        for(int j=0;j<cols;j++){
            HashSet<Character> set = new HashSet<>();
            for(int i=0;i<rows;i++){
                if(board[i][j]=='.') continue;
                if(set.contains(board[i][j])) return false;
                else set.add(board[i][j]);
            }
        }

        //block check
        if(blockChecker(board,0,0) && blockChecker(board,0,3) && blockChecker(board,0,6) &&
        blockChecker(board,3,0) && blockChecker(board,3,3) && blockChecker(board,3,6) &&
        blockChecker(board,6,0) && blockChecker(board,6,3) && blockChecker(board,6,6)) return true;
        else return false;


    }

    private boolean blockChecker(char[][] board, int row, int col){
        HashSet<Character> set=new HashSet<>();
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                if(board[i][j]=='.') continue;
                if(set.contains(board[i][j])) return false;
                else set.add(board[i][j]);
            }
        }

        return true;
    }
}
