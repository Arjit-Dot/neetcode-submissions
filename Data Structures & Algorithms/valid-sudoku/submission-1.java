class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean result=true;;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]=='.')continue;
                result=isColSafe(board,board[i][j],i,j)&&isRowSafe(board,board[i][j],i,j)&& isGridSafe(board,board[i][j],i,j);
                if(result==false)return false;
            }
        }
        return result;
    }
    public boolean isColSafe(char[][]board,char digit, int r,int c){
        while(c<=board[0].length-2){
            if(board[r][++c] ==digit) return false;
        }
        return true;
    }
    public boolean isRowSafe(char[][]board,char digit, int r,int c){
        while(r<=board.length-2){
            if(board[++r][c]==digit) return false;
        }
        return true;
    }
    public boolean isGridSafe(char[][]board,char digit, int row,int col){
        int r=3*(row/3);
        int c=3*(col/3);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if( i+r==row && j+c==col)continue;
                if(board[r+i][c+j]==digit)return false;
            }
        }
        return true;
    }
}
