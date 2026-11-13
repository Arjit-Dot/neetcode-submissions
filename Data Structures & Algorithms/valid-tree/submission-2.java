class Solution {
    public boolean validTree(int n, int[][] edges) {
        //array for visited 
        boolean visited[]= new boolean[n];
        //List to store neighbors 
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        HashMap<Integer,Integer> parents=new HashMap<>();
        parents.put(0,-1);
        visited[0]=true;
        if(dfsCycle(adjList,visited,parents,0)) return false;
        for(int i=0;i<visited.length;i++){
            if(!visited[i]) return false;
        }
        return true;
    }
    public boolean dfsCycle(List<List<Integer>> adjList,boolean visited[],HashMap<Integer,Integer> parents,int curr){
        for(int child:adjList.get(curr)){
            if(!visited[child]){
                visited[child]=true;
                parents.put(child,curr);
                if(!dfsCycle(adjList,visited,parents,child)) continue;
                else return true;
            }
            else if(child !=parents.get(curr)){
                return true;
            }
            else continue;
        }
         return false;
    }
}
