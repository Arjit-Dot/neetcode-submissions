class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea=0;
        boolean visited[][]=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j] || grid[i][j]==0) continue;
                maxArea=Math.max(maxArea,DFS(grid,visited,i,j));
            }
        }
        return maxArea;
    }
    private int DFS(int [][]grid,boolean [][]visited,int r,int c)
    {
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || visited[r][c] || grid[r][c]==0) return 0;
        visited[r][c]=true;
        int sum=
            DFS(grid,visited,r+1,c)+
            DFS(grid,visited,r-1,c)+
            DFS(grid,visited,r,c+1)+
            DFS(grid,visited,r,c-1);
        return sum+1;
    }
}
