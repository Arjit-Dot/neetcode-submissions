class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>out=new ArrayList<>();
        char grid[][]=new char[n][n];
        for(int i=0;i<grid.length;i++){
            Arrays.fill(grid[i],'.');
        }
        backtrack(out,grid,0);
        return out;
    }
    private void backtrack(List<List<String>>out,char grid[][],int row)
    {
        if(row==grid.length){
            addToFinal(grid,out);
            return;
        }
        for(int col=0;col<grid.length;col++){
            if(isSafe(grid,row,col)){
                grid[row][col]='Q';
                backtrack(out,grid,row+1);
                grid[row][col]='.';
            }
           
        }
    }
    private boolean isSafe(char[][] grid, int row, int col) {
        // Search upward until we hit the top edge (i <= row)
        for (int i = 1; i <= row; i++) {
            int nr = row - i; // Look UP by i steps
            
            // 1. Straight Up
            if (grid[nr][col] == 'Q') return false;
            
            // 2. Up-Left
            if (col - i >= 0 && grid[nr][col - i] == 'Q') return false;
            
            // 3. Up-Right
            if (col + i < grid.length && grid[nr][col + i] == 'Q') return false;
        }
        return true;
    }
    private void addToFinal(char [][]grid,List<List<String>>out){
        List<String>temp=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            temp.add(new String(grid[i]));
        }
        out.add(temp);
    }
}
