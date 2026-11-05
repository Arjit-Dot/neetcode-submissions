class Rot implements Comparable<Rot>{
    int time;
    int coord[];

    public Rot(int row,int col,int time){
        coord=new int[]{row,col};
        this.time=time;
    }
    public int compareTo(Rot other){
        return Integer.compare(this.time,other.time);
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int maxFruit=0,timer=0;
        PriorityQueue<Rot>minHeap=new PriorityQueue<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2) minHeap.add(new Rot(i,j,0));
                else if(grid[i][j]==1)maxFruit++;
            }
        }
        int directions[][]=new int[][]{{1,0},
                                        {-1,0},
                                        {0,1},
                                        {0,-1}};
        while(!minHeap.isEmpty()){
    Rot temp = minHeap.poll();
    timer = temp.time;

    for(int look[] : directions){
        int r = temp.coord[0] + look[0];
        int c = temp.coord[1] + look[1];

        if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length){
            if(grid[r][c] == 1){
                grid[r][c] = 2;
                maxFruit--;
                minHeap.add(new Rot(r, c, temp.time + 1));
            }
        }
    }
}

if(maxFruit > 0) return -1;
return timer;
        
    }
}
