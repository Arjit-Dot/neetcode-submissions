class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) { 
        // 1. Infrastructure Build
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        
        int[] pre = new int[numCourses];
        Deque<Integer> queue = new ArrayDeque<>();
        
        // 2. The Wiring
        for(int i = 0; i < prerequisites.length; i++){
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            pre[course]++;
            adjList.get(prereq).add(course);
        }
        
        // 3. Queue Startup
        for(int i = 0; i < pre.length; i++){
            if(pre[i] == 0) queue.add(i);
        }
        
        // 4. The BFS Engine
        int result = 0;
        while(!queue.isEmpty()){
            int current = queue.poll();
            result++;
            
            // Type-safe list extraction
            List<Integer> nextCourses = adjList.get(current);
            
            // Enhanced for-loop eliminates the need for .get(i) and (int) casting
            for(int nextCourse : nextCourses) {
                pre[nextCourse]--;
                if(pre[nextCourse] == 0) queue.add(nextCourse);
            }
        }
        
        // 5. The Final Verdict
        return result == numCourses;
    }
}