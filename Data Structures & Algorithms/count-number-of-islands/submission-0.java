class Solution {
    public int numIslands(char[][] grid) {
        int output=0;
        boolean visited[][]=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='0' || visited[i][j]) continue;
                output+=BFS(grid,visited,new ArrayDeque<Integer[]>(),i,j);
            }
        }
        return output;
    }
    private int BFS(char grid[][],boolean visited[][],Deque <Integer[]> queue,int row,int col){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || visited[row][col] || grid[row][col]=='0') return 0;
        visited[row][col]=true;
        queue.addLast(new Integer[]{row,col});
        BFS(grid,visited,queue,row+1,col);
        BFS(grid,visited,queue,row-1,col);
        BFS(grid,visited,queue,row,col+1);
        BFS(grid,visited,queue,row,col-1);
        queue.pop();
        if(queue.isEmpty()) return 1;
        return 0;
    }
}
