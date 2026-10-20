class Solution {
    public boolean exist(char[][] board, String word) {
        boolean out=false;
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++){
                out=backtrack(board,word,0,i,j);
                if(out==true)return true;
            }
        }
        return out;
    }
    private boolean backtrack(char[][]board,String word,int index,int row,int col)
    {
        if(row<0|| row==board.length || col<0 || col==board[0].length) return false; 
        if(index==word.length()-1 && board[row][col]==word.charAt(index)) return true;    
         if(board[row][col]=='*' || board[row][col]!=word.charAt(index)) return false;
        
        char val=board[row][col];
        board[row][col]='*';
        boolean found=
        backtrack(board,word,index+1,row+1,col) ||
        backtrack(board,word,index+1,row-1,col) ||
        backtrack(board,word,index+1,row,col+1) ||
        backtrack(board,word,index+1,row,col-1);
        board[row][col]=val;
        return found;
    }
}
