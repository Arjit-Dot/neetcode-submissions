class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int rows = grid.length;
        int cols = grid[0].length;
        
        // 1. Load the queue with treasures
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        
        int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        // 2. Expand outward
        while(!queue.isEmpty()){
            int[] currCell = queue.poll();
            int r = currCell[0];
            int c = currCell[1];
            
            for(int[] dir : directions){
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                // 3. The Bouncer: Out of bounds OR already visited / wall
                if(nr < 0 || nr >= rows || nc < 0 || nc >= cols || grid[nr][nc] != Integer.MAX_VALUE) {
                    continue;
                }
                
                // 4. Update the room and queue it
                grid[nr][nc] = grid[r][c] + 1;
                queue.add(new int[]{nr, nc});
            }
        }
    }
}