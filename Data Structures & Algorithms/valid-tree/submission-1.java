class Solution {
    public boolean validTree(int n, int[][] edges) {
        //Array to keeep check of visited nodes
        boolean []visited=new boolean[n];
        //Creating adjList
        List<List<Integer>>adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        if(bfsCycle(adjList,visited))return false;
        //if(dfsCycle(adjList,visited))return false;
        return true;
    }
    public boolean bfsCycle(List<List<Integer>> adjList, boolean[] visited) {

    Deque<Integer> queue = new ArrayDeque<>();

    queue.add(0);
    visited[0] = true;

    HashMap<Integer, Integer> parents = new HashMap<>();
    parents.put(0, -1);

    while (!queue.isEmpty()) {

        int curr = queue.poll();

        for (int child : adjList.get(curr)) {

            if (!visited[child]) {
                visited[child] = true;
                queue.add(child);
                parents.put(child, curr);
            }
            else if (child != parents.get(curr)) {
                return true; // Cycle detected
            }
        }
    }
    for(int i=0;i<visited.length;i++){
        if(!visited[i])return true;
    }

    return false; // No cycle
}

}
