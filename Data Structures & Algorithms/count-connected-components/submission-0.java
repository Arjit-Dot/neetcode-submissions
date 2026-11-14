class Solution {
    public int countComponents(int n, int[][] edges) {
        //create a visited array
        boolean visited[]=new boolean[n];
        //creating a neighbour list
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(adjList,visited,i,-1);
                count++;
            }
        }
        return count;
    }
    public void dfs(List<List<Integer>> adjList,boolean []visited,int curr, int parent){
        if(visited[curr])return;
        visited[curr]=true;
        for(int child:adjList.get(curr)){
            if(child!=parent){
                dfs(adjList,visited,child,curr);
            }
        }
    }
}
