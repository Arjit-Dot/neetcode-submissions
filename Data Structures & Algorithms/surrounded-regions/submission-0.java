class Solution {
    int [][]directions=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        int rows=board.length;
        int col=board[0].length;
        boolean safe[][]=new boolean [rows][col];
         //check up and down for O
        for(int c=0;c<col;c++){
            dfs(board,0,c,safe);
            dfs(board,rows-1,c,safe);
        }
        //check left and right
        for(int r=0;r<rows;r++){
            dfs(board,r,0,safe);
            dfs(board,r,col-1,safe);
        }
        //mark the loose O's as X
        for(int i=1;i<rows;i++){
                for(int j=1;j<col;j++){
                    if(board[i][j]=='O' && !safe[i][j]){
                        board[i][j]='X';
                    }
                }
        }
    }
    private void dfs(char [][]board,int r,int c,boolean safe[][]){
        if(r<0 ||c<0 || r>=board.length|| c>=board[0].length || safe[r][c] || board[r][c]=='X') return;
        safe[r][c]=true;
        for(int [] look:directions){
            dfs(board,r+look[0],c+look[1],safe);
        }
    }
}
