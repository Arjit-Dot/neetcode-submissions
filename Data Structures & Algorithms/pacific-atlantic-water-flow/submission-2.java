class Solution {
    int directions[][]=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>>out=new ArrayList<>();
        int rows=heights.length;
        int cols=heights[0].length;
        boolean pacific[][]=new boolean[rows][cols];
        boolean atlantic[][]=new boolean[rows][cols];
        //Go in from the left and right
        for(int r=0;r<rows;r++){
            dfs(heights,pacific,r,0,-1);
            dfs(heights,atlantic,r,cols-1,-1);
        }
        //Go from top and bottom
        for(int c=0;c<cols;c++){
            dfs(heights,pacific,0,c,-1);
            dfs(heights,atlantic,rows-1,c,-1);
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    out.add(List.of(i,j));
                }
            }
        }
        return out;
    }
    public void dfs(int [][]heights,boolean [][]ocean,int r,int c,int prevHeight){
        if(r<0 || c<0 || r==heights.length || c==heights[0].length || ocean[r][c] || heights[r][c] <prevHeight) return;
        ocean[r][c]=true;
        for(int look[]:directions){
            dfs(heights,ocean,r+look[0],c+look[1],heights[r][c]);
        }
    }
}
