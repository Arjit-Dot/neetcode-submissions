class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> output=new HashSet<>();
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {   
                if(board[i][j]=='.')
                {
                    continue;
                }
                if(output.add(board[i][j]+"in row "+i) && output.add(board[i][j] +"in column"+j) &&output.add(board[i][j] +"in"+(i/3)+" "+(j/3)))
                {
                    continue;
                }
                else
                {
                    return false;
                }
            }
        }
        return true;
    }
}